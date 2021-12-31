/**
Q1. Symmetric Binary Tree

Problem Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is the root node of the binary tree.



Output Format

Return 0 / 1 ( 0 for false, 1 for true ).



Example Input

Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output

Output 1:

1
Output 2:

0


Example Explanation

Explanation 1:

 The above binary tree is symmetric. 
Explanation 2:

The above binary tree is not symmetric.
*/

package ProblemsOfTrees2;

class SymmetricBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int isSymmetric(TreeNode A) {
		if (isSym(A))
			return 1;
		return 0;
	}

	public boolean isSym(TreeNode root) {
		return find(root.left, root.right);
	}

	public boolean find(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 == null || t2 == null) {
			return false;
		} else if (t1.val != t2.val) {
			return false;
		}
		return (find(t1.left, t2.right) && find(t1.right, t2.left));
	}

	public static void main(String[] args) {
		SymmetricBinaryTree sbt = new SymmetricBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		int x = sbt.isSymmetric(root);
		System.out.println(x);
	}

}
