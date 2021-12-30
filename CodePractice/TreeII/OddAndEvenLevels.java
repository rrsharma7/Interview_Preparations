/**
Q3. Odd and Even Levels

Problem Description

Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format

First and only argument is a root node of the binary tree, A



Output Format

Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.



Example Input

Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8 
Input 2:

        1
       / \
      2   10
       \
        4


Example Output

Output 1:

 10
Output 2:

 -7


Example Explanation

Explanation 1:

 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
Explanation 2:

 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12
*/

package TreeII;

import java.util.LinkedList;
import java.util.Queue;

class OddAndEvenLevels {
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

	public int solve(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (A == null)
			return 0;
		int oddsum = 0;
		int evensum = 0;
		int level = 0;
		q.add(A);
		while (q.size() > 0) {
			int n = q.size();
			level ^= 1;
			while (n-- > 0) {
				TreeNode temp = q.peek();
				q.remove();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);

				if (level != 0)
					oddsum += temp.val;
				else
					evensum += temp.val;
			}
		}
		return (oddsum - evensum);

	}

	public static void main(String[] args) {
		OddAndEvenLevels oael = new OddAndEvenLevels();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.left.right = new TreeNode(4);
		int ans = oael.solve(root);
		System.out.println(ans);

	}

}
