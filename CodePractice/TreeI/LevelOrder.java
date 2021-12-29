/**
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



Problem Constraints

1 <= number of nodes <= 105



Input Format

First and only argument is root node of the binary tree, A.



Output Format

Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input

Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation

Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
*/

package TreeI;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

class LevelOrder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (A == null)
			return result;

		int currentLevelNum = 1;
		int nextLevelNum = 0;
		queue.offer(A);
		ArrayList<Integer> levelList = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			currentLevelNum--;
			levelList.add(node.val);

			if (node.left != null) {
				queue.offer(node.left);
				nextLevelNum++;
			}

			if (node.right != null) {
				queue.offer(node.right);
				nextLevelNum++;
			}

			if (currentLevelNum == 0) {
				currentLevelNum = nextLevelNum;
				nextLevelNum = 0;
				result.add(new ArrayList<Integer>(levelList));
				levelList.clear();
			}

		}

		return result;
	}

	public static void main(String[] args) {
		LevelOrder lo = new LevelOrder();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		lo.levelOrder(root);
	}

}
