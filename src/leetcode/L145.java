package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-postorder-traversal/
public class L145 {
	class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> ret = new ArrayList<>();
			if(root!=null) {
				ret.addAll(postorderTraversal(root.left));
				ret.addAll(postorderTraversal(root.right));
				ret.add(root.val);
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
		L145 x = new L145();
		L145.Solution o = x.new Solution();
		
		// 输入：root = [1,null,2,3]	输出：[3,2,1]
		TreeNode case1 = x.new TreeNode(1,
			null,
			x.new TreeNode(2,
				x.new TreeNode(3),
				null
			)
		);
		o.postorderTraversal(case1);

		// 输入：root = [] 输出：[]
		o.postorderTraversal(null);
		
		// 输入：root = [1] 输出：[1]
		TreeNode case3 = x.new TreeNode(1);
		o.postorderTraversal(case3);
	
	}
}
