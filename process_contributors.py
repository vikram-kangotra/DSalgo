import json

with open('contributors.json', 'r') as f:
    contributors = json.load(f)

with open("README.md", "r") as f:
    readme = f.read()

new_readme = ""

for line in readme.splitlines():
    if line.startswith('## Top 3 Contributors'):
        new_readme += line + "\n"
        for contributor in contributors[:3]:
            new_readme += f"- ![alt text](contributor['avatar_url'])[{contributor['login']}]({contributor['html_url']}) ({contributor['contributions']})" + "\n"

    else:
        new_readme += line + "\n"

with open("README.md", "w") as f:
    f.write(new_readme)
