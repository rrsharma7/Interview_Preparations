/**
 Q2. Sort stack using another stack

Problem Description

Given a stack of integers A, sort it using another stack.

Return the array of integers after sorting the stack using another stack.



Problem Constraints

1 <= |A| <= 5000

0 <= A[i] <= 1000000000



Input Format

The only argument given is the integer array A.



Output Format

Return the array of integers after sorting the stack using another stack.



Example Input

Input 1:

 A = [5, 4, 3, 2, 1]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 [1, 2, 3, 4, 5]
Output 2:

 [5, 11, 17, 100]


Example Explanation

Explanation 1:

 Just sort the given numbers.
Explanation 2:

 Just sort the given numbers.


See Expected Output

*/

package StackI;

import java.util.Stack;

class SortStackUsingAnotherStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public SortStackUsingAnotherStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public int[] solve(int[] A) {
		int ans[] = new int[A.length];
		Stack<Integer> input = new Stack<Integer>();
		for (int i = 0; i < A.length; i++) {
			input.push(A[i]);
		}
		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			// pop out the first element
			int tmp = input.pop();

			// while temporary stack is not empty and
			// top of stack is greater than temp
			while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
				// pop from temporary stack and
				// push it to the input stack
				input.push(tmpStack.pop());
			}

			// push temp in temporary of stack
			tmpStack.push(tmp);
		}
		Object[] arr = tmpStack.toArray();
		for (int i = 0; i < arr.length; i++) {
			ans[i] = (int) arr[i];
		}
		return ans;
	}

	public static void main(String args[]) {
		SortStackUsingAnotherStack ss = new SortStackUsingAnotherStack();
		int a[] = {5, 17, 100, 11};
		int ans[] = ss.solve(a);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}
}