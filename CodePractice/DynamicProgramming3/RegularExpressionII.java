/**
Q1. Regular Expression II

Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aab"
 B = "c*a*b"
Input 2:

 A = "acz"
 B = "a.a"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 So, return 1.
Explanation 2:

 '.' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.

*/

package DynamicProgramming3;

class RegularExpressionII {

	public int isMatch(final String text, final String pattern) {
		int dp[][] = new int[text.length() + 1][pattern.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= pattern.length(); i++) {
			if (pattern.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}
		for (int i = 1; i <= text.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {
				if (pattern.charAt(j - 1) == '.' || text.charAt(i - 1) == pattern.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					if (dp[i][j - 2] == 1) {
						dp[i][j] = 1;
					} else {
						if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
							dp[i][j] = dp[i - 1][j];
						}
					}
				}
			}
		}
		return dp[text.length()][pattern.length()];
	}

	public static void main(String[] args) {
		RegularExpressionII rexp2 = new RegularExpressionII();
		int ans = rexp2.isMatch("aab", "c*a*b");
		System.out.println(ans);
	}

}