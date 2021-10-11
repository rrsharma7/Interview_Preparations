/**
Number of Squareful Arrays
Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints
1 <= length of the array <= 12

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of permutations of A that are squareful.



Example Input
Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1]. */
package RecursionBacktracking1;

import java.util.HashSet;
import java.util.Set;

class NumberOfSquarefulArrays {

	int count;
	public int solve(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return count;
		backtrack(nums, n, 0);
		return count;

	}

	void backtrack(int[] nums, int n, int start) {
		if (start == n) {
			count++;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < n; i++) {
			if (set.contains(nums[i]))
				continue;
			swap(nums, start, i);
			if (start == 0 || isPerfectSq(nums[start], nums[start - 1]))
				backtrack(nums, n, start + 1);
			swap(nums, start, i);
			set.add(nums[i]);
		}
	}

	void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;

	}

	boolean isPerfectSq(int a, int b) {
		int x = a + b;
		double sqrt = Math.sqrt(x);
		return (sqrt - (int) sqrt) == 0 ? true : false;
	}

	public static void main(String[] args) {
		NumberOfSquarefulArrays numberOfSquarefulArrays = new NumberOfSquarefulArrays();
		int[] num= {1, 17, 8};
		int res=numberOfSquarefulArrays.solve(num);
		System.out.println("res="+res);
	}
}
