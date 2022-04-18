package LeetCode.BinaryTreee;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {

	private void preOrderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(""+root.val);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
			
		}
		
	}

	private void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.val);
			inOrderTraversal(root.right);
		}

	}

	private void postOrderTraversal(TreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.val);
		}

	}

	public static void main(String[] s) {
		BinaryTree bt = new BinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		bt.preOrderTraversal(root);
		bt.inOrderTraversal(root);
		bt.postOrderTraversal(root);
	}
}
