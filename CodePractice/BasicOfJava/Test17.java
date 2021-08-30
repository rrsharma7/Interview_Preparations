// First sort Aay
package test;

public class Test17 {

	public int solve(int[] A) {
		int min = A[0];
		int max = A[0];
		int pos_min = -1, pos_max = -1, ans = Integer.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < min)
				min = Math.min(min, A[i]);
			else if (A[i] > max)
				max = Math.max(max, A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == min)
				pos_min = i;
			if (A[i] == max)
				pos_max = i;

			if (pos_max != -1 && pos_min != -1)
				ans = Math.min(ans, Math.abs(pos_min - pos_max) + 1);
		}

		return ans;

	}

	public static void main(String[] args) {
		Test17 test9 = new Test17();
		int A[] = { 3, 5, 2, 5, 4, 1, 3 };
		test9.solve(A);
	}

}
