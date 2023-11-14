# CSE 15L Lab Report 4

## Step 4 - Logging into ieng6
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/678b56d8-2483-425a-a31d-294b51575297)

### Keystrokes:
`<up><enter>`

### Commands Summary:
I pressed the `<up>` key to cycle up since `ssh` was the previous command that I ran. This command connects my local terminal to the ieng6 computer.


## Step 5 - Clone Fork Repository from GitHub Account
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/4fa86fe0-8ae8-4e15-8d6e-6816d7459dc4)


### Keystrokes:
`git clone git@github.com:goondocx/lab7.git<enter>`

### Commands Summary:
Since this command was not in my commands history, I had to type all of it out then press `<enter>` to run it. This command SSH clones the forked directory from my user account into the current working directory on `ieng6`.


## Step 6 - Run Tests, Failed
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/541e7f56-1923-45ff-aedb-5170adf46a22)


### Keystrokes:
`cd lab7<enter>`,

`javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java<enter>`,

`java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ListExamplesTests<enter>`

### Commands Summary:
The `cd` command changes the working directory to `lab7`, where all of the `.java` files we have to compile are. The `javac` command compiles all the `.java` files given the JUnit and Hamcrest dependencies, and the `java` command runs the `ListExamplesTests.class` file generated from compiling in order to run the tests for `ListExamples.java`. All the commands were executed by pressing the `<enter>` key.

## Step 7 - Edit/Fix Code
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/3867e014-ad77-472d-9a18-9a0c7afd3174)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/897b0822-c4f1-4c88-a3e7-fead03f7e294)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/a49d5b0b-523f-469e-b7f2-a36b76b042e2)

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/5426e699-226c-40d8-aa66-6a20f2e6ba03)

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/de7262c4-98d5-4b40-a5b6-4361228789b7)

### Keystrokes:
`vim ListExamples.java`,

`<shift><;>44s/1/2<enter>`,

`<shift><;>wq<enter>`

### Commands Summary:
The `vim` command open the `ListExamples.java` in the vim editor, for which we enter the command `:44s/1/2` which basically replaces the first occurrence of `1` on line 44 with `2`. The `:wq` command then saves the changes and exits the vim editor. We press `<enter>` to execute the commands.

## Step 8 - Run Tests, Success
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/ddde9da1-96c1-4613-8fd7-027f86c95130)


### Keystrokes:
`<up><up><up><up><enter>`,

`<up><up><up><up><enter>`

### Commands Summary:
Since the `javac` command is 4 up in the search history, I pressed the up arrow 4 times and then `<enter>` to access it. Same was done for the `java` command.

## Step 9 - Commit and Push Changes to GitHub
### Screenshot:
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/c3f7b14f-dc89-4db7-a520-86c493ff682c)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/a605f117-d194-4b1e-9f30-9c1ecd5ddddd)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/38345e73-bbfc-4135-b5ef-1e2a5e3f9bbf)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/1861ac88-58c5-4610-a286-502421858b57)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/240237a1-17d5-4953-9f77-836d1377e5bf)


### Keystrokes:
`git add ListExamples.java<enter>`,

`git commit<enter>`,

`<i>Fixed ListExamples.java<ESC><shift><;>wq<enter>`,

`git push<enter>`

### Commands Summary:
The `git add` command basically stages the `ListExamples.java` file to be committed by `git commit`, which then we edit the commit message `"Fixed ListExamples.java"` with `<i>` and save with `:wq`. The command `git push` is then used to push those changes from ieng6 to the actual GitHub account where the forked repository is.
