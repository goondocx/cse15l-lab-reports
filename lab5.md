# CSE 15L Lab Report 5

## Part 1 - Debugging Scenario
1. grep filter method registering unmatching parameter variables as incorrect, even though it does not matter

   Screenshot:

   ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/2ecc4a9a-48a3-4860-b8e0-f208317094a5)

3. Suggest to try globbing with .*
4. File structure:
```
list-examples-grader
- grading-area/
  - lib/
    - hamcret-core-1.3.jar
    - junit-4.13.2.jar
  - IsMoon.class
  - ListExamples.java
  - ListExamples.class
  - StringChecker.class
  - TestListExamples.java
  - TestListExamples.class
  - testResults.txt
- grade.sh
```
5. Command line commands:
6. bash grade.sh
