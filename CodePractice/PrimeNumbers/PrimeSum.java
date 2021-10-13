/**
 * Prime Sum
Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints
4 <= A <= 2*107



Input Format
First and only argument of input is an even number A.



Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input
 4


Example Output
 [2, 2]


Example Explanation
 There is only 1 solution for A = 4.
 */
package PrimeNumbers;

import java.util.ArrayList;

public class PrimeSum {

	private boolean isPrime(int a) {
		for (int i = 2; i <= (int) Math.sqrt(a); i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 2; i < a; i++) {
			if (isPrime(i) && isPrime(a - i)) {
				x.add(i);
				x.add(a - i);
				break;
			}
		}
		return x;

	}

	public static void main(String[] s) {
		PrimeSum ps = new PrimeSum();
		ArrayList<Integer> res = ps.primesum(4);
		res.forEach(System.out::println);

	}
}
