package MathsModularArithmetic;

public class MagicNumber {

	public int solve(int A) {
		int ans = 0;
		int x = 1;
		while (A > 0) {
			x = x * 5;
			if (A % 2 == 1)
				ans += x;
			A /= 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		MagicNumber po3 = new MagicNumber();
		po3.solve(3);

	}
}
