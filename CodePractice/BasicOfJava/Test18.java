// First sort Aay
package test;

public class Test18 {

	public void solve(int[][] A) {
		int n = A.length;
		int[][] t = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				t[i][j] = A[j][i];
			}

		}
		for (int k = 0; k < n; k++) {
			for (int l = 0; l <n/2; l++) {
				int temp = t[k][l];
				t[k][l] = t[k][n - l - 1];
				t[k][n - l - 1] = temp;
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.println("arr[" + i + "][" + j + "] = " + t[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		Test18 test9 = new Test18();
		int[][] arr = { { 1,2 }, {3,4} };
		test9.solve(arr);
	}
}

//1  2  3
//4  5  6
//7  8  9
//
//
//3  6  9 
//2  5  8 
//1  4  7
