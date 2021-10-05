package RecursionBacktracking1;

import java.util.HashSet;
import java.util.Set;

class NumberOfSquarefulArrays {

	int count;
	public int solve(int[] nums) {
		int n = nums.length;
		if (n < 2)
			return count;
		backtrack(nums, n, 0);
		return count;

	}

	void backtrack(int[] nums, int n, int start) {
		if (start == n) {
			count++;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < n; i++) {
			if (set.contains(nums[i]))
				continue;
			swap(nums, start, i);
			if (start == 0 || isPerfectSq(nums[start], nums[start - 1]))
				backtrack(nums, n, start + 1);
			swap(nums, start, i);
			set.add(nums[i]);
		}
	}

	void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;

	}

	boolean isPerfectSq(int a, int b) {
		int x = a + b;
		double sqrt = Math.sqrt(x);
		return (sqrt - (int) sqrt) == 0 ? true : false;
	}

	public static void main(String[] args) {
		NumberOfSquarefulArrays numberOfSquarefulArrays = new NumberOfSquarefulArrays();
		int[] num= {1, 17, 8};
		int res=numberOfSquarefulArrays.solve(num);
		System.out.println("res="+res);
	}
}
