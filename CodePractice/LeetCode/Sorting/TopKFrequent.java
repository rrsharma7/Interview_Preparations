package Leetcode.Sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

	public int[] topKFrequent(int[] nums, int k) {
        // key: nums[i] - value: count of nums[i]
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        // max heap (a, b are keys of count map)
     
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        // add keys into pq 
        for (int n : count.keySet()) {
            pq.add(n);
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        
        return res;
        
    }
	public static void main(String[] args) {
		TopKFrequent cd = new TopKFrequent();
		int[] arr = { 1, 1, 1, 1, 2, 2, 3 };
		int ans[]=cd.topKFrequent(arr, 2);
		for (int m = 0; m < ans.length; m++)
			System.out.println(ans[m]);

	}

}
