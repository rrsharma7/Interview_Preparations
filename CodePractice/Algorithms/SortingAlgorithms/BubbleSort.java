/**
 * 
	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.	
	Auxiliary Space: O(1)
	Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
	Sorting In Place: Yes
	Stable: Yes 

*/

package sorting;
class BubbleSort {
  
  static void bubbleSort(int arr[], int n) 
  {
    int i, j, temp;
    boolean swapped;
    for (i = 0; i < n - 1; i++) 
    {
      swapped = false;
        for (j = 0; j < n - i - 1; j++) 
        {
          if (arr[j] > arr[j + 1]) 
          {
            temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
          }
        }
        if (swapped == false)
          break;
    }
  }

  static void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) {
    int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
    int n = arr.length;
    bubbleSort(arr, n);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}

