package test;

import java.util.Arrays;

public class Test42 {

	public int solve(int[] A) {
		Arrays.sort(A);
		int counter = 0;
		for (int i = 1; i < A.length; i++) {
			while (A[i] <= A[i - 1]) {
				A[i]++;
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		Test42 test26 = new Test42();
		int a[] = { 1, 1, 1, 1 };
		test26.solve(a);
	}
}
