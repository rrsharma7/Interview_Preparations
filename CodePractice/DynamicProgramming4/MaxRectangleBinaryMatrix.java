/**
Q1. Max Rectangle in Binary Matrix

Problem Description

Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing all ones and return its area.



Problem Constraints

1 <= N, M <= 100



Input Format

First argument is an 2-D binary array A.



Output Format

Return an integer denoting the area of largest rectangle containing all ones.



Example Input

Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 


Example Output

Output 1:

 4
Output 2:

 3


Example Explanation

Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1,0), (1,1) and (1,2).


*/

package DynamicProgramming4;

import java.util.Stack;

class MaxRectangleBinaryMatrix {

	public int maximalRectangle(int[][] A) {
		int row = A.length;
		if (row == 0) {
			return 0;
		}
		int col = A[0].length;

		int[][] mat = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (A[i][j] == 1) {
					mat[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] != 0) {
					mat[i][j] += mat[i - 1][j];
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int[] rows : mat) {
			max = Math.max(max, largestRectangleArea(rows));
		}

		return max;
	}

	public int largestRectangleArea(int[] height) {
		int n = height.length;
		if (n == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();

		int maxArea = 0;
		int max = Integer.MIN_VALUE;
		int i = 0, top = 0;
		while (i < n) {
			if (stack.empty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			}

			else {
				max = getMax(height, stack, max, i);
			}
		}

		while (!stack.empty()) {
			max = getMax(height, stack, max, i);
		}

		return max;
	}

	private int getMax(int[] height, Stack<Integer> stack, int max, int i) {
		int top;
		int maxArea;
		top = stack.peek();
		stack.pop();

		maxArea = height[top] * (stack.empty() ? i : i - stack.peek() - 1);
		if (maxArea > max) {
			max = maxArea;
		}
		return max;
	}

	public static void main(String[] args) {
		MaxRectangleBinaryMatrix mrbm = new MaxRectangleBinaryMatrix();
		int a[][] = { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 0 } };
		int ans = mrbm.maximalRectangle(a);
		System.out.println(ans);
	}

}