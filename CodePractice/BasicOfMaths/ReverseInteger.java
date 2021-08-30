package BasicOfMaths;

public class ReverseInteger {
	

	public int reverse(int A) {
		long result = 0;
		while (A != 0) {
			int mod = A % 10;
			result = result * 10 + mod;
			A = A / 10;

			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;

		}
		return (int) result;
	}
	
	public static void main(String[] args) {
		ReverseInteger test1 = new ReverseInteger();
		int ans = test1.reverse(-321);
		System.out.println("ans=" + ans);

	}

}
