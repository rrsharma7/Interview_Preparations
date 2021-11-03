/**
Pairs with given B II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have B equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which B is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

 
A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs B up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.

*/

package TwoPointers;

class PairsWithGivenSumII {

	public static int MOD = 1000000007;

	public int solve(int[] A, int B) {
		int i = 0, j = A.length - 1;
		long ans = 0;
		while (i < j) {
			if (A[i] + A[j] == B) {
				int ii = i, jj = j;
				if (A[i] == A[j]) 
				 {
					long cnt = j - i + 1;
					ans += (cnt * (cnt - 1) / 2) % MOD;
					ans %= MOD;
					break;
				} else {
					// count number of elements with value A[i]
					while (A[i] == A[ii]) {
						ii++;
					}
					int cnt1 = ii - i;
					i = ii;

					// count number of elements with value A[i]
					while (A[jj] == A[j]) {
						jj--;
					}
					int cnt2 = j - jj;
					j = jj;
					ans += (cnt1 * cnt2) % MOD;
					ans %= MOD;
				}
			} else if (A[i] + A[j] > B) {
				j--;
			} else
				i++;
		}
		return (int) ans;
	}

	public static void main(String args[]) {
		PairsWithGivenSumII pwgs2 = new PairsWithGivenSumII();
		int[] A = { 1, 1, 1 };
		int x = pwgs2.solve(A, 2);
		System.out.println(x);

	}
}
