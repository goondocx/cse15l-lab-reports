# CSE 15L Lab #2 Blog


## Part 1
### StringServer Code
```java
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler 
{
    String list = "";
    int numList = 1;

    public String handleRequest(URI url) 
    {
        if (url.getPath().equals("/")) 
        {
            return list;
        } 
        else 
        {
            if (url.getPath().contains("/add-message")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) 
                {
                    list += numList + ". " + parameters[1] + "\n";
                    numList++;
                    return list;
                }
            }
            return "404 Not Found!";
        }
    }
}

class StringServer 
{
    public static void main(String[] args) throws IOException 
    {
        if(args.length == 0)
        {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```
## Screenshot #1
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/56b807f6-a666-4b8f-992e-6013d0aef023)
1. The main method and handler, also the `.getPath()` and `.getQuery()` methods, which obtains the corresponding parts of the URL to determine which commands to run.
2. Relevant arguments and fields include `"/add-message"` which specified what the program should look for in the URL, and `.split("=")`, which obtains the string after the = sign to update the string in the server, which is called `list`.
3. The relevant fields that were changed from this specific request are `String list` which keeps track of the server's string and `int numList`, which controls the number before each new string. From this specific request, the String list changed from `""` to `"1. Hello"` since the input after `/add-message?s=` is "Hello".

## Screenshot #2
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/ad1c9bcf-f402-4de2-9334-7c130f55774d)
1. Same as screenshot #1
2. Same as screenshot #1
3. The relevant fields that were changed from this specific request are `String list` which keeps track of the server's string and `int numList`, which controls the number before each new string. From this specific request, the String list changed from `""` to `"2. This is jason"` since the input after `/add-message?s=` is "This is jason".


## Part 2
1. Private Key (On lab computer)

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/9b4982ee-bd5c-43c5-a012-149fa72a6bed)



3. Public Key (On ieng6 server)

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/68e155ca-3f47-438d-a64d-f622491537d4)



5. Logging in ieng6 without password

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/89da8302-0908-4250-bf9a-96e2712c0531)


## Part 3
What I learned from the labs:
1. A lot of terminal commands such as `ls`, `cat`, `ssh`, `scp`, and `mkdir` that I did not know before, such as how `ssh` connects you to a server or how you can make a "folder" with `mkdir` instead of having to use the right click menu in file explorer.
2. Something that I think is very cool, the command `scp` which securely copies the private login key from personal computers into servers so that we don't have to enter the password everytime I want to log into ieng6, which saves a lot of time.
