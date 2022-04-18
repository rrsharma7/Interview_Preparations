// First sort Aay
package test;

public class Test22 {

	public int[][] solve(int A) {
		int[][] arr = new int[A][A];
		if(A==1)
			arr[0][0]=1;
			
		for (int i = 0; i < A; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					arr[i][j] = 1;
				else 
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

			}
			for (int k = A - 1; k > i; k--)
				arr[k][i] = 0;
		}
		return arr;
    }

	public static void main(String[] args) {
		Test22 test9 = new Test22();
		test9.solve(5);
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
