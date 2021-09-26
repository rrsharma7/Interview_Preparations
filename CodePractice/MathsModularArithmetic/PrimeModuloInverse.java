package MathsModularArithmetic;

public class PrimeModuloInverse {

	public int solve(int A, int B) {
		int result = 0;
		int g = gcd(A, B);
		if (g != 1)
			result = -1;
		else
			result = power(A, B - 2, B);
		return result;
	}

	static int power(int x, int y, int B) {
		if (y == 0)
			return 1;
		int p = power(x, y / 2, B) % B;
		p = (int) ((p * (long) p) % B);
		if (y % 2 == 0)
			return p;
		else
			return (int) ((x * (long) p) % B);
	}
	static int gcd(int A, int B) {
		if (A == 0)
			return B;
		return gcd(B % A, A);
	}

	public static void main(String[] args) {
		PrimeModuloInverse abModulo = new PrimeModuloInverse();
		abModulo.solve(6, 23);

	}
}
