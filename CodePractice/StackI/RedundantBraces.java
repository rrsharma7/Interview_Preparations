/**
Q2. Redundant Braces

Problem Description

Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Chech whether A has redundant braces or not.

NOTE: A will be always a valid expression.



Problem Constraints

1 <= |A| <= 105



Input Format

The only argument given is string A.



Output Format

Return 1 if A has redundant braces, else return 0.



Example Input

Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.

*/

package StackI;

import java.util.ArrayList;

class RedundantBraces {

	public int braces(String A) {
		ArrayList<Character> stack = new ArrayList<>();
	        int top=-1;
	        for(int i=0;i<A.length();i++)
	        {
	            if(A.charAt(i)=='(')
	            {
	                stack.add(A.charAt(i));
	                top++;
	            }
	            else if(A.charAt(i)=='+'||A.charAt(i)=='-'||A.charAt(i)=='*'||
	            A.charAt(i)=='/')
	            {
	                stack.add(A.charAt(i));
	                top++;
	            }
	            else if(A.charAt(i)==')')
	            {
	                if(stack.get(top)=='(')
	                return 1;
	                while(stack.get(top)!='(')
	                {
	                    stack.remove(top);
	                    top--;
	                }
	                if(stack.get(top)=='(')
	                {
	                    stack.remove(top);
	                    top--;                    
	                }
	            }
	        }
	        return 0;
	    }
	

	public static void main(String args[]) {
		RedundantBraces bp = new RedundantBraces();
		int x = bp.braces("((a+b))");
		System.out.println(x);
	}
}