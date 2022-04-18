// First sort array
package test;

public class Test13 {

	public int[] solve(int[] A) {
		int arr[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i == 0)

				arr[i] = A[i] * A[i + 1];

			else if (i < A.length - 1)
				arr[i] = A[i - 1] * A[i + 1];
			else if (i == A.length - 1)

				arr[i] = A[A.length - 2] * A[A.length - 1];
			}
		return arr;
	}

	public static void main(String[] args) {
		Test13 test9 = new Test13();
		int arr[] = { 0 };
		test9.solve(arr);
	}

}
