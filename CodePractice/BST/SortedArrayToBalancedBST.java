/**
Q1. Sorted Array To Balanced BST
Problem Description

Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints

1 <= length of array <= 100000



Input Format

First argument is an integer array A.



Output Format

Return a root node of the Binary Search Tree.



Example Input

Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output

Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation

Explanation 1:

 You need to return the root node of the Binary Tree.

*/

package BST;

class SortedArrayToBalancedBST {
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

	public TreeNode sortedArrayToBST(final int[] A) {

		TreeNode treeNode = sortToBst(A, 0, A.length - 1);
		return treeNode;
	}

	private TreeNode sortToBst(int[] A, int start, int end) {
		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(A[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = sortToBst(A, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of root
		 */
		node.right = sortToBst(A, mid + 1, end);

		return node;
	}

	public static void main(String[] args) {
		SortedArrayToBalancedBST sabt = new SortedArrayToBalancedBST();
		int a[] = { 1, 2, 3 };
		sabt.sortedArrayToBST(a);
	}

}
