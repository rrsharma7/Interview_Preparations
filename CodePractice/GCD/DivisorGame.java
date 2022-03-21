package GCD;

public class DivisorGame {

	 public int gcd(int x, int y) {
	        if (x == 0)
	            return y;
	        return gcd(y % x, x);
	    }
	    public int solve(int A, int B, int C) {
	        long lcm = (long) B * C / gcd(B, C);
	        if (lcm > A)
	            return 0;
	        return (int)(A / lcm);
	    }

	public static void main(String[] args) {
		DivisorGame dm = new DivisorGame();
		int res=dm.solve(12,3,2);
		System.out.print(res);
		
	}

}
