package arrays2;

class MinimumSwaps2 {

	public int solve(int[] A) {
		int swap = 0;
		for (int i = 0; i < A.length; i++) {
			while (A[i] != i) {
				int tmp = A[i];
				int tmp2 = A[A[i]];
				A[i] = tmp2;
				A[tmp] = tmp;
				swap++;
			}
		}
		return swap;
	}

	public static void main(String[] args) {
		MinimumSwaps2 ms2 = new MinimumSwaps2();
		int arr[] = { 2, 0, 1, 3 };
		System.out.println(ms2.solve(arr));
	}
}
