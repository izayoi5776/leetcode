package leetcode;

import java.util.ArrayList;
import java.util.List;

// 897. 递增顺序搜索树
public class T897 {
	class Solution {
		public TreeNode increasingBST(TreeNode root) {
			List<TreeNode> out = new ArrayList<>();
			mid(out, root);
			for (int i = 1; i < out.size(); i++) {
				TreeNode p = out.get(i-1);
				TreeNode c = out.get(i);
				p.left=null;
				p.right=c;
				c.left=null;
				c.right=null;
			}
			return out.get(0);
		}
		void mid(List<TreeNode> out, TreeNode root){
			if(root==null) {
				return;
			}
			mid(out, root.left);
			out.add(root);
			mid(out, root.right);
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
		T897 x = new T897();
		T897.Solution o = x.new Solution();
		
		// 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
		// 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9] 
		TreeNode case1 = x.new TreeNode(5,
			x.new TreeNode(3,
				x.new TreeNode(2,
					x.new TreeNode(1),
					null
				),
				x.new TreeNode(4)
			),
			x.new TreeNode(6,
				null,
				x.new TreeNode(8,
					x.new TreeNode(7),
					x.new TreeNode(9)
				)
			)
		);
		System.out.println(o.increasingBST(case1));
		
		// 输入：root = [5,1,7]
		// 输出：[1,null,5,null,7]
		TreeNode case2 = x.new TreeNode(5,
			x.new TreeNode(1),
			x.new TreeNode(7)
		);
		System.out.println(o.increasingBST(case2));
	}

	
}
