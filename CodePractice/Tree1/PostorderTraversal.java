/**
Problem Description

Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return an integer array denoting the Postorder traversal of the given binary tree.



Example Input

Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation

Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].
*/

package Tree1;

import java.util.*;

class PostorderTraversal {
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

	ArrayList<Integer> ans = new ArrayList<Integer>();
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		if (A != null) {
			postorderTraversal(A.left);
			postorderTraversal(A.right);
			ans.add(A.val);
		}
		return ans;
	}

	public static void main(String[] args) {
		PostorderTraversal lo = new PostorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(6);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		lo.postorderTraversal(root);
	}

}
