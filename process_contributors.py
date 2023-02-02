import requests
import json

url = "https://api.github.com/repos/vikram-kangotra/DSalgo/stats/contributors"

response = requests.get(url)

if response.status_code != 200:
    os.exit(1)

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
            readme[i+j+3] = "| <a href='{}'><figure><img src='{}' width='32'/><br><figcaption>{}</figcaption></figure></a> | {} |".replace("\n", "").format(contributor['html_url'], 
                    contributor['avatar_url'],
                    contributor['name'], 
                    contributor['score'])
            readme[i+j+3] += "\n"

with open("README.md", "w") as f:
   f.writelines(readme)
