/**
 Inversion count in an array
Problem Description
Given an array of integers A. If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
*/

package Sorting1;

import java.util.Arrays;

class InversionCountAarray {

	private int Mod = 1000 * 1000 * 1000 + 7;
	public int solve(int[] A) {
		return sort(A, 0, A.length - 1)% Mod;
	}

	int merge(int arr[], int l, int m, int r) {
		int[] left = Arrays.copyOfRange(arr, l, m + 1);
		int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
		int i = 0, j = 0;
		int k = l, swaps = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
				swaps += (m + 1) - (l + i);
			}
			k++;
		}
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
		return swaps% Mod;
	}

	int sort(int arr[], int l, int r) {
		int count = 0;
		if (l < r) {
			int m = l + (r - l) / 2;
			count = count + sort(arr, l, m);
			count = count + sort(arr, m + 1, r);
			count = count + merge(arr, l, m, r);
		}
		return count% Mod;
	}

	public static void main(String args[]) {
		InversionCountAarray ica = new InversionCountAarray();
		int A[] = { 3, 2, 1 };
		int res = ica.solve(A);
		System.out.println(res);
	}
}
