package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-inorder-traversal/
public class L94 {
	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer>ret = new ArrayList<>();
			if(root==null) {
				return ret;
			}
			
			int v = root.val;
			List<Integer> l = inorderTraversal(root.left);
			List<Integer> r = inorderTraversal(root.right);

			if(l!=null) {
				ret.addAll(l);	
			}
			ret.add(v);
			if(r!=null) {
				ret.addAll(r);	
			}

	    	return ret;
	    }
	}
	
	/**
	 * Definition for a binary tree node.
	 */
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
	
	public static void main(String[] args){
		L94 x = new L94();
		L94.Solution o = x.new Solution();
		
		// [1,null,2,3]
		TreeNode case1 = x.new TreeNode(1, null,
			x.new TreeNode(2,
				x.new TreeNode(3),
				null
			)
		);
		o.inorderTraversal(case1);

		TreeNode case2 = null;
		o.inorderTraversal(case2);
		
		TreeNode case3 = x.new TreeNode(1);
		o.inorderTraversal(case3);
	}
}
