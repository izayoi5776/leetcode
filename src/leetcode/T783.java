package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 783. 二叉搜索树节点最小距离
public class T783 {
	class Solution {
		List<Integer> ls;
		public int minDiffInBST(TreeNode root) {
			ls = new ArrayList<>();
			tree2List(root);
			Collections.sort(ls);
			int ret = Integer.MAX_VALUE;
			for (int i = 1; i < ls.size(); i++) {
				int c = Math.abs(ls.get(i) - ls.get(i-1));
				if(c<ret) {
					ret = c;
				}
			}
			return ret;
		}
		void tree2List(TreeNode root){
			if(root==null) {
				return;
			}
			ls.add(root.val);
			tree2List(root.left);
			tree2List(root.right);
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
		T783 x = new T783();
		T783.Solution o = x.new Solution();
		
		// 输入：root = [4,2,6,1,3]		输出：1 
		TreeNode case1 = x.new TreeNode(4,
			x.new TreeNode(2,
				x.new TreeNode(1),
				x.new TreeNode(3)
			),
			x.new TreeNode(6)
		);
		assert(o.minDiffInBST(case1)==1);
		
		// 输入：root = [1,0,48,null,null,12,49]		输出：1
		TreeNode case2 = x.new TreeNode(1,
			x.new TreeNode(0),
			x.new TreeNode(48,
				x.new TreeNode(12),
				x.new TreeNode(49)
			)
		);
		assert(o.minDiffInBST(case2)==1);
		

	}

	
}
