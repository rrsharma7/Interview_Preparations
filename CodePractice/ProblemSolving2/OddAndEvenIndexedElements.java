package problemsolving2;

public class OddAndEvenIndexedElements {

	public int solve(int[] A) {
		int n = A.length;
		int[] leftOdd = new int[n], leftEven = new int[n];
		int[] rightOdd = new int[n], rightEven = new int[n];
		int odd = 0, even = 0;
		for (int i = 0; i < n; i++) {
			leftOdd[i] = odd;
			leftEven[i] = even;
			if (i % 2 == 0)
				even += A[i];
			else
				odd += A[i];
		}
		odd = 0;
		even = 0;
		for (int i = n - 1; i >= 0; i--) {
			rightOdd[i] = odd;
			rightEven[i] = even;
			if (i % 2 == 0)
				even += A[i];
			else
				odd += A[i];
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (leftOdd[i] + rightEven[i] == leftEven[i] + rightOdd[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] s) {
		OddAndEvenIndexedElements sm = new OddAndEvenIndexedElements();
		int A[] = { 2, 1, 6, 4 };
		int result = sm.solve(A);
		System.out.print(result);

	}
}
