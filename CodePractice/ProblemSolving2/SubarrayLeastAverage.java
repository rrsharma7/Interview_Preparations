package problemsolving2;

public class SubarrayLeastAverage {

	public int solve(int[] A, int B) {
		int n = A.length;
		if (n < B)
			return -1;
		int index = 0;
		int sum = 0;
		for (int i = 0; i < B; i++)
			sum = sum + A[i];
		int minsum = sum;
		for (int i = B; i < n; i++) {
			sum = sum + A[i] - A[i - B];
			if (sum < minsum) {
				minsum = sum;
				index = (i - B + 1);
			}
		}
		return index;
	}

	public static void main(String[] s) {
		SubarrayLeastAverage sm = new SubarrayLeastAverage();
		int nums[] = { 3, 7, 5, 20, -10, 0, 12};
		int result = sm.solve(nums, 2);
		System.out.print(result);

	}
}
