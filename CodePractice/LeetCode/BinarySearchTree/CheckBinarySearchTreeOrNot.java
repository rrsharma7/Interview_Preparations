package LeetCode.BinarySearchTree;

public class CheckBinarySearchTreeOrNot {
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

	public boolean isValidBST(TreeNode root) {

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max)
			return false;
		return (isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max));

	}

	public static void main(String[] s) {
		CheckBinarySearchTreeOrNot cbst = new CheckBinarySearchTreeOrNot();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		boolean flag = cbst.isValidBST(root);
		System.out.println("binary tree =" + flag);

	}
}
