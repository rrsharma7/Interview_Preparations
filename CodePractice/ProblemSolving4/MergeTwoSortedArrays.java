package problemsolving4;

public class MergeTwoSortedArrays {

	public int[] solve(final int[] A, final int[] B) {
		int i = 0, j = 0, k = 0;
		int m = A.length;
		int n = B.length;
		int[] res = new int[m + n];
		while (i < m && j < n) {
			if (A[i] < B[j])
				res[k++] = A[i++];
			else
				res[k++] = B[j++];
		}
		while (i <m)
			res[k++] = A[i++];
		while (j <n)
			res[k++] = B[j++];
		return res;
	}

	public static void main(String[] s) {
		MergeTwoSortedArrays msArr = new MergeTwoSortedArrays();
		int A[] = {-4, -3, 0};
		int B[] = {2};
		msArr.solve(A, B);
	}
}
