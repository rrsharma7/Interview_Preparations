/**
Q1. Identical Binary Trees

Problem Description

Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is a root node of first tree, A.

Second argument is a root node of second tree, B.



Output Format

Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input

Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Value of left child of the tree is different.
*/

package TreeII;

class IdenticalBinaryTrees {
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

	public int isSameTree(TreeNode A, TreeNode B) {
		if (isSamTree(A, B))
			return 1;
		return 0;
	}

	public boolean isSamTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return (p == q);
		}
		return (p.val == q.val) && isSamTree(p.left, q.left) && isSamTree(p.right, q.right);
	}

	public static void main(String[] args) {
		IdenticalBinaryTrees ibt = new IdenticalBinaryTrees();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		int ans = ibt.isSameTree(root1, root2);
		System.out.println(ans);

	}

}
