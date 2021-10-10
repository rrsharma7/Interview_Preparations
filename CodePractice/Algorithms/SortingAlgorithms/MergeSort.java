/**
   	MergeSort(arr[], l,  r)
   	
	If r > l
	
	 1. Find the middle point to divide the array into two halves:  
	         middle m = l+ (r-l)/2
	 2. Call mergeSort for first half:   
	         Call mergeSort(arr, l, m)
	 3. Call mergeSort for second half:
	         Call mergeSort(arr, m+1, r)
	 4. Merge the two halves sorted in step 2 and 3:
	         Call merge(arr, l, m, r)
	                
     Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm and time complexity can be expressed as 
     following recurrence relation. 
     T(n) = 2T(n/2) + θ(n) = O(NlogN)
     The above recurrence can be solved either using the Recurrence Tree method or the Master method. It falls in case II of Master Method 
     and the solution of the recurrence is θ(nLogn). Time complexity of Merge Sort is θ(nLogn) in all 3 cases (worst, average and best) as merge 
     sort always divides the array into two halves and takes linear time to merge two halves.
     Auxiliary Space: O(n)
     Algorithmic Paradigm: Divide and Conquer
        
     Best Case : O(nlogn)
     Average Case : O(nlogn)
     Worst Case : O(nlogn)  
     Space Complexity: Worst Case : O(n)
 */

package sorting;
class MergeSort {
void merge(int arr[], int l, int m, int r) 
{
	int[] left = Arrays.copyOfRange(arr, l, m + 1);
	int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
	int i = 0, j = 0;
	int k = l;
	while (i < left.length && j < right.length) {
		if (left[i] <= right[j]) {
			arr[k] = left[i];
			i++;
		} else {
			arr[k] = right[j];
			j++;
		}
		k++;
	}
	while (i < left.length) {
		arr[k++] = left[i++];
	}
	while (j < right.length) {
		arr[k++] = right[j++];
	}
}
void sort(int arr[], int l, int r) 
{
	if (l < r) 
	{
		int m = l + (r - l) / 2;
		sort(arr, l, m);
		sort(arr, m + 1, r);
		merge(arr, l, m, r);
	}
}
static void printArray(int arr[]) {
	int n = arr.length;
	for (int i = 0; i < n; ++i)
		System.out.print(arr[i] + " ");
	System.out.println();
}
public static void main(String args[]) {
	int arr[] = { 12, 11, 13, 5, 6, 7 };
	printArray(arr);
	MergeSort ob = new MergeSort();
	ob.sort(arr, 0, arr.length - 1);
	System.out.println("\nSorted array");
	printArray(arr);
}
}
