package LeetCode.DynamicProgramming;

public class TrappingRainWater {

	public int trap(int[] height) {
		int ans = 0;
		int leftMax = 0;
		int rightMax = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			if (height[left] > leftMax) {
				leftMax = height[left];
			}
			if (height[right] > rightMax) {
				rightMax = height[right];
			}
			if (leftMax < rightMax) {
				ans += Math.max(0,leftMax-height[left]);
				left++;
			} else {
				ans += Math.max(0,rightMax-height[right]);
				right--;
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		TrappingRainWater trw = new TrappingRainWater();
		int arr[] = new int[] { 4, 2, 0, 3, 2, 5 };
		int ans = trw.trap(arr);
		System.out.println(ans);
	}
}
