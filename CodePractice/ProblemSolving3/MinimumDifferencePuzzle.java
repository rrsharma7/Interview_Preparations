package ProblemSolving3;

import java.util.Arrays;

public class MinimumDifferencePuzzle {

	public int solve(int[] A, int B) {
		Arrays.sort(A);//5, 7, 10, 10, 12, 22
		int minDiff = Integer.MAX_VALUE;
		for (int i = B - 1; i < A.length; i++)
			minDiff = Math.min(minDiff, A[i] - A[i - (B - 1)]);
		return minDiff;
	}

	public static void main(String[] s) {
		MinimumDifferencePuzzle sumTheDifference = new MinimumDifferencePuzzle();
		int nums[] = { 10, 12, 10, 7, 5, 22 };
		int result = sumTheDifference.solve(nums, 4);
		System.out.print("result=" + result);

	}
}
