/**
Q2. TOP VIEW

Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

Top view of a Binary Tree is a set of nodes visible when the tree is visited from top.

Return the nodes in any order.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return an array, representing the top view of the binary tree.



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

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation

Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
*/

package TreeII;

import java.util.ArrayList;

class TopView {
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

	 public ArrayList<Integer> solve(TreeNode A) {
	        TreeNode head = A;
	        ArrayList<Integer> ans = new ArrayList<>();
	        ans.add(head.val);
	        TreeNode current = head.left;

	        while(null != current) {
	            Integer val = current.val;
	            ans.add(val);
	            current = current.left;
	        }

	        current = head.right;
	         while(null != current) {
	            Integer val = current.val;
	            ans.add(val);
	            current = current.right;
	        }
	        return ans;
	    }

	public static void main(String[] args) {
		TopView rvbt = new TopView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		ArrayList<Integer> ans=rvbt.solve(root);
		ans.forEach(System.out::println);

	}

}
