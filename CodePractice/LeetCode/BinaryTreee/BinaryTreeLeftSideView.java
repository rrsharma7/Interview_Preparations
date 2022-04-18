package LeetCode.BinaryTreee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLeftSideView {

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

	  public List<Integer> leftSideView(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<>();
	        List<Integer> list = new ArrayList<>();
	        if(root==null) return list;
	        q.add(root);
	        while(!q.isEmpty()){
	            int size = q.size();
	            TreeNode cur = null;
	            while(size-->0){
	                cur = q.poll();
	                if(cur.right!=null) q.add(cur.right);
	                if(cur.left!=null) q.add(cur.left);
	            }
	            list.add(cur.val);
	        }
	        return list;
	    }

	public static void main(String[] s) {
		BinaryTreeLeftSideView bt = new BinaryTreeLeftSideView();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = new TreeNode(5);
		root.right.left = null;
		root.right.right = new TreeNode(4);
		List<Integer> ans=bt.leftSideView(root);
		ans.stream().forEach(System.out::println);
		

	}
	// TC and SC - O(N)
}
