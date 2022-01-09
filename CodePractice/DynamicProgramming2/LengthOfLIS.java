/**
Q5. Length of LIS

Problem Description

You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.

In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.



Problem Constraints

1 ≤ length(A), A[i] ≤ 105



Input Format

The first and only argument of the input is the array A.



Output Format

Output a single integer, the length of the longest increasing subsequence in array A.



Example Input

Input 1:

A: [2, 1, 4, 3]
Input 2:

A: [5, 6, 3, 7, 9]


Example Output

Output 1:

2
Output 2:

4


Example Explanation

Explanation 1:

 [2, 4] and [1, 3] are the longest increasing sequences of size 2. 
Explanation 2:

The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.
*/

package DynamicProgramming2;

class LengthOfLIS {

	public int findLIS(final int[] A) {
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
		LengthOfLIS lis = new LengthOfLIS();
		int a[]= {2, 1, 4, 3};
		int ans = lis.findLIS(a);
		System.out.println(ans);
	}

}