/**
Q2. 2-Sum Binary Tree


Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.



Problem Constraints

1 <= size of tree <= 100000

1 <= B <= 109



Input Format

First argument is the head of the tree A.

Second argument is the integer B.



Output Format

Return 1 if such a pair can be found, 0 otherwise.



Example Input

Input 1:

         10
         / \
        9   20

B = 19
Input 2:

 
          10
         / \
        9   20

B = 40


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 10 + 9 = 19. Hence 1 is returned.
Explanation 2:

 No such pair exists.
*/

package ProblemsOfTrees2;

import java.util.Stack;

class TwoSumBinaryTree {
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

	public int t2Sum(TreeNode A, int B) {
        if(A==null)return 0;
        Stack<TreeNode> small=new Stack<>();
        Stack<TreeNode> big=new Stack<>();
        small.push(A);
        big.push(A);
        fillStack(small,false);fillStack(big,true);
        while(!small.isEmpty()&&!big.isEmpty()){
            int x=small.peek().val,y=big.peek().val;
            if(x>=y)return 0;
            if(x+y==B)return 1;
            TreeNode pop;
            if(x+y<B){
                pop=small.pop();
                if(pop.right!=null){
                    small.push(pop.right);
                    fillStack(small,false);
                }
            }
            if(x+y>B){
                pop=big.pop();
                if(pop.left!=null){
                    big.push(pop.left);
                    fillStack(big,true);
                }
            }
        }
        return 1;
    }
    public void fillStack(Stack<TreeNode> st,boolean flag){
        TreeNode curr=st.peek();
        if(flag){
            while(curr.right!=null){
                st.push(curr.right);curr=curr.right;
            }
        }
        else{
             while(curr.left!=null){
                st.push(curr.left);curr=curr.left;
            }
        }
    }

	public static void main(String[] args) {
		TwoSumBinaryTree sbt = new TwoSumBinaryTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		int x = sbt.t2Sum(root,19);
		System.out.println(x);
	}

}
