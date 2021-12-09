/**
Q2. Path Sum

Problem Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints

1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.



Output Format

Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.



Example Input

Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22
Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:

 There is no path which has sum -1.
*/

package LCAAndTreeProblems;

class PathSum {
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

	private boolean has(TreeNode node, int sumc) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null && sumc == node.val)
			return true;
		return has(node.left, sumc - node.val) || has(node.right, sumc - node.val);
	}

	public int hasPathSum(TreeNode a, int b) {
		boolean ans = has(a, b);
		if (ans == true)
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		int x = ps.hasPathSum(root,22);
		System.out.println(x);

	}
}