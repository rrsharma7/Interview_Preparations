/**
Q4. Flatten Binary Tree to Linked List

Problem Description

Given a binary tree A, flatten it to a linked list in-place.

The left child of all nodes should be NULL.



Problem Constraints

1 <= size of tree <= 100000



Input Format

First and only argument is the head of tree A.



Output Format

Return the linked-list after flattening.



Example Input

Input 1:

     1
    / \
   2   3
Input 2:

         1
        / \
       2   5
      / \   \
     3   4   6


Example Output

Output 1:

1
 \
  2
   \
    3
Output 2:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


Example Explanation

Explanation 1:

 Tree flattening looks like this.
Explanation 2:

 Tree flattening looks like this.
*/

package ProblemsOfTrees2;

class FlattenBinaryTreeLinkedList {
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

	TreeNode next = null;
	public TreeNode flatten(TreeNode a) {
		flattenUtil(a);
		return next;
	}

	public void flattenUtil(TreeNode a) {

		if (a == null)
			return;
		flattenUtil(a.right);
		flattenUtil(a.left);
		a.right = next;
		next = a;
		next.left = null;
	}

	public static void main(String[] args) {
		FlattenBinaryTreeLinkedList fbt = new FlattenBinaryTreeLinkedList();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		fbt.flatten(root);
		
	}

}
