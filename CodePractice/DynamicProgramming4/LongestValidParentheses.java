/**
Q2. Longest valid Parentheses

Problem Description

Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.



Problem Constraints

1 <= length(A) <= 750000



Input Format

The only argument given is string A.



Output Format

Return the length of the longest valid (well-formed) parentheses substring.



Example Input

Input 1:

 A = "(()"
Input 2:

 A = ")()())"


Example Output

Output 1:

 2
Output 2:

 4


Example Explanation

Explanation 1:

 The longest valid parentheses substring is "()", which has length = 2.
Explanation 2:

 The longest valid parentheses substring is "()()", which has length = 4.


*/

package DynamicProgramming4;

class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		int n = s.length();
		int res = 0;
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int j = i - dp[i] - 1;
			if (j >= 0 && s.charAt(j) == '(' && s.charAt(i) == ')') {
				dp[i + 1] = dp[i] + dp[j] + 2;
				res = Math.max(dp[i + 1], res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		int ans = lvp.longestValidParentheses("(()");
		System.out.println(ans);
	}

}