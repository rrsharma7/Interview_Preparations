package Leetcode.Sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			pqueue.add(nums[i]);
		}

		while (k > 0) {
			ans = pqueue.poll();
			k--;
		}

		return ans;
	}

	public static void main(String[] args) {
		KthLargestElement kth = new KthLargestElement();
		int[] arr = {3,2,3,1,2,4,5,5,6};
		int ans = kth.findKthLargest(arr, 4);
		System.out.print(ans);

	}

}
