/**
Q4. Longest Increasing Subsequence

Problem Description

Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.



Problem Constraints

0 <= length(A) <= 2500
1 <= A[i] <= 2500



Input Format

The first and the only argument is an integer array A.



Output Format

Return an integer representing the length of the longest increasing subsequence.



Example Input

Input 1:

 A = [1, 2, 1, 5]
Input 2:

 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]


Example Output

Output 1:

 3
Output 2:

 6


Example Explanation

Explanation 1:

 The longest increasing subsequence: [1, 2, 5]
Explanation 2:

 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

*/

package DynamicProgramming2;

class LongestIncreasingSubsequence {

	public int lis(final int[] A) {
		if (A.length == 1) {
			return 1;
		}
		int[] dp = new int[A.length]; // use dp to track increasing numbers
		dp[0] = 1; // initiate with 1
		int maxSubSequence = 0;
		for (int i = 1; i < A.length; i++) { // loop i start from 1
			int currentMaxSeq = 0;
			for (int j = 0; j < i; j++) { // loop J < i because we want to search increasing subsequence
				if (A[i] > A[j]) { // validate is A[i] bigger than A[j]
					currentMaxSeq = Math.max(currentMaxSeq, dp[j]); // if yes get value from dp with index j and store
																	// incurrentMaxSeq to get max value of subsequence
				}
			}
			dp[i] = currentMaxSeq + 1; // if we didn't find A[i] > A[j] by default will add 1 value
			maxSubSequence = Math.max(maxSubSequence, dp[i]); // track possible max subsequence every index of i
		}
		return maxSubSequence; // return maxSubSequence

	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int a[] = {1, 2, 1, 5};
		int ans = lis.lis(a);
		System.out.println(ans);
	}

}