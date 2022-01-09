/**
Q2. Edit Distance

Problem Description

Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints

1 <= length(A), length(B) <= 450



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.



Output Format

Return an integer, representing the minimum number of steps required.



Example Input

Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
*/

package DynamicProgramming2;

class EditDistance {
	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	public int minDistance(String A, String B) {
		int m = A.length();
		int n = B.length();
		// Create a table to store results of subproblems
		int dp[][] = new int[m + 1][n + 1];

		// Fill d[][] in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, only option is
				// to insert all characters of second string
				if (i == 0)
					dp[i][j] = j; // Min. operations = j

				// If second string is empty, only option is
				// to remove all characters of second string
				else if (j == 0)
					dp[i][j] = i; // Min. operations = i

				// If last characters are same, ignore last
				// char and recur for remaining string
				else if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				// If the last character is different,
				// consider all possibilities and find the
				// minimum
				else
					dp[i][j] = 1 + min(dp[i][j - 1], // Insert
							dp[i - 1][j], // Remove
							dp[i - 1][j - 1]); // Replace
			}
		}

		return dp[m][n];
	}
	// consider all possibilities
	public static void main(String[] args) {
		EditDistance editDistance = new EditDistance();
		int ans = editDistance.minDistance("Anshuman", "Antihuman");
		System.out.println(ans);
	}

}