/**
Sub-array with 0 sum
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.

*/

package HashingI;

import java.util.HashMap;

class SubArrayWith0Sum {

	public int solve(int A[]) {
		HashMap<Long, Long> mp = new HashMap<Long, Long>();
		long sum = 0;
		mp.put(sum, new Long(1));
		for (int x : A) {
			sum += x;
			if (mp.get(sum) != null)
				return 1;
			else {
				mp.put(sum, new Long(1));
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		SubArrayWith0Sum subArrayWith0Sum = new SubArrayWith0Sum();
		int A[] = { 4, 2, -3, 1, 3 };
		int x = subArrayWith0Sum.solve(A);
		System.out.println(x);

	}
}
