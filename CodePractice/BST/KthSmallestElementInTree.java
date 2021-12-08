/**
Q4. Kth Smallest Element In Tree
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return an integer, representing the Bth element.



Example Input

Input 1:

 
            2
          /   \
         1    3
B = 2
Input 2:

 
            3
           /
          2
         /
        1
B = 1



Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1.


*/

package BST;

class KthSmallestElementInTree {
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

	int k;
    int result = 0;
     public int kthsmallest(TreeNode A, int B) {
    	 this.k = B;
         inorder(A);
         return result;
     }
     void inorder(TreeNode root) {
         
         if(root == null)
             return ;
         
         inorder(root.left);
         k--;
         if(k == 0) {
             result = root.val;
             return;
         }
         inorder(root.right);
     }

	public static void main(String[] args) {
		KthSmallestElementInTree kthSmallestElement = new KthSmallestElementInTree();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		int x = kthSmallestElement.kthsmallest(root,2);
		System.out.println(x);
	}

}
