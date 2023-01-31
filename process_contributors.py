import json

with open('contributors.json', 'r') as f:
    contributors = json.load(f)

with open("README.md", "r") as f:
    readme = f.readlines()

for i, line in enumerate(readme):
    if line.startswith('## Top 3 Contributors'):
        for j, contributor in enumerate(contributors[:3]):
            readme[i+j+1] = """
- <a href='{}'>
    <figure>
        <img src='{}' width='32' style='border-radius:50%'/>
            <figcaption>
                {} ({})
            </figcaption>
    </figure>
</a>""".replace("\n", "").format(contributor['html_url'], 
                    contributor['avatar_url'],
                    contributor['login'], 
                    contributor['contributions'])
            readme[i+j+1] += "\n"


with open("README.md", "w") as f:
    f.writelines(readme)
