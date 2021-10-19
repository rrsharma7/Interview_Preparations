/**
 * Sorted Insert Position
Problem Description

Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 106



Input Format
First argument is an integer array A of size N.
Second argument is an integer B.



Output Format
Return an integer denoting the index of target value.



Example Input
Input 1:

A = [1, 3, 5, 6]
 B = 5
Input 2:

A = [1]
 B = 1


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

The target value is present at index 2.
Explanation 2:

The target value is present at index 0.
 */
package SearchingI;

public class SortedInsertPosition {

	public int searchInsert(int[] A, int B) {
		return binarySearch(A, 0, A.length - 1, B);
	}

	private int binarySearch(int arr[], int left, int right, int B) {
		if (right >= left) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == B) {
				return mid;
			}
			if (arr[mid] > B)
				return binarySearch(arr, left, mid - 1, B);
			return binarySearch(arr, mid + 1, right, B);

		}
		return right+1;
	}

	public static void main(String[] s) {
		SortedInsertPosition asp = new SortedInsertPosition();
		int A[] = { 1, 3, 5, 6 };
		int res = asp.searchInsert(A, 7);
		System.out.println(res);

	}
}
