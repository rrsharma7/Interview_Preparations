/**
 * Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */

package Sorting2;

import java.util.Arrays;

class LargestNumber {

	public String largestNumber(final int[] A) {
        String str[] = new String[A.length];
		for (int i = 0; i < A.length; i++) {
			str[i] = Integer.toString(A[i]);
		}
		Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
		String s = "";
		if (str[0].equals("0"))
			return "0";
		for (int i = 0; i < A.length; i++)
			s += str[i];
		return s;
    }

	public static void main(String[] args) {
		LargestNumber ue = new LargestNumber();
		int A[] = {3, 30, 34, 5, 9};
		String x = ue.largestNumber(A);
		System.out.println(x);
	}
}
