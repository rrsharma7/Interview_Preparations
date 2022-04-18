package LeetCode.Array;

public class MaximumSubarraySum {

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSubarraySum mss = new MaximumSubarraySum();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int x = mss.maxSubArray(arr);
		System.out.println(x);
	}

}
