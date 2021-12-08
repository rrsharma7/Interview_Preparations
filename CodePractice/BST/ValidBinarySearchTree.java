/**
Q2. Valid Binary Search Tree

Problem Description

Given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return 0 if false and 1 if true.



Example Input

Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.

*/

package BST;

class ValidBinarySearchTree {
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

	public int isValidBST(TreeNode A) {
        if (isValid(A, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return 1;
        return 0;
    }
    public static boolean isValid(TreeNode A, int l, int r) {
        if (A == null)
            return true;
        if (A.val > l && A.val < r) {
            boolean left = isValid(A.left, l, A.val);
            boolean right = isValid(A.right, A.val, r);
            return (left && right);
        } else
            return false;
    }
	public static void main(String[] args) {
		ValidBinarySearchTree vbst = new ValidBinarySearchTree();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		int x=vbst.isValidBST(root);
		System.out.println(x);
	}

}
