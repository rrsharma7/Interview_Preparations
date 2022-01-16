/**
Q1. Max Sum Path in Binary Tree

Problem Description

Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints

1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



Input Format

The first and the only argument contains a pointer to the root of T, A.



Output Format

Return an integer representing the maximum sum path.



Example Input

Input 1:

  
    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50


Example Output

Output 1:

 6
Output 2:

 40


Example Explanation

Explanation 1:

     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:

     The path with maximum sum is: 20 -> 20
*/

package DynamicProgramming6;

class MaxSumPathBinaryTree {
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

	int result = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxUtil(root);
		return result;
	}

	public int maxUtil(TreeNode root) {
		if (root == null)
			return 0;
		// left & right variable is storing maximum path sum of left & right subtree
		int left = maxUtil(root.left);
		int right = maxUtil(root.right);
		// checking for Case 1 here either we are coming from left subtree or right
		// subtree in this case that's why taking maximum of left & right
		int max1 = Math.max(Math.max(left, right) + root.val, root.val);
		// checking for case 2 here and comparing it with previous case 1 value . In
		// this case max sum is root's value + left child value+ right child value
		int max2 = Math.max(max1, left + right + root.val);
		// finally comparing the maximum sum we have got so far and updating its value
		// checking case 3 as well

		result = Math.max(max2, result);
		return max1;

	}

	public static void main(String[] args) {
		MaxSumPathBinaryTree mspbt = new MaxSumPathBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int ans = mspbt.maxPathSum(root);
		System.out.println(ans);
	}

}