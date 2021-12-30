/**
Q2. Left view of binary tree

Problem Description

Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format

First and only argument is a root node of the binary tree, A.



Output Format

Return an integer array denoting the left view of the Binary tree.



Example Input

Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5


Example Output

Output 1:

 [1, 2, 4, 8]
Output 2:

 [1, 2, 4, 5]


Example Explanation

Explanation 1:

 The Left view of the binary tree is returned.
*/

package TreeII;

import java.util.ArrayList;

class LeftViewOfBinaryTree {
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

	ArrayList<Integer> ans = new ArrayList<>();
	public ArrayList<Integer> solve(TreeNode root) {
		find(root, 0);
		return ans;
	}
	public void find(TreeNode root, int level) {
		if (root == null)
			return;
		if (ans.size() == level) {
			ans.add(root.val);
		}
		find(root.left, level + 1);
		find(root.right, level + 1);
		
	}

	public static void main(String[] args) {
		LeftViewOfBinaryTree rvbt = new LeftViewOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		ArrayList<Integer> ans=rvbt.solve(root);
		ans.forEach(System.out::println);

	}
	
}
