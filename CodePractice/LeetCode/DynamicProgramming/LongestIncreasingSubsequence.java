package LeetCode.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	 public int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        Arrays.fill(dp, 1);
	        
	        for (int i = 1; i < nums.length; i++) {
	            for (int j = 0; j < i; j++) {
	                if (nums[i] > nums[j]) {
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                }
	            }
	        }
	        
	        int longest = 0;
	        for (int c: dp) {
	            longest = Math.max(longest, c);
	        }
	        
	        return longest;
	    }

	public static void main(String args[]) {
		LongestIncreasingSubsequence trw = new LongestIncreasingSubsequence();
		int arr[] = new int[] { 5,8,7,1,9 };
		int ans = trw.lengthOfLIS(arr);
		System.out.println(ans);
	}
}
