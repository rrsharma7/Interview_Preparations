/**
Q3. Maximum Rectangle

Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Input Format

The only argument given is the integer matrix A.
Output Format

Return the area of the largest rectangle containing only 1's.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [0, 0, 1]
            [0, 1, 1]
            [1, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [0, 1, 0, 1]
            [1, 0, 1, 0]    ]
Output 2:
    1

*/

package StackII;

import java.util.Stack;

class MaximumRectangle {

	public int solve(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		int[][] row_prefix = new int[N][M];
		// To find the prefix sum row-wise.
		for (int j = 0; j < M; j++) {
			row_prefix[0][j] = A[0][j];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == 1) {
					if (row_prefix[i - 1][j] != 0) {
						row_prefix[i][j] = A[i][j] + row_prefix[i - 1][j];
					} else
						row_prefix[i][j] = A[i][j];
				}
			}
		}
		int res = 0;
		// Using "Largest Rectangle in Histogram" algorithm to find the maximum area.
		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(0);
			int max_area = 0;
			for (int j = 1; j < M; j++) {
				if (row_prefix[i][j] >= row_prefix[i][stack.peek()])
					stack.push(j);
				else {
					while (!stack.isEmpty() && row_prefix[i][j] < row_prefix[i][stack.peek()]) {
						int index = stack.peek();
						stack.pop();

						if (stack.isEmpty())
							max_area = Math.max(max_area, j * row_prefix[i][index]);
						else
							max_area = Math.max(max_area, (j - stack.peek() - 1) * row_prefix[i][index]);
					}
					stack.push(j);
				}
			}
			while (!stack.isEmpty()) {
				int index = stack.peek();
				stack.pop();
				if (stack.isEmpty())
					max_area = Math.max(max_area, M * row_prefix[i][index]);
				else
					max_area = Math.max(max_area, (M - stack.peek() - 1) * row_prefix[i][index]);
			}
			res = Math.max(res, max_area);
		}
		return res;
	}

	public static void main(String args[]) {
		MaximumRectangle mr = new MaximumRectangle();
		int a[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int x = mr.solve(a);
		System.out.println(x);
	}

}