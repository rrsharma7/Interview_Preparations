/**
 *Ath Magical Number
Problem Description

Given three positive integers A, B and C.

Any positive integer is magical if it is divisible by either B or C.

Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

 */
package SearchingII;

public class AthMagicalNumber {

	public int solve(int A, int B, int C) {
		int mod = 1000000007;
		long min = 1L;
		long max = Long.MAX_VALUE;
		long result = 0;
		int lcm = lcm(B, C);
		while (min <= max) {
			long mid = min + (max - min) / 2;
			if (totalNumbers(mid, B, C, lcm) < A)
				min = mid + 1;
			else {
				result = mid;
				max = mid - 1;
			}
		}
		return (int) (result % mod);
	}

	private long totalNumbers(long num, int B, int C, int lcm) {
		return num / B + num / C - num / lcm;
	}

	private int lcm(int B, int C) {
		return B * C / gcd(B, C);
	}

	private int gcd(int B, int C) {
		if (C == 0)
			return B;
		return gcd(C, B % C);
	}

	public static void main(String[] s) {
		AthMagicalNumber si = new AthMagicalNumber();
		int res = si.solve(1,2,3);
		System.out.println(res);

	}
}
