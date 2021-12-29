/**
Q1. Largest Rectangle in Histogram

Problem Description

Given an array of integers A .

A represents a histogram i.e A[i] denotes height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format

The only argument given is the integer array A.



Output Format

Return the area of largest rectangle in the histogram.



Example Input

Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output

Output 1:

 10
Output 2:

 2


Example Explanation

Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.


*/

package StackII;

import java.util.Stack;

class LargestRectangleHistogram {

	public int largestRectangleArea(int[] A) {

		int[] left_short = new int[A.length];
		int[] right_short = new int[A.length];

		Stack<Integer> stack = new Stack<Integer>();

		left_short[0] = -1;
		stack.push(0);
		for (int i = 1; i < A.length; i++) {
			while (!stack.isEmpty()) {
				if (A[stack.peek()] < A[i]) {
					left_short[i] = stack.peek();
					stack.push(i);
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				left_short[i] = -1;
				stack.push(i);
			}
		}

		stack = new Stack<Integer>();

		right_short[A.length - 1] = A.length;
		stack.push(A.length - 1);
		for (int i = A.length - 2; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (A[stack.peek()] < A[i]) {
					right_short[i] = stack.peek();
					stack.push(i);
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				right_short[i] = A.length;
				stack.push(i);
			}
		}

		int max_area = 0;
		for (int i = 0; i < A.length; i++) {
			max_area = Math.max(max_area, (right_short[i] - left_short[i] - 1) * A[i]);
		}

		return max_area;
	}

	public static void main(String args[]) {
		LargestRectangleHistogram lrh = new LargestRectangleHistogram();
		int a[] = { 2, 1, 5, 6, 2, 3 };
		int x = lrh.largestRectangleArea(a);
		System.out.println(x);
	}

}