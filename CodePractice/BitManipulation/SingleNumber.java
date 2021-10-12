/**
 * Single Number
Problem Description

Given an array of integers A, every element appears twice except for one. Find that single one.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints
2 <= |A| <= 2000000

0 <= A[i] <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting the single element.



Example Input
Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

3 occurs once.
Explanation 2:

1 occurs once.
 */
package BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

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
		SingleNumber asp = new SingleNumber();
		int[] A = { 1, 2, 2 };
		int res = asp.singleNumber(A);
		System.out.println(res);

	}
}
