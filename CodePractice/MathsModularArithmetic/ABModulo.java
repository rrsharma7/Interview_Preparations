package MathsModularArithmetic;

public class ABModulo {

	public int solve(int A, int B) {
		int m = 0;
		if (A == B)
			m = A;
		else {
			m = Math.abs(A - B);
		}
		return m;
	}

	public static void main(String[] args) {
		ABModulo abModulo = new ABModulo();
		abModulo.solve(5, 10);

	}
}
