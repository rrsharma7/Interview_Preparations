package problemsolving3;

public class ConstructArray {

	public int[] solve(final int A, final int B, final int C) {
		int[] ans = new int[A];

		for (int i = 0; i < A; i++) {
			ans[i] = Integer.MAX_VALUE;
		}

		for (int a = 1; a <= 50; a++) {
			for (int d = 1; d <= 50; d++) {
				int[] temp = new int[A];

				for (int i = 0; i < A; i++) {
					temp[i] = a + i * d;
				}

				boolean fB = false;
				boolean fC = false;
				for (int i = 0; i < A; i++) {
					if (temp[i] == B)
						fB = true;
					else if (temp[i] == C)
						fC = true;
				}

				if (fB == true && fC == true && temp[A - 1] < ans[A - 1]) {
					for (int i = 0; i < A; i++) {
						ans[i] = temp[i];
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] s) {
		ConstructArray constructArray = new ConstructArray();
		int A = 5; int B = 20 ;int C = 50;
		constructArray.solve(A,B,C);

	}
}
