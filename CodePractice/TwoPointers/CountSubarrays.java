/**
Q4. Count Subarrays

Problem Description

Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

Since the number of subarrays could be large, return value % 109 +7.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 106



Input Format

The only argument given is an Array A, having N integers.



Output Format

Return the number of subarrays of A, that have unique elements.



Example Input

Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 1, 2]


Example Output

Output 1:

 4
Output 1:

 5


Example Explanation

Explanation 1:

 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]
Explanation 2:

 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]
*/

package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;

class CountSubarrays {

	public int solve(ArrayList<Integer> A) {
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		int l = 0, r = 0, mod = 1000 * 1000 * 1000 + 7;
		long ans = 0;
		// l and r represent the window which we are checking
		for (Integer x : A) {
			if (mp.get(x) != null) {
				// if we already have x in window, start removing elements from the left
				while (mp.get(x) != 0) {
					mp.put(A.get(l), 0);
					l++;
				}
			}
			mp.put(x, 1);
			// number of subarrays ending at index r
			ans += r - l + 1;
			ans %= mod;
			r++;
		}
		return (int) ans;
	}

	public static void main(String args[]) {
		CountSubarrays cs = new CountSubarrays();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(1);
		arrList.add(1);
		arrList.add(3);
		int x = cs.solve(arrList);
		System.out.println(x);

	}
}
