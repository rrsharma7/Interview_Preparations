/**
 * 
	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
	Best Case Time Complexity: O(n). Best case occurs when array is already sorted.	
	Auxiliary Space: O(1)
	Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
	Sorting In Place: Yes
	Stable: Yes 
*/

// static void bubbleSort(int array[]) {
//     int size = array.length;
    
//     // loop to access each array element
//     for (int i = 0; i < size - 1; i++)
    
//       // loop to compare array elements
//       for (int j = 0; j < size - i - 1; j++)

//         // compare two adjacent elements
//         // change > to < to sort in descending order
//         if (array[j] > array[j + 1]) {

//           // swapping occurs if elements
//           // are not in the intended order
//           int temp = array[j];
//           array[j] = array[j + 1];
//           array[j + 1] = temp;
//         }
//   }
package sorting;
// Java program for implementation of Bubble Sort
class BubbleSort
{
	void bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
		for (int j = 0; j < n-i-1; j++)
		if (arr[j] > arr[j+1])
		{
		 	// swap arr[j+1] and arr[j]
			int temp = arr[j];
			arr[j] = arr[j+1];
			arr[j+1] = temp;
		}
	}

	/* Prints the array */
	void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method to test above
	public static void main(String args[])
	{
		BubbleSort ob = new BubbleSort();
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}



