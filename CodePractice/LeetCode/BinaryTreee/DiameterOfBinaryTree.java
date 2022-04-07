package Leetcode.BinaryTreee;

public class DiameterOfBinaryTree

{
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

	public int diameterOfBinaryTree(TreeNode root) {

		int[] maxi = new int[1];
		height(root, maxi);
		return maxi[0];

	}

	public int height(TreeNode root, int[] maxi) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left, maxi);
		int rh = height(root.right, maxi);
		maxi[0] = Math.max(maxi[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] s) {
		DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int ans = dbt.diameterOfBinaryTree(root);
		System.out.println(ans);

	}
}
