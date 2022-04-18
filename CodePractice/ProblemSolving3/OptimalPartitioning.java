package ProblemSolving3;

import java.util.Arrays;

public class OptimalPartitioning {

	public int solve(int[] A) {
		int N = A.length;
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < N;i++){
            ans = Math.min(ans, A[i] - A[i - 1]);
        }
        return ans;
	}

	public static void main(String[] s) {
		OptimalPartitioning sumTheDifference = new OptimalPartitioning();
		int nums[] = { 2, 1, 3, 2, 4, 3 };
		int result = sumTheDifference.solve(nums);
		System.out.print("result=" + result);

	}
}
