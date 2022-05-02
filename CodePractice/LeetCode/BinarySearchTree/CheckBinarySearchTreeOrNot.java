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

	private boolean validate(TreeNode root, Integer low, Integer high) {
		if (root == null)
			return true;
		if ((low != null && low >= root.val) || (high != null && high <= root.val)) {
			return false;
		}
		return validate(root.left, low, root.val) && validate(root.right, root.val, high);
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
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
