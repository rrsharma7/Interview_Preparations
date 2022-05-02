package LeetCode.BinaryTreee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	int max_sum = Integer.MIN_VALUE;
	private int maxGain(TreeNode root) {
		if (root == null)
			return 0;
		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);

		int newPath = root.val + leftGain + rightGain;
		max_sum = Math.max(max_sum, newPath);
		return root.val + Math.max(leftGain, rightGain);
	}

	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return max_sum;
	}

	public static void main(String[] s) {
		BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int x=bt.maxPathSum(root);
		System.out.println(x);
	}
}
