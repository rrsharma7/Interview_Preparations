package LeetCode.Sorting;

import java.util.*;

public class ContainsDuplicate {

	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		int start = 0;
		int end = start + 1;
		Arrays.sort(nums);
		int max = 0;
		while (start < end && end<nums.length) {
			if (nums[end] > nums[start]) {
				max = Math.max(max, nums[end]-nums[start]);
			}
			start++;
			end++;
		}
		return max;
	}

	public static void main(String[] args) {
		ContainsDuplicate maximumGap = new ContainsDuplicate();
		int[] arr = {1,1,1,1};
		int ans = maximumGap.maximumGap(arr);
		System.out.print(ans);

	}

}
