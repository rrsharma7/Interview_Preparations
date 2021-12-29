/**
Q4. Nearest Smaller Element

Problem Description

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider next smaller element as -1.



Problem Constraints

1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format

The only argument given is integer array A.



Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.



Example Input

Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]


Example Output

Output 1:

[-1, 4, -1, 2, 2]
Output 2:

 [-1, -1, -1]


Example Explanation

Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:

index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1


*/

package StackII;

import java.util.Stack;

class MaxAndMin {

	public int solve(int[] A) {
		int n = A.length, mod = 1000 * 1000 * 1000 + 7;
		int a[] = new int[n + 1];
		int Next_greater_element[] = new int[n + 1];
		int Previous_greater_element[] = new int[n + 1];
		int Previous_smaller_element[] = new int[n + 1];
		int Next_smaller_element[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			Next_greater_element[i + 1] = n + 1;
			Next_smaller_element[i + 1] = n + 1;
			a[i + 1] = A[i];
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i <= n; i++) { // this loop calculates next_greater element index
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && a[s.peek()] <= a[i]) {
					Next_greater_element[s.peek()] = i;
					s.pop();
				}
				s.push(i);
			}
		}
		while (!s.empty()) {
			s.pop();
		}
		for (int i = n; i > 0; i--) { // this loop calculates Previous_greater element index
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && a[i] > a[s.peek()]) {
					Previous_greater_element[s.peek()] = i;
					s.pop();
				}
				s.push(i);
			}
		}
		while (!s.empty()) {
			s.pop();
		}
		for (int i = n; i > 0; i--) { // this loop calculates Previous smaller element index
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && a[i] <= a[s.peek()]) {
					Previous_smaller_element[s.peek()] = i;
					s.pop();
				}
				s.push(i);
			}
		}
		while (!s.empty()) {
			s.pop();
		}
		for (int i = 1; i <= n; i++) { // this loop calculates Next smaller element index
			if (s.empty()) {
				s.push(i);
			} else {
				while (!s.empty() && a[i] < a[s.peek()]) {
					Next_smaller_element[s.peek()] = i;
					s.pop();
				}
				s.push(i);
			}
		}
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			long right = Next_greater_element[i] - i;
			long left = i - Previous_greater_element[i];
			ans += (((left * right) % mod) * a[i]) % mod;
			ans %= mod;
			left = i - Previous_smaller_element[i];
			right = Next_smaller_element[i] - i;
			ans -= (((left * right) % mod) * a[i]) % mod;
			ans += mod;
			ans %= mod;
		}
		return (int) ans;
	}

	public static void main(String args[]) {
		MaxAndMin mm = new MaxAndMin();
		int a[] = { 4, 7, 3, 8 };
		int x = mm.solve(a);
		System.out.println(x);
	}

}