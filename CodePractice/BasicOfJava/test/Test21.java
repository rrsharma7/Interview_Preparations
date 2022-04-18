// First sort Aay
package test;

public class Test21 {

	public int solve(int[][] A) {
		int n = A.length;
		int rowCount = 0;
		int maxCount = 0;
		int res=0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (A[i][j] == 1) {
					rowCount++;
					if (maxCount < rowCount) {
						maxCount = rowCount;
						res=i;
						
					}
				}
			}
			rowCount=0;
			
		}
		return res;
	}

	public static void main(String[] args) {
		Test21 test9 = new Test21();
		int[][] arr = { { 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1},{0, 0, 0, 1, 1},{0, 0, 0, 0, 1},{0, 0, 0, 1, 1} };
		test9.solve(arr);
	}
}
