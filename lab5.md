# CSE 15L Lab Report 5

## Part 1 - Debugging Scenario
### Original Student Post
Hello! I don’t understanding why my grading script `grade.sh` for the `ListExample` class isn’t working properly. The grading script detects that the `merge()` and `filter()` methods do not exist in `ListExamples.java` even though the methods are clearly present. I suspect that the false result is due to the `grep` command searching for exact matches even though method parameter variable names do not matter as long as the types are correct. Here’s a screenshot of the symptoms and method signatures in `ListExample`:

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/3c1918aa-85dc-40da-8cd7-c21c39428937)

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/e1103ba8-813a-47e4-86c9-e559ea80a159)

And here’s the part of my grading script that greps for the method signatures:

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/10acf68c-e281-4a71-9665-15f63e0c907b)

---
### TA Response
Hi! I’ve noticed that in your grep commands you are searching for hard-coded parameter variable names such as `list1` or `sc`. Try using the wildcard aka `.*` when grepping for parameter variable names.

---
### Student Response (post bug-fix)
Hello again. After plugging in the `.*` option in place of the hard-coded parameter variable names in `grade.sh` my grading script worked as expected. So the bug was because of the hard coded value after all!

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/84ab4cc0-aec9-4eb7-87ec-2a97c9db6f56)

---
### Setup Informations (Directory structure, Codes, Command line, Bug fixes)
1. File & Directory Structure:
```
list-examples-grader
- grading-area/
  - lib/
    - hamcret-core-1.3.jar
    - junit-4.13.2.jar
  - ListExamples.java
  - TestListExamples.java
- grade.sh
```


2. Content of `grade.sh` before bug fix
```
# checks if filter exists with correct sigs
if [[ `grep -c 'static List<String> filter(List<String> s, StringChecker sc)' grading-area/ListExamples.java` == 1 ]]
then
    echo "method filter() exists in ListExamples.java."
else
    echo "method filter() does not exist."
fi

# checks if merge exists with correct sigs
if [[ `grep -c 'static List<String> merge(List<String> list1, List<String> list2)' grading-area/ListExamples.java` == 1 ]]
then
    echo "method merge() exists in ListExamples.java."
else
    echo "method merge() does not exist."
fi
```


3. Command line execution
   
  `bash grade.sh` with working directory in `list-examples-grader/`


4. Bug fixes

  Replaced the parameter variable names `s`, `sc`, `list1` and `list2` with wildcard option `.*`

---
## Reflection
The one thing that definitely takes the first place for me is learning how to use vim to edit files remotely. For example, instead of having to clone a file from a remote server such as ieng6 onto your local machine, edit it in a standard text editor like VS Code, and then uploading it back, we can just use vim to edit it directly in ieng6. And what took me by surprise is how incredibly convenient it is to use vim, despite my worries about not being able to use a mouse to jump around the file. I can instead just use `:[line-number]` to jump around in a long file. And what's even better is that if you know exactly where the error is you don't even have to scroll down to the error at all, instead just entering a single command to replace anything you want.
