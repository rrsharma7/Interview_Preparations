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

class DistanceBetweenNodesBST {
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

	  public int solve(TreeNode root, int a, int b) {
	        int temp = 0;
	        if (a > b) {
	            temp = a;
	            a = b;
	            b = temp;
	        }
	        return distanceBetween2(root, a, b);
	    }
	    public static int distanceFromRoot(TreeNode root, int x) {
	        if (root.val == x)
	            return 0;
	        else if (root.val > x)
	            return 1 + distanceFromRoot(root.left, x);
	        return 1 + distanceFromRoot(root.right, x);
	    }
	    public static int distanceBetween2(TreeNode root, int a, int b) {
	        if (root == null)
	            return 0;
	        if (root.val > a && root.val > b)
	            return distanceBetween2(root.left, a, b);
	        if (root.val < a && root.val < b)
	            return distanceBetween2(root.right, a, b);
	        if (root.val >= a && root.val <= b)
	            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
	        return 0;
	    }

	public static void main(String[] args) {
		DistanceBetweenNodesBST dbst = new DistanceBetweenNodesBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(11);
		int x = dbst.solve(root,2,11);
		System.out.println(x);
	}
  
}
