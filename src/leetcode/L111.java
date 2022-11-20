package leetcode;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
public class L111 {
	class Solution {
		public int minDepth(TreeNode root) {
			if(root==null) {
				return 0;
			}
			if(root.left==null && root.right==null) {
				return 1;
			}
			int l = minDepth(root.left);
			int r = minDepth(root.right);
			if(l==0) {
				return r+1;
			}else if(r==0) {
				return l+1;
			}
			return Math.min(l, r) + 1;
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
		L111 x = new L111();
		L111.Solution o = x.new Solution();
		
		// 输入：root = [3,9,20,null,null,15,7] 输出：2
		TreeNode case1 = x.new TreeNode(3,
			x.new TreeNode(9),
			x.new TreeNode(20,
				x.new TreeNode(15),
				x.new TreeNode(7)
			)
		);
		assert(o.minDepth(case1)==2);
		
		// 输入：root = [2,null,3,null,4,null,5,null,6] 输出：5
		TreeNode case2 = x.new TreeNode(2,
				null,
				x.new TreeNode(3,
					null,
					x.new TreeNode(4,
						null,
						x.new TreeNode(5,
							null,
							x.new TreeNode(6)
						)
					)
				)
		);
		assert(o.minDepth(case2)==5);
	}
}
