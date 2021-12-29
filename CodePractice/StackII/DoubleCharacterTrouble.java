/**
Q2. Double Character Trouble

Problem Description

You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of same consecutive characters and return the final string.



Problem Constraints

1 <= |A| <= 100000



Input Format

First and only argument is string A.



Output Format

Return the final string.



Example Input

Input 1:

 A = abccbc
Input 2:

 A = ab


Example Output

Output 1:

 "ac"
Output 2:

 "ab"


Example Explanation

Explanation 1:

Remove the first occurrence of same consecutive characters. eg for a string "abbc", the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".
Explanation 2:

 No removals are to be done.


*/

package StackII;

import java.util.Stack;

class DoubleCharacterTrouble {

	public String solve(String A) {

		Stack<Character> stack = new Stack<Character>();
        stack.push( A.charAt(A.length()-1) );
        for(int i=A.length()-2; i>=0; i--)
        {
            if(!stack.isEmpty() && A.charAt(i) == stack.peek())
            {
                stack.pop();
            }
            else
                stack.push(A.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();
    }

	public static void main(String args[]) {
		DoubleCharacterTrouble dct = new DoubleCharacterTrouble();
		String x = dct.solve("abccbc");
		System.out.println(x);
	}

}