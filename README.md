Projet Application OVG "On Va Geeker"
=====================================

+Git config :+
```
git config --global user.name "name"
git config --global user.email "e-mail"
git init
git remote add origin « ssh: »
git clone « https://.... »
touch .gitignore

```

+Some basic Git commands :+
```
git status
git log
git log –graph // historique

git checkout -b <ma_branche_parallele>
git branch
git branch -d <branch_name>

git tag // assigner un tag, oblige d'être sur le commit avec checkout
git tag -d <tagName> // Supprimer tag
git tag // Afficher tous les tags

git checkout –- <file_to_restore>
git checkout <n°commit>		Hachage/ empreinte SHA1 / 6 premiers char

git checkout master

git add .
git rm –-cached <name_file.extension> // supprimer fichier du cache Add
git rm -r –-cached . <folder/> // supprime dossier + contenu du cache Add
git rm -r –-cached . // supprime tous les fichiers du cache

git commit -m "edit/update comment"
git mv <file> <file_rename> // renommer 
git commit –-ammend // editer le dernier commit
git push –-force

git push -u origin master 
git push

git merge master

git pull 
```

+Some basic Unix commands :+
```
cat ~/.
cd <folder>
mkdir <folder>
ls
```

