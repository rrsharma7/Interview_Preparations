/**
Q3. Maximum XOR

Problem Description

Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.



Problem Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer denoting the maximum result of A[i] XOR A[j].



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output

Output 1:

 7
Output 2:

 117


Example Explanation

Explanation 1:

 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
Explanation 2:

 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
*/

package Tries;

import java.util.Stack;

class MaximumXOR {
	public int solve(int[] A) {
		TriesNode root = new TriesNode();
		for (int i = 0; i < A.length; i++) {
			root.insert(A[i]);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, root.findClosestXor(A[i]));
		}
		return max;
	}

	class TriesNode {
		TriesNode zero;
		TriesNode one;
		int number;
		boolean isTerminal = false;

		public void insert(int input) {
			TriesNode node = this;
			int[] binaryArr = convertDecimalToBinary(input);
			for (int i = 0; i < binaryArr.length; i++) {
				if (binaryArr[i] == 1) {
					if (node.one == null) {
						node.one = new TriesNode();
					}
					node = node.one;
				} else {
					if (node.zero == null) {
						node.zero = new TriesNode();
					}
					node = node.zero;
				}
			}

			node.isTerminal = true;
			node.number = input;
		}

		public int findClosestXor(int input) {
			TriesNode node = this;
			int[] binaryArr = convertDecimalToBinary(input);

			for (int i = 0; i < binaryArr.length; i++) {
				if (binaryArr[i] == 1) {
					if (node.zero != null) {
						node = node.zero;
					} else {
						node = node.one;
					}
				} else {
					if (node.one != null) {
						node = node.one;
					} else {
						node = node.zero;
					}

				}
			}
			if (node.isTerminal) {
				return node.number ^ input;
			}
			return input;
		}

		private int[] convertDecimalToBinary(int num) {
			Stack<Integer> stack = new Stack<>();
			while (num > 0) {
				stack.push(num % 2);
				num /= 2;
			}
			int[] binaryArr = new int[32];
			Stack<Integer> popped = new Stack<>();
			int i = 31;
			while (!stack.isEmpty()) {
				popped.push(stack.pop());
			}
			while (!popped.isEmpty()) {
				binaryArr[i] = popped.pop();
				i--;
			}

			return binaryArr;
		}
	}

	public static void main(String[] args) {
		MaximumXOR mxor = new MaximumXOR();
		int arr[]= {1, 2, 3, 4, 5};
		int x=mxor.solve(arr);
		System.out.println(x);
	}

}
