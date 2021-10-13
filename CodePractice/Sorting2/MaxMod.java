/**
 * MaxMod
Problem Description

Given an array A of size N, groot wants you to pick 2 indices i and j such that

1 <= i, j <= N
A[i] % A[j] is maximum among all possible pairs of (i, j).
Help Groot in finding the maximum value of A[i] % A[j] for some i, j.



Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000



Input Format
First and only argument in an integer array A.



Output Format
Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.



Example Input
Input 1:

 A = [1, 2, 44, 3]
Input 2:

 A = [2, 6, 4]


Example Output
Output 1:

 3
Output 2:

 4


Example Explanation
Explanation 1:

 For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
 No pair exists which has more value than 3.
Explanation 2:

 For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
 */

package Sorting2;

import java.util.Arrays;

class MaxMod {

	public int solve(int[] A) {
		int n = A.length;
		int flag = 0;
		// sort the array
		Arrays.sort(A);//1, 2, 3, 44
		// keep the pointer at the end of the array
		int i = n - 1;
		// keep going backwards until we dont find a different element
		while (flag == 0 && i != 0) {
			if (A[i] == A[i - 1])
				i--;
			else
				flag = 1;
		}
		// if we find a different element before reaching the end of the array, print
		// the element
		// at the index before that
		// else return 0 because in that case all the elements are same and no
		// matter which indices we choose, the answer will always be 0
		if (i != 0)
			return A[i - 1];
		else
			return 0;
	}

	public static void main(String[] args) {
		MaxMod maxMod = new MaxMod();
		int arr[] = { 2, 6, 4};
		int x=maxMod.solve(arr);
		System.out.println(x);

	}
}
