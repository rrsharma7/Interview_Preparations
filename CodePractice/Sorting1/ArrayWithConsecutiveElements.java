/**
Array with consecutive elements
Problem Description

Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return 1 if the array elements are consecutive else return 0.



Example Input
Input 1:

 A = [3, 2, 1, 4, 5]
Input 2:

 A = [1, 3, 2, 5]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 As you can see all the elements are consecutive, so we return 1.
Explanation 2:

 Element 4 is missing, so we return 0.

*/

package Sorting1;

class ArrayWithConsecutiveElements {

	/* Method return minimum value */
	private int getMinimum(int arr[], int n) {
		int min = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	/* Method return maximum value */
	private int getMaximum(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	public int solve(int[] A) {
		int n = A.length;
		if (n < 1)
			return 0;

		int min = getMinimum(A, n);
		int max = getMaximum(A, n);

		if (max - min + 1 == n) {
			boolean[] visited = new boolean[A.length];
			for (int i = 0; i < n; i++) {
				if (visited[A[i] - min] != false)
					return 0;

				visited[A[i] - min] = true;
			}

			return 1;
		}
		return 0;
	}

	public static void main(String args[]) {
		ArrayWithConsecutiveElements mad = new ArrayWithConsecutiveElements();
		int A[] = { 3, 2, 1, 4, 5 };
		int x = mad.solve(A);
		System.out.println(x);

	}
}
