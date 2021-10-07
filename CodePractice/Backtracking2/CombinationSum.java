/**Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
Problem Constraints
1 <= A <= 20
Input Format
First and only argument is integer A.
Output Format
Return a sorted list of all possible paranthesis.
Example Input
Input 1:

A = 3
Input 2:

A = 1
Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]

Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list. */
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
