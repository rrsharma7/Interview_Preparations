package Leetcode.BinarySearch;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

	// 2 Loops
//	public int findDuplicate_2loops(int[] nums) {
//		int len = nums.length;
//		for (int i = 0; i < len; i++) {
//			for (int j = i + 1; j < len; j++) {
//				if (nums[i] == nums[j]) {
//					return nums[i];
//				}
//			}
//		}
//
//		return len;
//	}
//	Analysis
//	Time Complexity:O(n^2)
//	Space Complexity: O(1)
//	
//	 public static int findDuplicate(int[] nums) {
//	        int len = nums.length;
//	        int[] cnt = new int[len + 1];
//	        for (int i = 0; i < len; i++) {
//	            cnt[nums[i]]++;
//	            if (cnt[nums[i]] > 1) {
//	                return nums[i];
//	            }
//	        }
//
//	        return len;
//	    }

//	Analysis
//	Time Complexity: O(n)
//	Space Complexity: O(n)

//	 public static int findDuplicate(int[] nums) {
//	        Set<Integer> set = new HashSet<>();
//	        int len = nums.length;
//	        for (int i = 0; i < len; i++) {
//	            if (!set.add(nums[i])) {
//	                return nums[i];
//	            }
//	        }
//
//	        return len;
//	    }
	public int findDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int n = nums.length;
		while (low < high) 
		{
			int mid = low + (high - low) / 2;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (nums[i] <= mid) {
					cnt++;
				}
			}

			if (cnt <= mid) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		FindDuplicate fd = new FindDuplicate();
		int[] arr = { 1, 3, 4, 2, 2 };
		int ans = fd.findDuplicate(arr);
		System.out.print(ans);

	}

}
