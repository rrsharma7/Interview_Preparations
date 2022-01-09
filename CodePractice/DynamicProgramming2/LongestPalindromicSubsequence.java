/**
Q1. Longest Palindromic Subsequence

Problem Description

Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.



Problem Constraints

1 <= length of(A) <= 103



Input Format

First and only integer is a string A.



Output Format

Return an integer denoting the length of longest palindromic subsequence.



Example Input

Input 1:

 A = "bebeeed"
Input 2:

 A = "aedsead"


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 The longest palindromic subsequence is "eeee", which has a length of 4.
Explanation 2:

 The longest palindromic subsequence is "aedea", which has a length of 5.
*/

package DynamicProgramming2;

class LongestPalindromicSubsequence {

	public int solve(String A) {
		char[] X = A.toCharArray();
		char[] Y = new StringBuilder(A).reverse().toString().toCharArray();
		int m = X.length;
		int n = Y.length;
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		int ans = lps.solve("bebeeed");
		System.out.println(ans);
	}

}