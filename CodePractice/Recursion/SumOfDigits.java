package recursion;

public class SumOfDigits {

	public int solve(int A) {
		if (A == 0)
			return 0;
		return (A % 10 + solve(A / 10));   
	}

	public static void main(String[] args) {
		SumOfDigits test1 = new SumOfDigits();
		int A = 46;
		int str = test1.solve(A);
		System.out.println(str);

	}

}
