package StackII;

/**
 * Q1. Infix to Postfix
 * 
 * Given string A denoting an infix expression. Convert the infix expression
 * into postfix expression.
 * 
 * String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets
 * where lowercase english alphabets are operands and ^, /, *, +, - are
 * operators.
 * 
 * Find and return the postfix expression of A.
 * 
 * NOTE:
 * 
 * ^ has highest precedence. / and * have equal precedence but greater than +
 * and -. + and - have equal precedence and lowest precedence among given
 * operators.
 * 
 * 
 * Problem Constraints
 * 
 * 1 <= length of the string <= 500000
 * 
 * 
 * 
 * Input Format
 * 
 * The only argument given is string A.
 * 
 * 
 * 
 * Output Format
 * 
 * Return a string denoting the postfix conversion of A.
 * 
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * A = "x^y/(a*z)+b" Input 2:
 * 
 * A = "a+b*(c^d-e)^(f+g*h)-i"
 * 
 * 
 * Example Output
 * 
 * Output 1:
 */
// "xy^az*/b+"
//Output 2:
//
// "abcd^e-fgh*+^*+i-"
//
//
//Example Explanation
//
//Explanation 1:
//
// Ouput dentotes the postfix expression of the given input.
import java.util.HashMap;
import java.util.Stack;
class InfixToPostfix {

	public String solve(String A) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('^', 1);
		map.put('/', 2);
		map.put('*', 2);
		map.put('+', 3);
		map.put('-', 3);
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				sb.append(ch);
			else if (ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.peek());
					stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) <= map.get(ch)) {
					sb.append(stack.peek());
					stack.pop();
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.peek());
			stack.pop();
		}

		return sb.toString();
	}

	public static void main(String args[]) {
		InfixToPostfix itp = new InfixToPostfix();
		String x = itp.solve("x^y/(a*z)+b");
		System.out.println(x);
	}

}