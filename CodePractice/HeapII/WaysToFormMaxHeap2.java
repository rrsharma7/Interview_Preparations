/**
Q1. Ways to form Max Heap 2
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Max heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e. Max heap of size N.

As final answer can be very large return your answer modulo 109 + 7.



Problem Constraints

1 <= N <= 1000



Input Format

First and only argument is an integer array A.



Output Format

Return an integer denoting the number of structurally different Max heaps possible modulo 109 + 7.



Example Input

Input 1:

 A = [1, 5, 5]
Input 2:

 A = [2, 2, 7]


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 The possible max heaps using the given elements are:- First: 5 on the root. 1 as the left child of root and 5 as the right child of the root.   
                5
              /   \
            1       5
 Second: 5 on the root. 5 as the left child of root and 1 as the right child of the root.
                5
              /   \
            5       1            
Explanation 2:

 There is only one possible max heaps: 7 on the root. 2 as the left child of root and 2 as the right child of the root.   
                7
              /   \
            2       2
 
*/

package HeapII;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class WaysToFormMaxHeap2 {
	static int maxn = 1005;
	static long[] dp = new long[maxn];
	static long[] dp1 = new long[maxn];
	static long[][] nck = new long[maxn][maxn];
	static int[] log_2 = new int[maxn];
	static long MOD = 1000000007;

	public int solve(int[] arr) {
		int n = arr.length;
		for (int i = 0; i <= n; i++)
			dp[i] = (long) -1;

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				nck[i][j] = (long) -1;

		int currlog_2Answer = -1;
		int currPower2 = 1;
		for (int i = 1; i <= n; i++) {
			if (currPower2 == i) {
				currlog_2Answer++;
				currPower2 *= 2;
			}
			log_2[i] = currlog_2Answer;
		}
		int max = -1;
		int min = 10000000;
		int maxcount = 0;
		int mincount = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
				mincount = 1;
			} else if (arr[i] == min) {
				mincount++;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxcount = 1;
			} else if (arr[i] == max) {
				maxcount++;
			}
		}
		if (maxcount == 2)
			return (int) getNumberOfMaxHeaps(n);
		else
			return (int) getNumberOfMaxHeaps2(n);
	}

	public static long choose(int n, int k) {
		if (k > n)
			return 0;
		if (n <= 1)
			return 1;
		if (k == 0)
			return 1;

		if (nck[n][k] != -1)
			return nck[n][k];
		long answer = choose(n - 1, k - 1) + choose(n - 1, k);
		answer %= MOD;
		nck[n][k] = answer;
		return answer;
	}

	public static int getL(int n) {
		if (n == 1)
			return 0;

		int h = log_2[n];
		int p = n - ((1 << (h)) - 1);
		int m = (1 << h);
		if (p >= (m / 2))
			return (1 << (h)) - 1;
		else
			return (1 << (h)) - 1 - ((m / 2) - p);
	}

	public static long getNumberOfMaxHeaps(int n) {
		if (n <= 1)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		int L = getL(n);
		long ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
		ans %= MOD;
		dp[n] = ans;
		return ans;
	}

	public static long getNumberOfMaxHeaps2(int n) {
		if (n < 2)
			return (long) 0;
		if (n < 4)
			return (long) 1;
		if (n == 4)
			return (long) 2;
		if (n == 5)
			return (long) 4;
		if (dp1[n] != 0)
			return dp1[n];
		int l = getL(n);
		int r = n - l - 1;
		long ans = (((choose(n - 3, l - 2) * getNumberOfMaxHeaps2(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD;
		ans = (ans + (((choose(n - 3, r - 2) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps2(r)) % MOD) % MOD;
		ans = (ans + (((choose(n - 3, l - 1) * getNumberOfMaxHeaps(l)) % MOD) * getNumberOfMaxHeaps(r)) % MOD) % MOD;
		dp1[n] = ans;
		return ans;
	}

	public static void main(String args[]) {
		WaysToFormMaxHeap2 wtmh = new WaysToFormMaxHeap2();
		int a[]= {1, 5, 5};
		int x = wtmh.solve(a);
		System.out.println(x);
	}
}
