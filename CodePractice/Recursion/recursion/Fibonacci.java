package recursion;

public class Fibonacci {

	public int findAthFibonacci(int A) {
		if (A == 0 || A==1)
			return A;
		return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
	}

	public static void main(String[] args) {
		Fibonacci test1 = new Fibonacci();
		int A = 9;
		int str = test1.findAthFibonacci(A);
		System.out.println(str);

	}

}
