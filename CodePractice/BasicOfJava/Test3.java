// First sort array
package test;

public class Test3 {

	public int solve(int[] A) {
		int maxEven = Integer.MIN_VALUE;
		int minOdd = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0)
				maxEven = Math.max(A[i],maxEven);
			else
				minOdd = Math.min(A[i],minOdd);
		}
		return maxEven - minOdd;

	}

	public static void main(String[] args) {
		Test3 arrMaxMin = new Test3();
		int[] arr = {  -98, 54, -52, 15, 23, -97, 12, -64, 52, 85 };
		int ans = arrMaxMin.solve(arr);
		System.out.println("result=" + ans);
	}

}
