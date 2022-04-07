package Leetcode.BinarySearch;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int shortest = Integer.MAX_VALUE;
		while (right < nums.length) {
			sum += nums[right];
			if (sum >= target) 
			{
				while (sum >= target) {
					sum = sum - nums[left];
					left++;
				}
				shortest = Math.min(shortest, right-left+2);
			}
			right++;
		}
		return shortest == Integer.MAX_VALUE ? 0 : shortest;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum fmra = new MinimumSizeSubarraySum();
		int[] arr = { 2, 3, 1, 2, 4, 3 };

		
		
		
		int ans = fmra.minSubArrayLen(7, arr);
		System.out.print(ans);

	}

}

//2,3,1,2,4,3