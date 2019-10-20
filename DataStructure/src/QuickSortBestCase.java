

public class QuickSortBestCase
{
  public static void generate(int[] arr, int begin, int end)
  {
    int count = end - begin;
    if(count < 3)
      return;

    //Find a middle element index
    //This will be the pivot element for the part of the array [begin; end)
    int middle = begin + (count - 1) / 2;
    System.out.println(middle);
    //Make the left part best-case first: [begin; middle)
    generate(arr, begin, middle);

    //Swap the pivot and the start element
    swap(arr, begin, middle);

    //Make the right part best-case, too: (middle; end)
    generate(arr, middle + 1, end);
  }
  private static void swap(int[] arr, int i, int j)
  {
	  System.out.println(arr[i] + " " + arr[j]);
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

  private static void fillArray(int[] arr)
  {
	  arr[0] = 1;
	  arr[1] = 2;
    for(int i = 2; i != arr.length; ++i){
//    	arr[i] = arr[i - 1] + arr[i - 2];
    	arr[i] = i + 1;
    }
     
  }

  private static void printArray(int[] arr)
  {
    for(int item : arr)
      System.out.print(item + " ");
  }

  public static void main(String[] args)
  {
    
    int intCount = 10;
    int[] arr = new int[intCount];

    //We basically do what quicksort does in reverse
    //1. Fill the array with sorted values from 1 to arr.length
    fillArray(arr);
    //2. Recursively generate the best-case array for quicksort
    generate(arr, 0, arr.length);

    printArray(arr);
  }
}