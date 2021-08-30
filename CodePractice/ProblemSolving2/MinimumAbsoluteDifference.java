package problemsolving2;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

	public int solve(int[] A) {
		int n = A.length;
		int min = Integer.MAX_VALUE;
		Arrays.sort(A);
		int j = 1;
		for (int i = 0; i < n - 1; i++) {
			int value = Math.abs(A[i] - A[j]);
			min = Math.min(min, value);
			j++;
		}
		return min;

	}

	public static void main(String[] s) {
		MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
		int nums[] = { 5, 17, 100, 11 };
		int x = minimumAbsoluteDifference.solve(nums);
		System.out.println(x);
	}
}
