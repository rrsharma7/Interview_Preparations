package BasicOfMaths;

public class PrimeGame {
	public int solve(int A, int B) {
		if (B == 1 || A % 2 == 0) {
			return 2;
		}
		return 1;
	}

	public static void main(String[] args) {
		PrimeGame test1 = new PrimeGame();
		int ans = test1.solve(2, 4);
		System.out.println("ans=" + ans);

	}

}
