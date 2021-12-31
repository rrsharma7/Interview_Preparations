/**
Q3. Next Pointer Binary Tree
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return the head of the binary tree after the changes are made.



Example Input

Input 1:

 
     1
    /  \
   2    3
Input 2:

 
        1
       /  \
      2    5
     / \  / \
    3  4  6  7


Example Output

Output 1:

 
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:

 
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL


Example Explanation

Explanation 1:

Next pointers are set as given in the output.
Explanation 2:

Next pointers are set as given in the output.
*/

package ProblemsOfTrees2;

class NextPointerBinaryTree {
	static public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root.left != null) {
			if (root.next != null)
				root.right.next = root.next.left;
			else
				root.right.next = null;
			root.left.next = root.right;
			connect(root.left);
			connect(root.right);
		}
	}

	public static void main(String[] args) {
		NextPointerBinaryTree dobt = new NextPointerBinaryTree();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		dobt.connect(root);

	}

}
