/**
Q5. Odd Palindrome

Problem Description

A palindrome string is a string which reads the same forward and backward. If a palindrome string is of odd length l, then (l+1)/2th character (1 index based) is said to be the centre of the palindrome.

You are given a string A. Return an array X of integers where X[i] = (number of odd length palindrome subsequence of A with A[i] as the centre) modulo (109 + 7).

A subsequence of A is a string which can be derived from A by deleting some of its character.



Problem Constraints

1 <= length(A) <= 1000
Every character of A will be a lowercase English letter 'a' - 'z'.



Input Format

First and only argument is a string A.



Output Format

Return an integer array X as mentioned in the question.



Example Input

Input 1:

 A = "xyzx"
Input 2:

 A = "ababzz"


Example Output

Output 1:

 [1, 2, 2, 1]
Output 2:

 [1, 2, 2, 1, 1, 1]


Example Explanation

Explanation 1:

 
 Index(i)  |   Palindrome subsequences with centre i
   0       |   a        
   1       |   y, xyx
   2       |   z, xzx
   3       |   x
 So, output array is [1, 2, 2, 1]

Explanation 2:

 Index(i)  |  Palindrome subsequences with centre i
   0       |  a    
   1       |  b, aba
   2       |  a, bab
   3       |  b
   4       |  z
   5       |  z
 So, output array is [1, 2, 2, 1, 1, 1]  
 
*/

package DynamicProgramming5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class OddPalindrome {

	public ArrayList<Integer> solve(String A) {
		String B = A;
		StringBuilder input1 = new StringBuilder();
		input1.append(A);
		input1 = input1.reverse();
		A = input1.toString();
		int m = B.length();
		long[][] dp = new long[m + 1][m + 1];
		long mod = 1000000007;
		for (long[] row : dp)
			Arrays.fill(row, (long) 0);
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= m; j++) {
				if (B.charAt(i - 1) == A.charAt(j - 1))
					dp[i][j] = (1 + dp[i - 1][j] % mod + dp[i][j - 1] % mod) % mod;
				else
					dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]) % mod + mod) % mod;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			ans.add(1 + (int) dp[i][m - i - 1]);
		}
		return ans;
	}

	public static void main(String[] args) {
		OddPalindrome op = new OddPalindrome();
		op.solve("xyzx");

	}

}