package Leetcode.Array;

import java.util.*;

public class SlidingWindowMaximum {

//	public int[] maxSlidingWindow(int[] nums, int k) {
//		int max = Integer.MIN_VALUE;
//		int n = nums.length;
//		int res[] = new int[n - k + 1];
//		for (int i = 0; i < nums.length; i++) {
//			if (i + k<=nums.length) 
//			{
//				for (int j = i; j < i + k; j++) {
//					max = Math.max(max, nums[j]);
//	
//				}
//				res[i] = max;
//				max = Integer.MIN_VALUE;
//			}
//
//		}
//		return res;
//
//	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int n = nums.length;
		int index = 0;
		int ans[] = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			if (!dq.isEmpty() && dq.peekFirst() == i - k)
				dq.pollFirst();
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.pollLast();
			dq.addLast(i);
			if (i >= k - 1) {
				ans[index++] = nums[dq.peekFirst()];
			}
		}

		return ans;

	}
	
	//335567

	public static void main(String[] args) {
		SlidingWindowMaximum mss = new SlidingWindowMaximum();
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int res[] = mss.maxSlidingWindow(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

}

//1,2,3,4,5,6,7

//5671234