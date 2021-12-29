/**
Q4. Check two bracket expressions

Problem Description

Given two strings A and B. Each string represents an expression consisting of lowercase english alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are similar return 1 else return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’ and every operand appears only once.



Problem Constraints

1 <= length of the each String <= 100



Input Format

The arguments given are string A and String B.



Output Format

Return 1 if they represent the same expression else return 0.



Example Input

Input 1:

 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:

 A = "a-b-(c-d)"
 B = "a-b-c-d"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 
Explanation 2:

 Both the expression are different.

*/

package StackI;

import java.util.Stack;

class TwoBracketExpressions {

	public int solve(String A, String B) {

		int[] freqA = new int[26];
		int[] freqB = new int[26];

		buildFreqArray(A, freqA);
		buildFreqArray(B, freqB);

		for (int i = 0; i < 26; i++) {
			if (freqA[i] != freqB[i])
				return 0;
		}
		return 1;

	}

	void buildFreqArray(String A, int[] freqA) {
		Stack<Boolean> stackA = new Stack<Boolean>();
		stackA.push(true);
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (i != 0 && ch == '(') {
				char ch1 = A.charAt(i - 1);
				if (ch1 == '-') {
					if (stackA.peek())
						stackA.push(false);
					else
						stackA.push(true);
				} else {
					if (stackA.peek())
						stackA.push(true);
					else
						stackA.push(false);
				}
			} else if (ch == ')')
				stackA.pop();

			else if (i == 0 && ch >= 97 && ch <= 122)
				freqA[ch - 'a'] = 1;

			else if (ch >= 97 && ch <= 122) {
				char ch1 = A.charAt(i - 1);
				if (ch1 == '-') {
					if (!stackA.peek())
						freqA[ch - 'a'] = 1;
				} else {
					if (stackA.peek())
						freqA[ch - 'a'] = 1;
				}
			}
		}

	}

	public static void main(String args[]) {
		TwoBracketExpressions tbe = new TwoBracketExpressions();
		int x = tbe.solve("-(a+b+c)","-a-b-c");
		System.out.println(x);
	}

}