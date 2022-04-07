package Leetcode.BinaryTreee;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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

	List<Integer> result = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return result;
		}
		inorderTraversal(root.left);
		result.add(root.val);
		inorderTraversal(root.right);
		return result;
	}

	public static void main(String[] s) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> list = bt.inorderTraversal(root);
		list.stream().forEach(System.out::println);
	}
}
