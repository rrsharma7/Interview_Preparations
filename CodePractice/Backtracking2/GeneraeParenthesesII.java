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

public class GeneraeParenthesesII {

	public ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> result = new ArrayList<>();
		findParenthesis("(", 1, 0, result, A);
		return result;

	}

	private void findParenthesis(String current, int open, int closed, ArrayList<String> result, int n) {
		if (current.length() == 2 * n) {
			result.add(current);
		}
		if (open < n)
			findParenthesis(current + "(", open + 1, closed, result, n);
		if (closed < open)
			findParenthesis(current + ")", open, closed + 1, result, n);

	}

	public static void main(String[] s) {
		GeneraeParenthesesII gp = new GeneraeParenthesesII();
		ArrayList<String> resList=gp.generateParenthesis(3);
		resList.forEach(System.out::println);

	}
}
