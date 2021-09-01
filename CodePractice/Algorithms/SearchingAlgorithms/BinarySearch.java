/**
	Time Complexity: T(n) = T(n/2) + c  -> Theta(Logn)
	Space Complexity: Worst Case : O(1)
*/
package SearchingAlgorithms;
class BinarySearch {
	int binarySearch(int arr[], int l, int r, int searchElement) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == searchElement)
				return mid;
			if (arr[mid] > searchElement)
				return binarySearch(arr, l, mid - 1, searchElement);
			// Else the element can only be present
			// in right subarray
			return binarySearch(arr, mid + 1, r, searchElement);
		}
		return -1;
	}

	public static void main(String args[]) {
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = ob.binarySearch(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index=" + result);
	}
}
