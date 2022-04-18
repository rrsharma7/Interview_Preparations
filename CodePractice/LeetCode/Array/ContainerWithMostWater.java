package LeetCode.Array;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int area = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, area);
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}

	public static void main(String[] args) {
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int[] arr = { 1,8,6,2,5,4,8,3,7};
		int x = cwmw.maxArea(arr);
		System.out.println(x);
	}

}
