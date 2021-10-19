/**
 * Square Root of Integer
Problem Description

Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.



Problem Constraints
0 <= A <= 1010



Input Format
The first and only argument given is the integer A.



Output Format
Return floor(sqrt(A))



Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation:

 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
 */
package SearchingII;

public class SquareRootOfInteger {

	public int sqrt(int A) {
		if (A == 0)
			return 0;
		int start = 1, end = A, ans = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid <= A / mid) {
				ans=mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return ans;
	}

	public static void main(String[] s) {
		SquareRootOfInteger sri = new SquareRootOfInteger();
		int res = sri.sqrt(11);
		System.out.println(res);

	}
}
