/**
Q1. N digit numbers

Problem Description

Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.

Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007



Problem Constraints

1 <= A <= 1000

1 <= B <= 10000



Input Format

First argument is the integer A

Second argument is the integer B



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

 A = 2
 B = 4
Input 2:

 A = 1
 B = 3


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 Valid numbers are {22, 31, 13, 40}
 Hence output 4.
Explanation 2:

 Only valid number is 3

*/

package DynamicProgramming4;

class NDigitNumbers {

	private static final int MOD = 1000000007;
	public int solve(int n, int s) {
		Integer[][] dp = new Integer[n + 1][s + 1];
		int sol = solve(n, s, dp);
		return sol;
	}

	private int solve(int n, int s, Integer[][] dp) {
		if (n == 0 && s == 0) {
			return 1;
		} else if (s == 0 && n != 0) {
			return 0;
		} else if (n == 0 && s != 0) {
			return 0;
		} else {
			if (dp[n][s] == null) {
				int sum = 0;
				for (int i = 0; i <= 9 && i <= s; i++) {
					sum = ((sum % MOD) + (solve(n - 1, s - i, dp) % MOD)) % MOD;
				}
				dp[n][s] = sum;
			}
			return dp[n][s];
		}
	}

	public static void main(String[] args) {
		NDigitNumbers ndn = new NDigitNumbers();
		int ans = ndn.solve(2, 4);
		System.out.println(ans);
	}

}