/**
Q4. Russian Doll Envelopes

Problem Description

Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints

1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109



Input Format

The only argument given is the integer matrix A.



Output Format

Return an integer denoting the maximum number of envelopes you can put one inside other.



Example Input

Input 1:

 A = [ 
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]  
     ]
Input 2:

 A = [     '
         [8, 9]
         [8, 18]    
     ]


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:

 No envelopes can be put inside any other so answer is 1.

*/

package DynamicProgramming4;

import java.util.Arrays;

class RussianDollEnvelopes {

	public int solve(int[][] A) {
		int omax = 0;
		Arrays.sort(A, (a, b) -> (a[0] - b[0]));
		int[] dp = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i][0] > A[j][0] && A[i][1] > A[j][1]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
			omax = Math.max(omax, dp[i]);
		}

		return omax;
	}

	

	public static void main(String[] args) {
		RussianDollEnvelopes rde = new RussianDollEnvelopes();
		int a[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int ans = rde.solve(a);
		System.out.println(ans);
	}

}