package LeetCode.BinarySearchTree;

import java.util.LinkedList;

public class KthSmallestElemenBST {
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

	public int kthSmallest(TreeNode root, int k) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		if (root == null)
			return 0;
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			while (--k == 0)
				return root.val;
			root = root.right;
		}
	}

	public static void main(String[] s) {
		KthSmallestElemenBST iibt = new KthSmallestElemenBST();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = null;
		root.left.right = new TreeNode(2);
		int x = iibt.kthSmallest(root, 1);
		System.out.println(x);

	}
}
