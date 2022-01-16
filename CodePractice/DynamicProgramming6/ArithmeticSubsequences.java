/**
Q1. Arithmetic Subsequences

Problem Description

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

 1, 3, 5, 7, 9
 7, 7, 7, 7
Given an integer array A of size N. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk](0-based indexing) is arithmetic. In particular, this means that k ≥ 2.

Return the number of arithmetic subsequences slices in the array A.



Problem Constraints

1 <= N <= 1000

-105 <= A[i] <= 105



Input Format

The first and the only argument of input contains an integer array, A of size N.



Output Format

Return an integer representing the number of arithmetic subsequences in A.



Example Input

Input 1:

 A = [2, 4, 6, 8, 10]
Input 2:

 A = [3, 6, 7]


Example Output

Output 1:

 7
Output 2:

 0


Example Explanation

Explanation 1:

 All arithmetic subsequence slices are:
    [2, 4, 6]
    [4, 6, 8]
    [6, 8, 10]
    [2, 4, 6, 8]
    [4, 6, 8, 10]
    [2, 4, 6, 8, 10]
    [2, 6, 10]
Explanation 2:

 There are no possible arithmetic subseqence.
*/

package DynamicProgramming6;

import java.util.*;

class ArithmeticSubsequences {

	public int solve(int[] arr) {
		int ans = 0;

		HashMap<Integer, Integer>[] map = new HashMap[arr.length];
		for (int i = 0; i < arr.length; i++) {
			map[i] = new HashMap<>();
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				long diff = (long) arr[i] - (long) arr[j];
				if (diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE)
					continue;

				int a = map[j].getOrDefault((int) diff, 0);
				int b = map[i].getOrDefault((int) diff, 0);

				ans += a;
				map[i].put((int) diff, a + b + 1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ArithmeticSubsequences asseq = new ArithmeticSubsequences();
		int arr[]= {2, 4, 6, 8, 10};
		int x=asseq.solve(arr);
		System.out.println(x);

	}

}