/**
Problem Description

Given A and B traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints

1 <= number of nodes <= 105



Input Format

First argument is an integer array A denoting the A traversal of the tree.

Second argument is an integer array B denoting the B traversal of the tree.



Output Format

Return the root node of the binary tree.



Example Input

Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


Example Output

Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation

Explanation 1:

 Create the binary tree and return the root node of the tree.
*/

package Tree1;

import java.util.*;

class BinaryTreeFromInorderAndPreorder {
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

	ArrayList<Integer> preorder, inorder;
	public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

		if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0)
			return null;
		if (preorder.size() != inorder.size())
			return null;

		this.preorder = preorder;
		this.inorder = inorder;

		return rec(0, preorder.size() - 1, 0);

	}

	private TreeNode rec(int start, int end, int index) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(preorder.get(index));
		int i = start;
		for (; i <= end; i++) {
			if (inorder.get(i).intValue() == root.val)
				break;
		}
		root.left = rec(start, i - 1, index + 1);
		root.right = rec(i + 1, end, index + i - start + 1);
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeFromInorderAndPreorder bt = new BinaryTreeFromInorderAndPreorder();
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		ArrayList<Integer> B = new ArrayList<Integer>();
		A.add(2);
		A.add(1);
		A.add(3);
		TreeNode tn = bt.buildTree(A, B);
	}

}
