package Leetcode.BinarySearchTree;

public class DeleteNodeInBST {
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

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			root.val = minValue(root.right);
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}

	private int minValue(TreeNode root) {
		int minValue = root.val;
		while (root.left != null) {
			minValue = root.left.val;
			root = root.left;
		}
		return minValue;
	}

	public static void main(String[] s) {
		DeleteNodeInBST dn = new DeleteNodeInBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = null;
		root.right.right = new TreeNode(7);
		TreeNode treeNode = dn.deleteNode(root, 3);
		System.out.println("root=" + treeNode.val);
		System.out.println("left=" + treeNode.left.val);
		System.out.println("right=" + treeNode.right.val);
		System.out.println("left.left=" + treeNode.left.left.val);
		System.out.println("left.right=" + treeNode.left.right);
		System.out.println("right.left=" + treeNode.right.left);
		System.out.println("right.right=" + treeNode.right.right.val);

	}
}
