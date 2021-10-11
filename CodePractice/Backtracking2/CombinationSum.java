/**Combination Sum
Problem Description

Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format
First argument is the vector A.

Second argument is the integer B.



Output Format
Return a vector of all combinations that sum up to B.



Example Input
Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output
Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]


Example Explanation
Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed. */
package Backtracking2;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> temp = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		backtrack(A, 0, B);
		return res;
	}

	void backtrack(ArrayList<Integer> a, int index, int target) {
		if (target == 0 && res.contains(temp) == false) {
			res.add(new ArrayList<Integer>(temp));
			return;
		} else if (target < 0) {
			return;
		}
		for (int i = index; i < a.size(); i++) {
			temp.add(a.get(i));
			backtrack(a, i, target - a.get(i));
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] s) {
		CombinationSum cs = new CombinationSum();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(7);
		cs.combinationSum(list, 7);

	}
}
