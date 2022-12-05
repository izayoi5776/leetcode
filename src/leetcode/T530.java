package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 530. 二叉搜索树的最小绝对差
public class T530 {
	class Solution {
		public int getMinimumDifference(TreeNode root) {
			List<Integer> ls = new ArrayList<>();
			t2l(ls, root);
			Collections.sort(ls);
			
			int d = Integer.MAX_VALUE;
			for(int i=1; i<ls.size(); i++) {
				int c = Math.abs(ls.get(i) - ls.get(i-1));
				if(c<d) {
					d = c;
				}
			}
			return d;
		}
		void t2l(List<Integer> ls, TreeNode root){
			if(root==null) {
				return;
			}
			ls.add(root.val);
			t2l(ls, root.left);
			t2l(ls, root.right);
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
		T530 x = new T530();
		T530.Solution o = x.new Solution();
		
		// 输入：root = [4,2,6,1,3]		输出：1 
		TreeNode case1 = x.new TreeNode(4,
			x.new TreeNode(2,
				x.new TreeNode(1),
				x.new TreeNode(3)
			),
			x.new TreeNode(6)
		);
		assert(o.getMinimumDifference(case1)==1);
		
		// 输入：root = [1,0,48,null,null,12,49]		输出：1
		TreeNode case2 = x.new TreeNode(1,
			x.new TreeNode(0),
			x.new TreeNode(48,
				x.new TreeNode(12),
				x.new TreeNode(9)
			)
		);
		assert(o.getMinimumDifference(case2)==1);
	}
}
