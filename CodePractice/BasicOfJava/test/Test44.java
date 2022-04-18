package test;

import java.util.Arrays;

public class Test44 {

	public int solve(int[] A, int B) {
		int maxx = 0;
		int k = B;
		for (int i = 0; i < A.length; i++) {
			maxx = Math.max(maxx, A[i]);
		}

		int[] freq = new int[maxx + 1];
		Arrays.fill(freq, 0);

		for (int i = 0; i < A.length; i++) {
			freq[A[i]]++;
		}

		int i = 0, j = maxx;
		while (i < j) {

			if (freq[i] > freq[j]) {

				if (freq[j] <= k) {
					freq[j - 1] = freq[j - 1] + freq[j];
					k = k - freq[j];
					j--;
				} else {
					break;
				}
			} else {
				if (freq[i] <= k) {
					freq[i + 1] = freq[i + 1] + freq[i];
					k = k - freq[i];
					i++;
				} else {
					break;
				}
			}
		}

		return j - i;
	}

	public static void main(String[] args) {
		Test44 test26 = new Test44();
		int[] test = { 4, 6, 3, 1, 4 };
		int x = test26.solve(test, 5);
		System.out.println("=" + x);

	}
}
