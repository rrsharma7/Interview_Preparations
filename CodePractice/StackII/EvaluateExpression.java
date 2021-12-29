/**
Q3. Evaluate Expression

Problem Description

An arithmetic expression is given by a charater array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.



Problem Constraints

1 <= N <= 105



Input Format

The only argument given is character array A.



Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output

Output 1:
    9
Output 2:
    6


Example Explanation

Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    1 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6


*/

package StackII;

import java.util.ArrayList;
import java.util.Stack;

class EvaluateExpression {

	public int evalRPN(ArrayList<String> A) {
        Stack <Integer> values = new Stack <Integer> ();
        int first;
        int second;
        for (String str: A) {
            if (equal(str, "+")) {
                second = values.pop();
                first = values.pop();
                values.push(first + second);
            } else if (equal(str, "*")) {
                second = values.pop();
                first = values.pop();
                values.push(first * second);
            } else if (equal(str, "/")) {
                second = values.pop();
                first = values.pop();
                values.push(first / second);
            } else if (equal(str, "-")) {
                second = values.pop();
                first = values.pop();
                values.push(first - second);
            } else {
                first = Integer.parseInt(str);
                values.push(first);
            }
        }
        return values.peek();
    }
    public boolean equal(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

	public static void main(String args[]) {
		EvaluateExpression ee = new EvaluateExpression();
		ArrayList<String> arrList=new ArrayList<String>();
		arrList.add("2");
		arrList.add("1");
		arrList.add("+");
		arrList.add("3");
		arrList.add("*");
		int x = ee.evalRPN(arrList);
		System.out.println(x);
	}

}