/**
 Maximum Unsorted Subarray
Problem Description

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000



Input Format
First and only argument is an array of non-negative integers of size N.



Output Format
Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.



Example Input
Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output
Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation
Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.
*/

package Sorting1;

import java.util.ArrayList;

class MaximumUnsortedSubarray {

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int n = A.size();
		int[] mins = new int[n];
		int[] maxs = new int[n];
		maxs[0] = A.get(0);
		for (int i = 1; i < n; i++) {
			maxs[i] = Math.max(A.get(i), maxs[i - 1]);//1, 3, 3, 4, 5 --> 1 3 2 4 5
		}
		mins[n - 1] = A.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			mins[i] = Math.min(A.get(i), mins[i + 1]); //1, 2, 2, 4, 5 --> 1 3 2 4 5
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int start = 0;
		while (start < n && mins[start] == A.get(start))
			start++;
		int end = n - 1;
		while (end >= 0 && maxs[end] == A.get(end))
			end--;
		if (start == n)
			result.add(-1);
		else {
			result.add(start);
			result.add(end);
		}
		return result;
	}

	public static void main(String args[]) {
		MaximumUnsortedSubarray musa = new MaximumUnsortedSubarray();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(5);
		ArrayList<Integer> res = musa.subUnsort(list1);
		res.forEach(System.out::println);
	}
}
