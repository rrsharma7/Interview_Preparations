package Leetcode.BinaryTreee;

public class HeightOfABinaryTree {
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
	private int heightOfBinaryTree(TreeNode root) {
		if (root == null)
			return -1;
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		return Math.max(leftHeight, rightHeight) + 1;

	}
	public static void main(String[] s) {
		HeightOfABinaryTree hb = new HeightOfABinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int ans = hb.heightOfBinaryTree(root);
		System.out.println(ans);
	}

}
