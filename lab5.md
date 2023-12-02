# CSE 15L Lab Report 5

## Part 1 - Debugging Scenario
### Original Post
Hello! I don’t understanding why my grading script `grade.sh` for the `ListExample` class isn’t working properly. The grading script detects that the `merge()` and `filter()` methods do not exist in `ListExamples.java` even though the methods are clearly present. I suspect that the false result is due to the `grep` command searching for exact matches even though method parameter variable names do not matter as long as the types are correct. Here’s a screenshot of the symptoms and method signatures in `ListExample`:

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/b0d39390-ed8a-4c36-8cf2-e6b8df87a4ad)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/e1103ba8-813a-47e4-86c9-e559ea80a159)

And here’s the part of my grading script that greps for the method signatures:

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/10acf68c-e281-4a71-9665-15f63e0c907b)

---
### TA Response
Hi! I’ve noticed that in your grep commands you are searching for hard-coded parameter variable names such as `list1` or `sc`. Try using the wildcard aka `.*` when grepping for parameter variable names.

---
### Student Response (post bug-fix)
Hello again. After plugging in the `.*` option in place of the hard-coded parameter variable names in `grade.sh` my grading script worked as expected. So the bug was because of the hard coded value after all!

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/c790c666-ad33-4f34-9475-3171469c27d9)

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
