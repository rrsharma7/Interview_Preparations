/**
Q2. Min Sum Path in Matrix

Problem Description

Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints

1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000



Input Format

First and only argument is a 2-D grid A.



Output Format

Return an integer denoting the minimum sum of the path.



Example Input

Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output

Output 1:

 8
Output 2:

 -1


Example Explanation

Explanation 1:

 The path will be: 1 -> 3 -> 2 -> 1 -> 1.
Input 2:

 The path will be: 1 -> -3 -> 5 -> -5 -> 1.
*/

package DynamicProgramming2;

class MinSumPathMatrix {

	public int minPathSum(int[][] A) {

		int sum = A[A.length - 1][A[0].length - 1];
		for (int i = A[0].length - 2; i >= 0; i--) {
			sum += A[A.length - 1][i];
			A[A.length - 1][i] = sum;
		}
		sum = A[A.length - 1][A[0].length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			sum += A[i][A[0].length - 1];
			A[i][A[0].length - 1] = sum;
		}

		for (int i = A.length - 2; i >= 0; i--) {
			for (int j = A[0].length - 2; j >= 0; j--) {
				A[i][j] = A[i][j] + Math.min(A[i + 1][j], A[i][j + 1]);
			}
		}

		return A[0][0];

	}

	public static void main(String[] args) {
		MinSumPathMatrix minSumPathMatrix = new MinSumPathMatrix();
		int a[][] = { { 1, 3, 2 }, { 4, 3, 1 }, { 5, 6, 1 } };
		int ans = minSumPathMatrix.minPathSum(a);
		System.out.println(ans);
	}

}