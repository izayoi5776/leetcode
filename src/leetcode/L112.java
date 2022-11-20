package leetcode;

// https://leetcode.cn/problems/path-sum/
public class L112 {
	class Solution {
		public boolean hasPathSum(TreeNode root, int targetSum) {
			if(root==null) {
				return false;
			}
			if(root.left==null && root.right==null) {
				if(root.val==targetSum) {
					return true;
				}
				return false;
			}
			if(hasPathSum(root.left, targetSum - root.val)
				|| hasPathSum(root.right, targetSum - root.val)) {
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
		L112 x = new L112();
		L112.Solution o = x.new Solution();
		
		// 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22	输出：true
		TreeNode case1 = x.new TreeNode(5,
			x.new TreeNode(4,
				x.new TreeNode(11,
					x.new TreeNode(7),
					x.new TreeNode(2)
				),
				null
			),
			x.new TreeNode(8,
				x.new TreeNode(13),
				x.new TreeNode(4,
					null,
					x.new TreeNode(1)
				)
			)
		);
		assert(o.hasPathSum(case1, 22));
		
		// 输入：root = [1,2,3], targetSum = 5 输出：false
		TreeNode case2 = x.new TreeNode(1,
				x.new TreeNode(2),
				x.new TreeNode(3)
		);
		assert(!o.hasPathSum(case2, 5));

		// 输入：root = [], targetSum = 0 输出：false
		TreeNode case3 = null;
		assert(!o.hasPathSum(case3, 0));

		// 输入：root = [1,1], targetSum = 1 输出：false
		TreeNode case4 = x.new TreeNode(1,
				x.new TreeNode(1),
				null
		);
		assert(!o.hasPathSum(case4, 1));
	}
}
