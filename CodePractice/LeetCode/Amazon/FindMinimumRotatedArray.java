package LeetCode.Amazon;

public class FindMinimumRotatedArray {

	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (mid == 0 && nums[mid] < nums[mid + 1]) {
				return nums[mid];
			}
			if (mid == nums.length - 1 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return -1;
	}

	

	public static void main(String[] args) {
		FindMinimumRotatedArray fmra = new FindMinimumRotatedArray();
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int ans = fmra.findMin(arr);
		System.out.print(ans);

	}

}
