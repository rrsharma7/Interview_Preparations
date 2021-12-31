/**
Q2. Diameter of binary tree

Problem Description

Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints

0 <= N <= 105



Input Format

First and only Argument represents the root of binary tree A.



Output Format

Return an single integer denoting the diameter of the tree.



Example Input

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output

Output 1:

 3
Output 2:

 4


Example Explanation

Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
*/

package ProblemsOfTrees2;

class DiameterOfBinaryTree {
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

	int path = 0; // to calulate the max path distance
	int Distance(TreeNode root, int lh, int rh) {
		if (root == null)
			return 0;
		// Calculate the left and right height and based on that calculate the path
		// distance.
		lh = Distance(root.left, lh, rh);
		rh = Distance(root.right, lh, rh);
		path = Math.max(path, lh + rh); // find the maximum path distance. path distance = left height + right height
		// check if left > right, if so return the left path or else return right node
		// to which it belong
		return 1 + Math.max(lh, rh);
	}

	public int solve(TreeNode root) {
		// int[] path={0}; // instead of creating a global variable we can pass the path
		// as integer array
		Distance(root, 0, 0);
		return path;
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree dobt = new DiameterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		int x = dobt.solve(root);
		System.out.println(x);
	}

}
