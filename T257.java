package leetcode;

import java.util.ArrayList;
import java.util.List;

// 257. 二叉树的所有路径
public class T257 {
	class Solution {
		public List<String> binaryTreePaths(TreeNode root) {
			List<String> ret = new ArrayList<>();
			if(root==null) {
				return null;
			}
			List<String> l = binaryTreePaths(root.left);
			List<String> r = binaryTreePaths(root.right);
			
			if(l!=null) {
				l.forEach(s -> ret.add("" + root.val + "->" + s));
			}
			if(r!=null) {
				r.forEach(s -> ret.add("" + root.val + "->" + s));
			}
			if(ret.isEmpty()) {
				ret.add("" + root.val);
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
	     public String toString() {
	    	 String l = left==null ? "x" : left.toString();
	    	 String r = right==null ? "x" : right.toString();
	    	 return "[" + val + "," + l + "," + r + "]";
	     }
	 }
	
	public static void main(String[] args){
		T257 x = new T257();
		T257.Solution o = x.new Solution();
		
		// 输入：root = [1,2,3,null,5]		输出：["1->2->5","1->3"]
		TreeNode case1 = x.new TreeNode(1,
			x.new TreeNode(2,
				null,
				x.new TreeNode(5)
			),
			x.new TreeNode(3)
		);
		o.binaryTreePaths(case1);
		
		// 输入：root = [1]		输出：["1"]
		TreeNode case2 = x.new TreeNode(1);
		o.binaryTreePaths(case2);
		

	}
}
