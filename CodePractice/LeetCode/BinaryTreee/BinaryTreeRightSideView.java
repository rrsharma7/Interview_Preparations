package Leetcode.BinaryTreee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	 public List<Integer> rightSideView(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<>();
	        List<Integer> list = new ArrayList<>();
	        if(root==null) return list;
	        q.add(root);
	        while(!q.isEmpty()){
	            int size = q.size();
	            TreeNode cur = null;
	            while(size-->0){
	                cur = q.poll();
					if(cur.left!=null) q.add(cur.left);
	                if(cur.right!=null) q.add(cur.right);
	            }
	            list.add(cur.val);
	        }
	        return list;
	    }
	// TC and SC - O(N)
	public static void main(String[] s) {
		BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = new TreeNode(5);
		root.right.left = null;
		root.right.right = new TreeNode(4);
		List<Integer> ans = bt.rightSideView(root);
		ans.stream().forEach(System.out::println);

	}
}
