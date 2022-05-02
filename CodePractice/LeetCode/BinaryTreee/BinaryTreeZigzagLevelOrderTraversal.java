package LeetCode.BinaryTreee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		int level = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			LinkedList<Integer> subList = new LinkedList<>();
			int size = queue.size();
			while (size != 0) {
				TreeNode curr = queue.poll();
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
				if (level % 2 == 0)
					subList.add(curr.val);
				else
					subList.add(0, curr.val);
				size--;
			}
			level++;
			res.add(subList);

		}
		return res;
	}

	public static void main(String[] s) {
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		bt.zigzagLevelOrder(root);
	}
}
