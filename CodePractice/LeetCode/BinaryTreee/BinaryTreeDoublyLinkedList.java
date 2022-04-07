package Leetcode.BinaryTreee;

import java.util.Stack;

public class BinaryTreeDoublyLinkedList {

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

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> treeStack = new Stack<>();
		treeStack.push(root);
		while (!treeStack.isEmpty()) {
			TreeNode currentNode = treeStack.pop();
			if (currentNode.right != null) {
				treeStack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				treeStack.push(currentNode.left);
			}
			if (!treeStack.isEmpty()) {
				currentNode.right = treeStack.peek();
			}
			currentNode.left = null;
			
		}
	   
	}
	
	// TC and SC - O(N)
	public static void main(String[] s) {
		BinaryTreeDoublyLinkedList bt = new BinaryTreeDoublyLinkedList();
		TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(12);
	    root.right = new TreeNode(15);
	    root.left.left = new TreeNode(25);
	    root.left.right = new TreeNode(30);
	    root.right.left = new TreeNode(36);
		bt.flatten(root);
		
	}
}
