/**
Q3. Matrix Chain Multiplication

Problem Description

Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].

Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

Return the minimum number of multiplications needed to multiply the chain.



Problem Constraints

1 <= length of the array <= 1000
1 <= A[i] <= 100



Input Format

The only argument given is the integer array A.



Output Format

Return an integer denoting the minimum number of multiplications needed to multiply the chain.



Example Input

Input 1:

 A = [40, 20, 30, 10, 30]
Input 2:

 A = [10, 20, 30]


Example Output

Output 1:

 26000
Output 2:

 6000


Example Explanation

Explanation 1:

 Dimensions of A1 = 40 x 20
 Dimensions of A2 = 20 x 30
 Dimensions of A3 = 30 x 10
 Dimensions of A4 = 10 x 30
 First, multiply A2 and A3 ,cost = 20*30*10 = 6000
 Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
 Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
 Total Cost = 12000 + 8000 + 6000 =26000
Explanation 2:

 Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.
*/

package DynamicProgramming4;

class MatrixChainMultiplication {

	public int solve(int[] A) {
		int n = A.length;
		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in m[][]. 0th row and 0th column of m[][] are not used
		 */
		int m[][] = new int[n][n];

		int i, j, k, L, q;

		/*
		 * m[i, j] = Minimum number of scalar multiplications needed to compute the
		 * matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is p[i-1] x p[i]
		 */

		// cost is zero when multiplying one matrix.
		for (i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (L = 2; L < n; L++) {
			for (i = 1; i < n - L + 1; i++) {
				j = i + L - 1;
				if (j == n)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					// q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}

		return m[1][n - 1];
	}

	public static void main(String[] args) {
		MatrixChainMultiplication mcm = new MatrixChainMultiplication();
		int a[] = { 40, 20, 30, 10, 30 };
		int ans = mcm.solve(a);
		System.out.println(ans);
	}

}