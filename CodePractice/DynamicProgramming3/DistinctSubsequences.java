/**
Q2. Distinct Subsequences

Problem Description

Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).



Problem Constraints

1 <= length(A), length(B) <= 700



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format

Return an integer representing the answer as described in the problem statement.



Example Input

Input 1:

 A = "abc"
 B = "abc"
Input 2:

 A = "rabbbit" 
 B = "rabbit" 


Example Output

Output 1:

 1
Output 2:

 3


Example Explanation

Explanation 1:

 Both the strings are equal.
Explanation 2:

 These are the possible removals of characters:
    => A = "ra_bbit" 
    => A = "rab_bit" 
    => A = "rabb_it"

 Note: "_" marks the removed character.
*/

package DynamicProgramming3;

class DistinctSubsequences {

	public int numDistinct(String s, String t) {
		int slen = s.length();
		int tlen = t.length();

		if (tlen > slen) {
			return 0;
		}

		int[][] dp = new int[tlen + 1][slen + 1];

		for (int i = 0; i <= tlen; i++) {
			for (int j = 0; j <= slen; j++) {
				if (i == 0) {
					dp[i][j] = 1;
				} else if (j < i) {
					dp[i][j] = 0;
				} else {
					if (s.charAt(j - 1) == t.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		return dp[tlen][slen];
	}

	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		int ans = ds.numDistinct("rabbbit", "rabbit");
		System.out.println(ans);
	}

}