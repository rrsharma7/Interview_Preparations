package problemsolving2;

public class ColumnSum {

	public int[] solve(int[][] A) {
		int sumCol;
		int rows = A.length;
		int cols = A[0].length;
		int res[] = new int[cols];
		for (int i = 0; i < cols; i++) {
			sumCol = 0;
			for (int j = 0; j < rows; j++)
				sumCol = sumCol + A[j][i];
			res[i] = sumCol;
		}
		return res;
	}

	public static void main(String[] s) {
		ColumnSum sm = new ColumnSum();
		int nums[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 2, 3, 4 } };
		sm.solve(nums);

	}
}
