/**
 Different Bits Sum Pairwise
Problem Description

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a single integer denoting the sum.



Example Input
Input 1:

 A = [1, 3, 5]
Input 2:

 A = [2, 3]


Example Output
Ouptut 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
 */
package BitManipulation;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {

	public int cntBits(ArrayList<Integer> A) {
		// Hamming distance problem
		long ans = 0;
		long count0 = 0;
		long count1 = 0;
		for (int i = 0; i < 31; i++)// 32nd bit is 0 for positive integer
		{
			count0 = 0;
			count1 = 0;
			for (int j = 0; j < A.size(); j++) {
				if ((A.get(j) & 1 << i) == 0)
					count0++;
			}
			// for hamming distance !=0, we select any number having
			// 1 art that place and any number having 0 at that place
			count1 = A.size() - count0;
			ans += 2 * count0 * count1;
			ans %= 1000000007;
		}
		return (int) ans % 1000000007;
	}

	public static void main(String[] s) {
		DifferentBitsSumPairwise dbsp = new DifferentBitsSumPairwise();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		int ans = dbsp.cntBits(list1);
		System.out.println(ans);

	}
}
