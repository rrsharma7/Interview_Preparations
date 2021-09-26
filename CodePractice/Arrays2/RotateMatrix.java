package arrays2;

public class RotateMatrix {

	public void rotate(int[][] A) {
		if (A.length <= 0) {
			return;
		}
		// Transpose of a matrix.
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (j > i) {
					int temp = A[i][j];
					A[i][j] = A[j][i];
					A[j][i] = temp;
				}
			}
		}
		// swap left and right column values.
		int lc = 0;
		int rc = A[0].length - 1;
		while (lc <= rc) {
			for (int i = 0; i < A.length; i++) {
				int temp = A[i][lc];
				A[i][lc] = A[i][rc];
				A[i][rc] = temp;
			}
			lc++;
			rc--;
		}
//		for (int i = 0; i < 2; i++)
//			for (int j = 0; j < 2; j++)
//				System.out.println("arr[" + i + "][" + j + "] = " + A[i][j]);

	}

	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		int[][] arr = { { 1, 2 }, { 3, 4 } };
		rm.rotate(arr);

	}
}
