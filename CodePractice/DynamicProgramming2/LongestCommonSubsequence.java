/**
Q3. Longest Common Subsequence

Problem Description

Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.



Problem Constraints

1 <= Length of A, B <= 1005



Input Format

First argument is a string A.
Second argument is a string B.



Output Format

Return an integer denoting the length of the longest common subsequence.



Example Input

Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
Input 2:

 A = "aaaaaa"
 B = "ababab"


Example Output

Output 1:

 5
Output 2:

 3


Example Explanation

Explanation 1:

 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:

 The longest common subsequence is "aaa", which has a length of 3.
*/

package DynamicProgramming2;

class LongestCommonSubsequence {

	public int solve(String A, String B) {
		char X[] = A.toCharArray();
		char Y[] = B.toCharArray();
		int m = A.length();
		int n = B.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[j-1][i]);
				}
			}

		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int ans = lcs.solve("aaaaaa", "ababab");
		System.out.println(ans);
	}

}