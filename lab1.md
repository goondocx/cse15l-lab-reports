# CSE 15L Lab #1 Blog
Learned about the terminal commands `cd`, `ls`, and `cat`.

## Functionalities and Demonstrations
### `cd`
No argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/4f28c918-5b91-4ed1-baf5-aefbea67d298)
- The working directory was in lecture1
- The command changes the current directory to the root directory of the device.
- The produced result is not an error.

Directory argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/1c514dea-599c-44cb-9cdb-a2ada348035d)
- The working directory was in ~
- The command with a directory as the argument changes the working directory to the directory in the argument.
- The produced result is not an error.

File argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/95897e05-5c23-4125-96b9-579b550a9f45)
- The working directory was in lecture1
- The command with a file as the argument produces an error.
- The output is an error because files are not directories and cannot be used with command `cd` "change directory"


### `ls`
No argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/ba8b9bf9-9e97-4621-8e38-f7355102f97b)
- The working directory was in lecture1
- The command prints out the names of all the files and directories that is in the working directory
- The produced result is not an error.

Directory argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/d7886cea-8c54-435c-a91b-5232afffc3d2)
- The working directory was in lecture1
- The command with a directory as the argument prints out the names of all the files and directories that is in the arguemnt directory.
- The produced result is not an error.

File argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/ceb4c206-3d8f-4734-ba82-9f4e4fa4f54e)
- The working directory was in lecture1
- The command with a file as the argument just prints out the name of the argument file.
- The produced result is not an error.


### `cat`
No argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/ca2356d6-c83d-44c8-b722-1bd1b9b052f3)
- The working directory was in lecture1
- The command produces no result.
- There is nothing printed in the terminal because the `cat` command reads the files in the file argument, and there was no argument to read from.

Directory argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/48c5392a-69b0-4c2f-8bab-5535cc51defe)
- The working directory was in lecture1
- The command with a directory as the argument produces an error.
- The output is an error because directories contain no direct file content(eg. texts in a .txt file), so there's nothing for the command to print.

File argument
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/1af83dcd-59ba-4cc8-a655-294caad5609d)
- The working directory was in lecture1
- The command with a file as the argument prints out the contents of the file.
- The produced result is not an error.
- Another example:
- ![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/d4d8b319-20f5-43eb-88c4-24ace3797f95)
- "Hello World" is printed in the French language.
