/**
Q3. Check for BST with One Child

Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.



Problem Constraints

1 <= number of nodes <= 100000



Input Format

First and only argument is an integer array denoting the preorder traversal of binary tree.



Output Format

Return a string "YES" if true else "NO".



Example Input

Input 1:

 A : [4, 10, 5, 8]
Input 2:

 A : [1, 5, 6, 4]


Example Output

Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation

Explanation 1:

 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:

 There is no possible BST which have the above preorder traversal.

*/

package BST;

import java.util.ArrayList;

class CheckBSTOneChild {
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

	 public String solve(int[] A) {
	        int n = A.length;

	        if (n <= 2) {
	            return "YES";
	        }
	        int mn = Math.min(A[n - 1], A[n - 2]);
	        int mx = Math.max(A[n - 1], A[n - 2]);

	        for (int i = n - 3; i >= 0; i--) {
	            if (A[i] > mn && A[i] < mx) {
	                return "NO";
	            }
	            mn = Math.min(mn, A[i]);
	            mx = Math.max(mx, A[i]);
	        }
	        return "YES";
	    }
	public static void main(String[] args) {
		CheckBSTOneChild cboc = new CheckBSTOneChild();
		int A[]= {4, 10, 5, 8};
		String res=cboc.solve(A);
		System.out.println(res);
	}

}
