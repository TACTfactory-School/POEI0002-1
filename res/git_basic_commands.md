Basic Commands Git shell 
========================

__Git config :__
```
git config --global user.name "name"		# Set Name
git config --global user.email "e-mail"		# Set Email
git init					# Initialize
git remote add origin « ssh: »			# Add 
git clone « https://.... »			# Clone From a repository
touch .gitignore				# Create file .gitignore

```

__Some basic Git commands :__
```
git status					# Show position & changed files
git log						# Show commits log
git log --oneline --decorate --graph		# History log & graph

git checkout -b <ma_branche_parallele>		# Create branch and step into
git branch 					# List existing branch ***--list***
git branch -d <branch_name>			# Delete branch ***Dont be on it***

git tag <tag_name>				# Define tag ***Must be on the commit***
git tag -d <tagName> 				# Delete tag
git tag 					# List all tags

git checkout –- <file_to_restore>		# Restore deleted file
git checkout -- .				# Restore all manual deleted files
git checkout <n°commit>				# DeLorean SHA1 ***6 first char or tag***

git checkout master				# Move to master branch

git add .					# Add all modified files
git add *.exention *.extension2			# Add all specidied extension files


git rm –-cached <name_file.extension> 		# Remove file from cached pre-save
git rm -r –-cached . <folder/> 			# Remove folder & content from cached pre-save
git rm -r –-cached . 				# Delete all files from cached pre-save

git commit -m "edit/update comment"		# Commit without core editor
git mv <file> <file_rename>			# Rename last commit file
git commit –-ammend				# Rewriting last commit message
git push –-force				# Amending message of the most recently pushed commit

git push -u origin master 			# Push files & set the uptstream on the current local branch
git push 					# Push all files

git merge <branch_name>				# Merge branch on master ***Should be on master branch***
git merge <local>:<destination>			# Merge branch local on destination
git pull 					# Fetch from repository
```

__Some basic Unix commands :__
```
cat ~/.
cd <folder>
mkdir <folder>
ls
```

_©2019 author @ C-ambium_
