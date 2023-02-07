import requests
import json
import sys
import time

url = "https://api.github.com/repos/vikram-kangotra/DSalgo/stats/contributors"

response = requests.get(url)

# The API sometimes returns a 202 status code, which means that the
# request was accepted but not yet processed. In this case, we wait
# for 5 seconds and try again 10 times.
for i in range(10):
    if response.status_code == 202:
        print("Waiting for GitHub to process the request...")
        time.sleep(5)
        response = requests.get(url)
    else:
        break

if response.status_code != 200:
    print("Error: ", response.status_code)
    sys.exit(1)

response = response.json()

contributors = []

# Formula for calculating the score
# score = additions + 2 * deletions + 2 * commits

for res in response:
    a = sum(res["weeks"][i]["a"] for i in range(len(res["weeks"])))
    d = sum(res["weeks"][i]["d"] for i in range(len(res["weeks"])))
    c = sum(res["weeks"][i]["c"] for i in range(len(res["weeks"])))
    contributor = {
        "name": res["author"]["login"],
        "score": a + 2 * d + 2 * c,
        "additions": a,
        "deletions": d,
        "commits": c,
        'html_url': res['author']['html_url'],
        'avatar_url': res['author']['avatar_url']
    }
    contributors.append(contributor)

contributors = sorted(contributors, key=lambda x: x["score"], reverse=True)

with open("README.md", "r") as f:
    readme = f.readlines()

for i, line in enumerate(readme):
    if line.startswith('## Top 3 Contributors'):
        for j, contributor in enumerate(contributors[:3]):
            readme[i+j+3] = "| <a href='{}'><figure><img src='{}' width='64'/><br><figcaption>{}</figcaption></figure></a> | {} | {} | {} | {} |".replace("\n", "").format(
                    contributor['html_url'], 
                    contributor['avatar_url'],
                    contributor['name'], 
                    contributor['additions'],
                    contributor['deletions'],
                    contributor['commits'],
                    contributor['score'])
            readme[i+j+3] += "\n"

with open("README.md", "w") as f:
   f.writelines(readme)
