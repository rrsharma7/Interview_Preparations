package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		Double sol;
		List<Integer> res = new ArrayList<Integer>();
		for (int i : nums1)
			res.add(i);
		for (int j : nums2)
			res.add(j);
		Collections.sort(res);
		if (res.size() % 2 == 0) {
			sol = Double.valueOf(res.get(res.size() / 2));
			sol += Double.valueOf(res.get((res.size() / 2) - 1));
			sol = sol / 2;
		} else
			sol = Double.valueOf(res.get((res.size() - 1) / 2));
		return sol;
	}

	public static void main(String[] args) {
		MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
		int nums1[] = { 1, 2 };
		int nums2[] = { 3, 4 };
		medianSortedArrays.findMedianSortedArrays(nums1, nums2);

	}

}
