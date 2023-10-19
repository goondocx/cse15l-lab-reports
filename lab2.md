# CSE 15L Lab #2 Blog
## StringServer Code
```
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
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/cabf35e1-3011-46b5-a758-976f56ea208a)
1. The main method and handler, also the `.getPath()` and `.getQuery()` methods, which obtains the corresponding parts of the URL to determine which commands to run.
2. Relevant arguments and fields include `"/add-message"` which specified what the program should look for in the URL, and `.split("=")`, which obtains the string after the = sign to update the string in the server, which is called `list`.
3. The relevant fields that were changed from this specific request are `String list` which keeps track of the server's string and `int numList`, which controls the number before each new string. From this specific request, the String list changed from `""` to `"1. Hello"`

## Screenshot #2
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/1c62616b-1fe4-4b55-9684-0cec8156849f)
