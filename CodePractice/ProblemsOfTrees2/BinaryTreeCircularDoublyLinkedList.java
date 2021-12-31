/**
Q3. Distance between Nodes of BST

Problem Description

Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.



Problem Constraints

1 <= Number of nodes in binary tree <= 1000000

0 <= node values <= 109



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.

Third argument is an integer C.



Output Format

Return an integer denoting the distance between two nodes with given two keys B and C



Example Input

Input 1:

    
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:

    
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:

 Path between 2 and 6 is: 2 -> 6. Distance will be 1
*/

package ProblemsOfTrees2;

class BinaryTreeCircularDoublyLinkedList {
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

	public TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
		// If either of the list is empty, then
		// return the other list
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;

		// Store the last Node of left List
		TreeNode leftLast = leftList.left;

		// Store the last Node of right List
		TreeNode rightLast = rightList.left;

		// Connect the last node of Left List
		// with the first Node of the right List
		leftLast.right = rightList;
		rightList.left = leftLast;

		// left of first node refers to
		// the last node in the list
		leftList.left = rightLast;

		// Right of last node refers to the first
		// node of the List
		rightLast.right = leftList;

		// Return the Head of the List
		return leftList;
	}

	// Method converts a tree to a circular
	// Link List and then returns the head
	// of the Link List
	public TreeNode solve(TreeNode root) {
		if (root == null)
			return null;

		// Recursively convert left and right subtrees
		TreeNode left = solve(root.left);
		TreeNode right = solve(root.right);

		// Make a circular linked list of single node
		// (or root). To do so, make the right and
		// left pointers of this node point to itself
		root.left = root.right = root;

		// Step 1 (concatenate the left list with the list
		// with single node, i.e., current node)
		// Step 2 (concatenate the returned list with the
		// right List)
		return concatenate(concatenate(left, root), right);
	}

}
