package Leetcode.BinarySearchTree;

public class InsertIntoBinarySearchTree {
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

	public TreeNode insertIntoBST(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		if (root.val == data)
			return root;
		if (root.val > data)
			root.left = insertIntoBST(root.left, data);
		else
			root.right = insertIntoBST(root.right, data);
		return root;

	}

	public static void main(String[] s) {
		InsertIntoBinarySearchTree iibt = new InsertIntoBinarySearchTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		TreeNode treeNode=iibt.insertIntoBST(root, 5);
		System.out.println("root="+treeNode.val);
		System.out.println("left="+treeNode.left.val);
		System.out.println("right="+treeNode.right.val);
		System.out.println("left.left="+treeNode.left.left.val);
		System.out.println("left.right="+treeNode.left.right.val);
		System.out.println("right.left="+treeNode.right.left.val);

	}
}
