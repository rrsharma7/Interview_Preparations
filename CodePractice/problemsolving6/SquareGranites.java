package problemsolving6;

public class SquareGranites {

	public int solve(int A, int B, int C) {
		 return ((A+C-1)/C)*((B+C-1)/C);
	}



	public static void main(String[] s) {
		SquareGranites squareGranites = new SquareGranites();
		int ans = squareGranites.solve(6, 6, 4);
		System.out.println(ans);
	}
}
