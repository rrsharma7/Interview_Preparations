/**
Q3. Array 3 Pointers

Problem Description

You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints

0 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107



Input Format

First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format

Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Example Input

Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]


Example Output

Output 1:

 5
Output 2:

 1


Example Explanation

Explanation 1:

 With 10 from A, 15 from B and 10 from C.
Explanation 2:

 With 3 from A, 2 from B and 3 from C.
*/

package TwoPointers;

class Array3Pointers {

	public int minimize(final int[] A, final int[] B, final int[] C) {
		int i = 0;
		int j = 0;
		int k = 0;
		int ans = Integer.MAX_VALUE;
		while (i < A.length && j < B.length && k < C.length) {
			int x = Math.abs(A[i] - B[j]);
			int y = Math.abs(B[j] - C[k]);
			int z = Math.abs(C[k] - A[i]);

			int maxi = Math.max(x, Math.max(y, z));
			ans = Math.min(ans, maxi);

			int minval = Math.min(A[i], Math.min(B[j], C[k]));
			if (minval == A[i])
				i++;
			else if (minval == B[j])
				j++;
			else
				k++;
		}
		return ans;
	}

	public static void main(String args[]) {
		Array3Pointers a3p = new Array3Pointers();
		int[] A = { 1, 4, 10 };
		int[] B = { 2, 15, 20 };
		int[] C = { 10, 12 };
		int x = a3p.minimize(A, B, C);
		System.out.println(x);

	}
}
