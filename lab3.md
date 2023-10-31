# CSE 15L Lab Report 3

## Part 1
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
