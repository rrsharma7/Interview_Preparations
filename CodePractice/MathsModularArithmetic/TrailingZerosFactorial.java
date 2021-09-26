package MathsModularArithmetic;

public class TrailingZerosFactorial {

	public int trailingZeroes(int A) {
		if (A < 0)
			return -1;
		int count = 0;
		for (int i = 5; A / i >= 1; i *= 5)
			count += A / i;

		return count;
	}

	public static void main(String[] args) {
		TrailingZerosFactorial tzf = new TrailingZerosFactorial();
		tzf.trailingZeroes(5);

	}
}
