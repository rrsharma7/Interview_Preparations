package arrays1;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {

	public int maxSubArray(final List<Integer> A) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < A.size(); i++) {
			curSum = curSum + A.get(i);
			maxSum = Math.max(maxSum, curSum);
			if (curSum < 0)
				curSum = 0;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		MaxSumContiguousSubarray rwt = new MaxSumContiguousSubarray();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(-10);
		rwt.maxSubArray(list);
	}
}
