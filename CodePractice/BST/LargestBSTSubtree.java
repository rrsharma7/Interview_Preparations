/**
Q3. Largest BST Subtree

Problem Description

Given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of whole tree.

NOTE:

Largest subtree means subtree with most number of nodes.


Problem Constraints

1 <= N <= 105



Input Format

First and only argument is an pointer to root of the binary tree A.



Output Format

Return an single integer denoting the size of the largest subtree which is also a BST.



Example Input

Input 1:

     10
    / \
   5  15
  / \   \ 
 1   8   7
Input 2:

     5
    / \
   3   8
  / \ / \
 1  4 7  9


Example Output

Output 1:

 3
Output 2:

 7


Example Explanation

Explanation 1:

 Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:

 Given binary tree itself is BST.

*/

package BST;

class LargestBSTSubtree {
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

	// Recursive function to calculate the size of a given binary tree
    public static int size(TreeNode root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recursively calculate the size of the left and right subtrees and
        // return the sum of their sizes + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }
 
    // Recursive function to determine if a given binary tree is a BST or not
    // by keeping a valid range (starting from [-INFINITY, INFINITY]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(TreeNode node, int min, int max)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if the node's value falls outside the valid range
        if (node.val < min || node.val > max) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.val) &&
            isBST(node.right, node.val, max);
    }
 
    // Recursive function to find the size of the largest BST in a given binary tree
    public  int solve(TreeNode A)
    {
        if (isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(A);
        }
 
        return Math.max(solve(A.left), solve(A.right));
    }
 
	public static void main(String[] args) {
		LargestBSTSubtree vbst = new LargestBSTSubtree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);
		int x=vbst.solve(root);
		System.out.println(x);
	}

}
