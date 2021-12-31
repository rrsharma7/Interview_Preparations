/**
Q1. Recover Binary Search Tree

Problem Description
Two elements of a binary search tree (BST),represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree,A



Output Format
Return the 2 elements which need to be swapped.



Example Input
Input 1:

 
         1
        / \
       2   3
Input 2:

 
         2
        / \
       3   1



Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:

Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
*/

package ProblemsOfTrees2;

import java.util.ArrayList;

class RecoverBinarySearchTree {
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

	TreeNode prev;
	TreeNode first;
	TreeNode second;

	private void inorder(TreeNode node) {
		if (node == null)
			return;

		inorder(node.left);

		if (prev != null && prev.val > node.val) {
			if (first == null) {
				first = prev;
				// System.out.println("1234");
			}
			second = node;
		}

		prev = node;
		inorder(node.right);
	}

	public ArrayList<Integer> recoverTree(TreeNode A) {
		prev = null;
		first = null;
		second = null;
		inorder(A);
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(second.val);
		ans.add(first.val);
		return ans;
	}

	public static void main(String[] args) {
		RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		ArrayList<Integer> ans=rbst.recoverTree(root);
		ans.forEach(System.out::println);

	}

}
