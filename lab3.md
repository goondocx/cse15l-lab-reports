# CSE 15L Lab Report 3

## Part 1 - Bugs
1. Failure inducing input
```
@Test
  public void testReverseInPlace2()
  {
    int[] input = {1, 2, 3, 4, 5};
    ArrayExamples.reverseInPlace(input);
    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, input);
  }
```
2. Non-failure inducing input
```
@Test
  public void testReverseInPlace3()
  {
    int[] input = {1, 2, 3, 2, 1};
    ArrayExamples.reverseInPlace(input);
    assertArrayEquals(new int[]{1, 2, 3, 2, 1}, input);
  }
```
3. Symptom

![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/2fe5e0f1-6aed-4860-a802-de64302c1245)

4. Original Code (with bugs)
```
static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```
5. Fixed Code
```
static void reverseInPlace(int[] arr) 
  {
    int[] temp = new int[arr.length];
    for(int i = 0; i < arr.length; i++)
    {
      temp[i] = arr[i];
    }
    for(int i = 0; i < arr.length; i += 1) 
    {
      arr[i] = temp[arr.length - i - 1];
    }
  }
```
The fix addresses the original code's main issue of setting the second half of the array to the already reversed first half, which results in a sort of mirrored/palindrome array rather than a reversed array. The fix addresses this issue by creating a temporary copy of the target array `arr`, which is then used to reverse `arr` with a for loop that loops through `temp` from the end.


## Part 2 - Researching Commands (`grep`)
### Option `-i`
Example 1
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -i "police" 911report/*.txt > grep_result911.txt

honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ wc grep_result911.txt
  102  1513 13013 grep_result911.txt
```
The option `-i` ignores case distinctions in patterns and input data such that both upper and lower case varieties of the search terms are included. This is very useful because if a user is trying to perform a blanket search of a specific term, the result won't exclude potentially uppercased versions of the term and thus returning a lower count than intended.

Example 2
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -i "gnrh" biomed/*.txt > grep_resultbm.txt

honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ wc grep_resultbm.txt
  148  1400 13135 grep_resultbm.txt
```
In this case the `-i` option is especially useful in the hypothetical situation that we do not know the capitalization of the biomedical term "GnRH", therefore we can just use `-i` to blanket search for the term "gnrh" while ignoring the capitalization. In this case the option is useful when grepping for professional jargons.

### Option `-v`
Example 1
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -v "standard" biomed/1471-2180-3-11.txt >grep_inversebio.txt

honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ wc grep_inversebio.txt 
  935  4941 37246 grep_inversebio.txt
```
The option `-v` is useful when it comes to excluding lines that contain a certain search term, or in the context of this example the any lines in `biomed/1471-2180-3-11.txt` containing the term "standard" are eliminated from the grep result. This is useful in certain situations that, for example, during the analysis of anomalous data sets, which calls for the weeding out of all the standard data sets.

Example 2
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -e "death" -e "addiction" government/Alcohol_Problems/Session3-PDF.txt > grep_inverseTriggerTerm.txt
```
The option `-v` can also be used to eliminate certain trigger terms from documents such as articles, news, or medical documents that contains terms that might be graphic or offensive to certain individuals. In this example we used the option to eliminate the term "death" from a document about alcohol abuse. The original document had 4 occurrences of the term, but the grepped document has none.

Original Document (with trigger term)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/419cad17-4992-461a-a9b5-7fc4da040d85)


Augmented Document (trigger term excluded)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/23f21b10-5526-4351-b059-834ec46444a7)

### Option `-e`
Example 1
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -i  -e "polymerase" -e "hiv" biomed/1471-2091-3-18.txt > grep_multipleBM.txt

honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ wc grep_multipleBM.txt
  77  698 4880 grep_multipleBM.txt
```
The option `-e` is an especially useful one as it allows the `grep` command to search for multiple terms in a file, thus eliminating the hassle of searching for one term at a time. In this example, the command greps all the lines that contain either terms "polymerase" or "hiv" and outputs the result into anothe text file.

Example 2
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -i -v -e "death" -e "addiction" government/Alcohol_Problems/Session3-PDF.txt > grep_multipleAlc.txt
```
Continuing from Example 2 of option `-v`, what happens when you need to exclude more than just one trigger terms? The regular `grep` command can only exclude one term at a time so you'll still have to deal with other trigger words. But with the `-e` option, we can exclude both "death" and "addiction" from the document, instead of one of them.

Original Document
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/9841b363-ea03-48ef-94c3-551bb15c1f29)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/a429cede-f595-4de3-beab-dfb96167d4a4)

Augmented Document
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/93e4c24e-b4bb-4af7-a1c2-8dc6539d86a8)
![image](https://github.com/goondocx/cse15l-lab-reports/assets/100145953/fc147d4a-311c-477d-91f4-1836cfedc4cf)

### Option `-c`
Example 1
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -c -i  -e "gene" -e "gnrh" biomed/1471-2105-3-26.txt
101
```
The option `-c` suppresses the normal output and instead prints a count of matching lines for each input file. This command can be especially useful when working with very large sets of data where individual pieces of information aren't of great significance but rather the trend of the dataset. In this example we grepped for lines that contain either terms "gene" or "gnrh" regardless of their capitalization in a specific biomed document. But a potentially better use of this option would be, for example, a sales analyst having to decide if a particular product/products are generating enough sales, from the entire sales history of their platform in the form of a text file. In this case they can grep for lines that contains either product names with `-c`.

Example 2
```
honjo@SKRM-Terminal MINGW64 ~/OneDrive/Desktop/CSE 15L/docsearch/technical (main)
$ grep -i -c "information" 911report/chapter-8.txt
63
```
In this example, the `-c` command counts the number of lines that contain the term "information" from a 9/11 document. Another good use of this command option could be vocabulary diversity analysis, for example, for an academic paper. If there are too many lines containing the exact same vocabulary, maybe it's time to look up some synonyms.

## Sources
1. https://man7.org/linux/man-pages/man1/grep.1.html (`grep`, `-i`, `-v`, `-c`)
2. https://phoenixnap.com/kb/grep-multiple-strings (`-e`)
