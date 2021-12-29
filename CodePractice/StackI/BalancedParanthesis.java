/**
Q1. Balanced Paranthesis

Problem Description

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints

1 <= |A| <= 100



Input Format

The first and the only argument of input contains the string A having the paranthesis sequence.



Output Format

Return 0, if the paranthesis sequence is not balanced.

Return 1, if the paranthesis sequence is balanced.



Example Input

Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output

Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation

You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.

*/

package StackI;

import java.util.Stack;

class BalancedParanthesis {

	public int solve(String A) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				st.push(c);
			else if (!st.isEmpty() && c == ')' && st.peek() == '(')
				st.pop();
			else if (!st.isEmpty() && c == '}' && st.peek() == '{')
				st.pop();
			else if (!st.isEmpty() && c == ']' && st.peek() == '[')
				st.pop();
			else
				st.push(c);
		}
		return st.size() == 0 ? 1 : 0;
	}

	public static void main(String args[]) {
		BalancedParanthesis bp = new BalancedParanthesis();
		int x = bp.solve("{([])}");
		System.out.println(x);
	}
}