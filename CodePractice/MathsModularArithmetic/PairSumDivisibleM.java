
package MathsModularArithmetic;

public class PairSumDivisibleM {

	public int solve(int[] A, int B) {
		long mod = (long) (1e9 + 7);
		long cnt[] = new long[B];
		for (int x : A)
			cnt[x % B]++;
		long ans = cnt[0] * (cnt[0] - 1) / 2;
		for (int i = 1, j = B - 1; i <= j; i++, j--) {
			if (i == j)
				ans = (ans + cnt[i] * (cnt[i] - 1) / 2) % mod;
			else
				ans = (ans + cnt[i] * cnt[j]) % mod;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		PairSumDivisibleM psdm = new PairSumDivisibleM();
		int A[] = { 1, 2, 3, 4, 5 };
		int B = 2;
		int x = psdm.solve(A, B);
		System.out.println("x=" + x);
	}
}
