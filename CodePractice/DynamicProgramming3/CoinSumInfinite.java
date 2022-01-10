/**
Q1. Coin Sum Infinite

Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.



Example Input

Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3} 
Explanation 2:

 There is only 1 way to make sum 10.
*/

package DynamicProgramming3;

class CoinSumInfinite {

	public int coinchange2(int[] A, int B) {
		long[] dp = new long[B + 1];
		long m = (1000 * 1000) + 7;
		dp[0] = 1;
		for (int a : A) {
			for (int i = a; i <= B; i++) {
				dp[i] = dp[i]+(dp[i - a]) % m;
			}
		}
		return (int) (dp[B] % m);
	}

	public static void main(String[] args) {
		CoinSumInfinite csi = new CoinSumInfinite();
		int a[] = { 1, 2, 3 };
		int ans = csi.coinchange2(a, 4);
		System.out.println(ans);
	}

}