package problemsolving3;

import java.util.Arrays;

public class SumTheDifference {

	public static int MOD = 1000000007;
	public int solve(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		long minSum = 0, maxSum = 0;
		for (int i = 0; i < n; i++) {
			maxSum = 2 * maxSum + A[n - 1 - i];
			maxSum %= MOD;
			minSum = 2 * minSum + A[i];
			minSum %= MOD;
		}

		return (int) ((maxSum - minSum + MOD) % MOD);
	}

	public static void main(String[] s) {
		SumTheDifference sumTheDifference = new SumTheDifference();
		int nums[] = { 1, 2, 3, 5, 7 };
		int result = sumTheDifference.solve(nums);
		System.out.print("result=" + result);

	}
}
