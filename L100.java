package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/same-tree/
public class L100 {
	class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if(p==null && q==null) {
				return true;
			}else if(p==null && q!=null || p!=null && q==null) {
				return false;
			}
			
			if(p.val == q.val
				&& isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right)
			) {
				return true;
			}
	    	return false;
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
		L100 x = new L100();
		L100.Solution o = x.new Solution();
		
		// p = [1,2,3], q = [1,2,3]	输出：true
		TreeNode p = x.new TreeNode(1,
			x.new TreeNode(2),
			x.new TreeNode(3)
		);
		TreeNode q = x.new TreeNode(1,
				x.new TreeNode(2),
				x.new TreeNode(3)
			);
		assert(o.isSameTree(p, q));
		
		// 输入：p = [1,2], q = [1,null,2] 输出：false
		p = x.new TreeNode(1,
				x.new TreeNode(2),
				null
		);
		q = x.new TreeNode(1,
				null,
				x.new TreeNode(2)
		);
		assert(!o.isSameTree(p, q));
		
		// 输入：p = [1,2,1], q = [1,1,2] 输出：false
		p = x.new TreeNode(1,
				x.new TreeNode(2),
				x.new TreeNode(1)
			);
		q = x.new TreeNode(1,
					x.new TreeNode(1),
					x.new TreeNode(2)
				);
			assert(!o.isSameTree(p, q));
	}
}
