package problemsolving6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRowsBinaryMatrix {

	public int[] solve(int[][] A) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			int decimal = 0;
			for (int j = 0; j < A[i].length; j++)
				decimal += decimal + A[i][j] * Math.pow(2, j);
			if (set.contains(decimal)) {
				int k = i + 1;
				list.add(k);
			} else
				set.add(decimal);
		}
		int res[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			res[i] = list.get(i);
		return res;
	}

	public static void main(String[] s) {
		DuplicateRowsBinaryMatrix drm = new DuplicateRowsBinaryMatrix();
		int mat[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		drm.solve(mat);

	}
}
