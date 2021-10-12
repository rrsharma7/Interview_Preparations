/**
 *Divide Integers
Problem Description

Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B!= 0



Input Format
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.



Output Format
Return an integer denoting the floor value of the division.



Example Input
Input 1:

 A = 5
 B = 2
Input 2:

 A = 7
 B = 1


Example Output
Output 1:

 2
Output 2:

 7


Example Explanation
Explanation 1:

 floor(5/2) = 2
 */
package BitManipulation;

public class DivideIntegers {

	public int divide(int A, int B) {
		if (A == Integer.MIN_VALUE && B == -1)
			return Integer.MAX_VALUE;
		if (B == 1)
			return A;
		int x = Math.floorDiv(A, B);
		return x;
//		boolean isPositive = (B > 0 && A < 0) || (B < 0 && A > 0) ? false : true;
//		double posDividend = Math.abs((double) A);
//		double posDivisor = Math.abs((double) B);
//		int result = (int) Math.exp((double) Math.log(posDividend) - (double) Math.log(posDivisor) + 0.000000000000001);
//		return isPositive ? result : -result;
	}

	public static void main(String[] s) {
		DivideIntegers di = new DivideIntegers();
		int x = di.divide(5, 2);
		System.out.println(x);

	}
}
