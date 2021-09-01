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
 */

package sorting;
class MergeSort {
void merge(int arr[], int l, int m, int r) 
{
	int n1 = m - l + 1;
	int n2 = r - m;
	int L[] = new int[n1];
	int R[] = new int[n2];
	for (int i = 0; i < n1; ++i)
	{
		L[i] = arr[l + i];
	}
	for (int j = 0; j < n2; ++j)
	{
		R[j] = arr[m + 1 + j];
	}
	int i = 0, j = 0;
	int k = l;
	while (i < n1 && j < n2) 
	{
		if (L[i] <= R[j]) 
		{
			arr[k] = L[i];
			i++;
		} else 
		{
			arr[k] = R[j];
			j++;
		}
		k++;
	}
	while (i < n1) 
	{
		arr[k] = L[i];
		i++;
		k++;
	}
	while (j < n2) 
	{
		arr[k] = R[j];
		j++;
		k++;
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
