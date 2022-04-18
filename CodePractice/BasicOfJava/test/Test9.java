// First sort array
package test;

public class Test9 {

	public int solve(int[] A, int B) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.println("i="+A[i]);
				System.out.println("J="+A[j]);
				int sum = A[i] + A[j];
				if (sum == B) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Test9 test9 = new Test9();
		int arr[] = { 1, 2, 3, 4 };
		int a = test9.solve(arr, 7);
		System.out.println("count=" + a);

	}

}
