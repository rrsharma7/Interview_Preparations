package Leetcode.Array;

import java.util.*;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int smallest_positive_num = Integer.MAX_VALUE;
		int max_num = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (i > 0 && smallest_positive_num > i) {
				smallest_positive_num = i;
			}
			max_num = Math.max(max_num, i);
			set.add(i);
		}

		if (smallest_positive_num == Integer.MAX_VALUE)
			return 1;

		int num = -1;

		for (int i = 1; i < smallest_positive_num; ++i) {
			return i;
		}
		for (int i = smallest_positive_num + 1; i < max_num; ++i) {
			if (!set.contains(i))
				return i;
		}
		return max_num + 1;

	}

	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] arr = { 2, 1, 0 };
		int x = fmp.firstMissingPositive(arr);
		System.out.println(x);
	}

}
