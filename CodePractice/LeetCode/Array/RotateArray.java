package LeetCode.Array;

public class RotateArray {

	public int[] rotate(int[] nums, int k) {
		int n = nums.length;
		k=k%n;
		reverse(nums, 0, n - k-1);
		reverse(nums, n - k, n-1);
		reverse(nums, 0, n-1);
		return nums;
	}

	public void reverse(int nums[], int low, int high) {
		while (low < high) {
			int temp = nums[low];
			nums[low] = nums[high];
			nums[high] = temp;
			low++;
			high--;
		}
	}

	public static void main(String[] args) {
		RotateArray mss = new RotateArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int res[] = mss.rotate(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

}

//1,2,3,4,5,6,7

//5671234