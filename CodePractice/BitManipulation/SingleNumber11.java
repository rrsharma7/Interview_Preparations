/**
 * Single Number II
Problem Description

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints
2 <= A <= 5*106

0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */
package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber11 {

	public int singleNumber(final int[] A) {
		int ans = 0;
		HashMap<Integer, Integer> hsMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (hsMap.containsKey(A[i])) {
				hsMap.put(A[i], hsMap.get(A[i]) + 1);
			} else
				hsMap.put(A[i], 1);
		}
		for (Map.Entry<Integer, Integer> entry : hsMap.entrySet())
			if (entry.getValue() == 1)
				ans = entry.getKey();
		return ans;
	}

	public static void main(String[] s) {
		SingleNumber11 asp = new SingleNumber11();
		int[] A = { 0, 0, 0, 1};
		int res = asp.singleNumber(A);
		System.out.println(res);

	}
}
