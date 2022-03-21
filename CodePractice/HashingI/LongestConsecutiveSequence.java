/**
Q4. Longest Consecutive Sequence
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].

*/

package HashingI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class LongestConsecutiveSequence {

	public int solve(final List<Integer> A) {
		if (A.size() == 0)
			return 0;
		HashSet<Integer> set = new HashSet<>();
		for (int a : A)
			set.add(a);

		int max = 1;
		for (int el : set) {
			if (!set.contains(el - 1)) {
				int c = el + 1, cnt = 1;
				while (set.contains(c)) {
					c++;
					cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		return max;

	}

	public static void main(String args[]) {
		LongestConsecutiveSequence sad = new LongestConsecutiveSequence();
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(4);
		list.add(200);
		list.add(1);
		list.add(3);
		list.add(2);
		int x = sad.solve(list);
		System.out.println(x);

	}
}