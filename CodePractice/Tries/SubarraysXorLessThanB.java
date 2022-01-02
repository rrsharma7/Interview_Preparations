/**
Q4. Subarrays Xor Less Than B

Problem Description

Given an array of integers A. Find and return the number of subarrays whose xor values is less than B.
NOTE: As the answer can be very large, return the answer modulo (109+7).



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 105
1 <= B <= 106



Input Format

The argument given is the integer array A
Second argument is an integer B.



Output Format

Return an integer denoting the number of subarrays whose xor values is less than B.



Example Input

Input 1:

 A = [8, 3, 10, 2, 6, 7, 6, 9, 3]
 B = 3
Input 2:

 A = [9, 4, 3, 11]
 B = 7


Example Output

Output 1:
 5
Output 2:

 3


Example Explanation

Explanation 1:

 Generate all the subarrays and their corresponding xor and there are only 5 such subaraays which have xor less than 3.
Explanation 2:

 Subarrays with xor < 7 are : [9, 4, 3, 11], [4] and [3].
 So, the answer is 3.
*/

package Tries;

class SubarraysXorLessThanB {
	static int mod = 1000000007;

	public int solve(int[] A, int B) {
		return solveQ(A, B);
	}

	static class Trie {
		Trie[] child = new Trie[2];
		int value;

		Trie() {
			value = 0;
			for (int i = 0; i < 2; i++) {
				child[i] = null;
			}
		}
	}

	private static void insert(int preXOR) {
		Trie crawl = start;
		for (int i = 20; i >= 0; i--) {
			int indx = (preXOR & (1 << i)) > 0 ? 1 : 0;
			if (crawl.child[indx] == null) {
				crawl.child[indx] = new Trie();
			}
			crawl = crawl.child[indx];
			crawl.value++;
		}
	}

	private static int query(int preXOR, int k) {
		int ans = 0;
		Trie crawl = start;
		for (int i = 20; crawl != null && i >= 0; i--) {
			int q = (k & (1 << i)) > 0 ? 1 : 0;
			int indx = (preXOR & (1 << i)) > 0 ? 1 : 0;

			if (q == 1) {
				if (crawl.child[indx] != null) {
					ans += crawl.child[indx].value;
				}
				crawl = crawl.child[1 - indx];
			} else {
				crawl = crawl.child[indx];
			}
		}
		return ans;
	}

	private static Trie start;

	public static int solveQ(int[] A, int B) {
		start = new Trie();
		int preXOR = 0;
		long count = 0;
		insert(preXOR);
		for (int i = 0; i < A.length; i++) {
			preXOR ^= A[i];
			count += (long) query(preXOR, B);
			count %= mod;
			insert(preXOR);
		}
		return (int) count;
	}

	public static void main(String[] args) {
		SubarraysXorLessThanB saxlb = new SubarraysXorLessThanB();
		int arr[] = {8, 3, 10, 2, 6, 7, 6, 9, 3};
		int x = saxlb.solve(arr,3);
		System.out.println(x);
	}

}
