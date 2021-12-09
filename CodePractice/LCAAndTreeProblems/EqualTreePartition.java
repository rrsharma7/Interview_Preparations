/**
Q3. Equal Tree Partition

Problem Description

Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints

1 <= size of tree <= 100000

-109 <= value of node <= 109



Input Format

First and only argument is head of tree A.



Output Format

Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input

Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.
*/

package LCAAndTreeProblems;

import java.util.HashMap;
import java.util.Map;

class EqualTreePartition {
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
	public int solve(TreeNode a) {
        Map < Integer, Integer > map = new HashMap < > ();
        int tot = populate(a, map);
        // since total sum can also be zero
        if (tot == 0) 
            return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
        return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
    }
    public int populate(TreeNode a, Map < Integer, Integer > map) {
        if (a == null) 
            return 0;
        int sum = a.val + populate(a.left, map) + populate(a.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

	public static void main(String[] args) {
		EqualTreePartition etp = new EqualTreePartition();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);

		int x = etp.solve(root);
		System.out.println(x);
	}
}

