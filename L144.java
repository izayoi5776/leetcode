package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/binary-tree-preorder-traversal/
public class L144 {
	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> ret = new ArrayList<>();
			if(root!=null) {
				ret.add(root.val);
				ret.addAll(preorderTraversal(root.left));
				ret.addAll(preorderTraversal(root.right));
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
		L144 x = new L144();
		L144.Solution o = x.new Solution();
		
		// 输入：root = [1,null,2,3] 输出：[1,2,3]
		TreeNode case1 = x.new TreeNode(1,
			null,
			x.new TreeNode(2,
				x.new TreeNode(3),
				null
			)
		);
		o.preorderTraversal(case1);

		// 输入：root = [] 输出：[]
		o.preorderTraversal(null);
		
		// 输入：root = [1] 输出：[1]
		TreeNode case3 = x.new TreeNode(1);
		o.preorderTraversal(case3);
		
		// 输入：root = [1,2] 输出：[1,2]
		TreeNode case4 = x.new TreeNode(1,
			x.new TreeNode(2),
			null
		);
		o.preorderTraversal(case4);

		// 输入：root = [1,null,2] 输出：[1,2]
		TreeNode case5 = x.new TreeNode(1,
				null,
				x.new TreeNode(2)
			);
		o.preorderTraversal(case5);
	}
}
