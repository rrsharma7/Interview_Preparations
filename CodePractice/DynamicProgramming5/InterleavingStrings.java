/**
Q2. Interleaving Strings

Problem Description

Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints

1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.



Output Format

Return 1 if string C is formed by interleaving of A and B else 0.



Example Input

Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
Explanation 2:

 It is not possible to get C by interleaving A and B.

*/

package DynamicProgramming5;

class InterleavingStrings {

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();

		if (len1 + len2 != len3) {
			return false;
		}

		boolean[][] dp = new boolean[len2 + 1][len1 + 1];
		// basic case
		dp[0][0] = true;

		// filling the first row in the 2D matrix boolean dp matrix by iterating j in
		// column
		for (int j = 1; j < dp[0].length; j++) {
			// left side value
			dp[0][j] = dp[0][j - 1] && (s1.charAt(j - 1) == s3.charAt(j - 1));
		}
		// filling the first column in the 2D matrix boolean dp matrix by iterating i in
		// row
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
		}

		//
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))
						|| dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		return dp[len2][len1];
	}

	public static void main(String[] args) {
		InterleavingStrings istr = new InterleavingStrings();
		boolean ans = istr.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		System.out.println(ans);
	}

}