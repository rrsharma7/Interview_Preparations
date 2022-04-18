package LeetCode.BinaryTreee;

public class LowestCommonAncestorBinaryTree {
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

	public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
		if (root == null)
			return root;
		 if (root.val == p || root.val== q)
	            return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if (left == null && right != null) {
			return right;
		} else if (left != null && right == null) {
			return left;
		} else if (left == null && right == null) {
			return null;
		} else {
			return root;
		}
	}

	public static void main(String[] s) {
		LowestCommonAncestorBinaryTree lca = new LowestCommonAncestorBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("LCA(4, 5): " + lca.lowestCommonAncestor(root,4, 5).val);

	}
}
