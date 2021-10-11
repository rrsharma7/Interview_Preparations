/**
Reverse pairs
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).

*/

package Sorting1;

class ReversePairs {

	public int solve(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 0;
		}
		return mergeSort(A, 0, A.length - 1);

	}

	public int mergeSort(int[] A, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = start + (end - start) / 2;
		int inv = mergeSort(A, start, mid);
		inv += mergeSort(A, mid + 1, end);
		inv += merge(A, start, mid, end);
		return inv;
	}

	private int merge(int[] A, int start, int mid, int end) {
		int[] result = new int[end - start + 1];
		int k = 0;
		int j = mid + 1;
		int count = 0;
		for (int i = start; i <= mid; i++) {
			while (j <= end && A[i] > (2 * (long) A[j])) {
				j++;
			}
			count += j - (mid + 1);

		}

		int left = start;
		int right = mid + 1;
		while (left <= mid && right <= end) {
			if (A[left] <= A[right]) {
				result[k] = A[left];
				left++;
			} else {
				result[k] = A[right];
				right++;
			}
			k++;
		}
		while (left <= mid) {
			result[k] = A[left];
			left++;
			k++;
		}
		while (right <= end) {
			result[k] = A[right];
			right++;
			k++;
		}

		for (int i = start; i <= end; i++) {
			A[i] = result[i - start];
		}

		return count;
	}

	public static void main(String args[]) {
		ReversePairs rp = new ReversePairs();
		int A[] = { 1, 3, 2, 3, 1 };
		int x = rp.solve(A);
		System.out.println(x);

	}
}
