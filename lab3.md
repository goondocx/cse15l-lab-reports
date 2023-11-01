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
