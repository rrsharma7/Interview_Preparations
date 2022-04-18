package ProblemSolving4;

public class MinimizeAbsoluteDifference {

	public int solve(int[] A, int[] B, int[] C) {
		int i = 0;
		int j = 0;
		int k = 0;
		int p = A.length;
		int q = B.length;
		int r = C.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int minDiff = Math.abs(Math.max(A[i], Math.max(B[j], C[k]))
	                - Math.min(A[i], Math.min(B[j], C[k])));
		while (i < p && j < q && k < r) {
			max = Math.max(A[i], B[j]);
			max = Math.max(max, C[k]);
			min = Math.min(A[i], B[j]);
			min = Math.min(min, C[k]);
			if (max - min < minDiff) {
				minDiff = max - min;
			}
			if(max-min==0) break;
			if (min == A[i]) {
				i++;
			} else if (min == B[j]) {
				j++;
			} else {
				k++;
			}
		}
		return minDiff;
	}

	public static void main(String[] s) {
		MinimizeAbsoluteDifference majorityElement = new MinimizeAbsoluteDifference();
		int A[] = { 1, 4, 5, 8, 10 };
		int B[] = { 6, 9, 15 };
		int C[] = { 2, 3, 6, 6 };
		int result = majorityElement.solve(A, B, C);
		System.out.print("result=" + result);

	}
}
