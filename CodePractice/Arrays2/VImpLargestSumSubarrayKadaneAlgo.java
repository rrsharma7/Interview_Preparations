package arrays2;

public class VImpLargestSumSubarrayKadaneAlgo {

	void largestSum(int a[]) {
		int currentSum = 0;
		int maxSum = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum = currentSum + a[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}

		}
		System.out.println("Max Sum=" + maxSum);
	}

	public static void main(String[] args) {
		VImpLargestSumSubarrayKadaneAlgo largestSum = new VImpLargestSumSubarrayKadaneAlgo();
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		largestSum.largestSum(arr);

	}
}
