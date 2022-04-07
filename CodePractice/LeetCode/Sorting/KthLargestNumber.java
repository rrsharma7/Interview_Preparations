package Leetcode.Sorting;

import java.util.PriorityQueue;

public class KthLargestNumber {

	 public String kthLargestNumber(String[] nums, int k) {
	        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
	          if(a.length()==b.length())return b.compareTo(a);
	          else if(a.length()<b.length())return 1;
	          else return -1;
	        });
	        for(String i:nums)pq.add(i);
	        while(k--!=1)pq.poll();
	        return pq.peek();
	    }
	public static void main(String[] args) {
		KthLargestNumber kth = new KthLargestNumber();
		String arr[] = {"3","6","7","10"};
		String ans = kth.kthLargestNumber(arr, 4);
		System.out.println(ans);

	}

}
