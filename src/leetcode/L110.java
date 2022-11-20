package leetcode;

// https://leetcode.cn/problems/balanced-binary-tree/
public class L110 {
	class Solution {
		public boolean isBalanced(TreeNode root) {
			if(root==null || root.left==null && root.right==null) {
				return true;
			}
			// 
			int l = getMaxLevel(root.left);
			int r = getMaxLevel(root.right);
			if(l>=0 && r>=0 && Math.abs(r - l)<=1) {
				return true;
			}
	    	return false;
	    }
		
		/**
		 * 取得 tree 最大深度。null为0。
		 * @param root
		 * @return 最大深度。
		 *         左右差超过1时返回 -1
		 */
		int getMaxLevel(TreeNode root) {
			if(root==null) {
				return 0;
			}
			int l = getMaxLevel(root.left);
			int r = getMaxLevel(root.right);
			int ret = 1 + Math.max(l, r);
			if(l<0 || r<0 || Math.abs(r - l)>1) {
				ret = -1;
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
		L110 x = new L110();
		L110.Solution o = x.new Solution();
		
		// 输入：root = [3,9,20,null,null,15,7] 输出：true
		TreeNode case1 = x.new TreeNode(3,
			x.new TreeNode(9),
			x.new TreeNode(20,
				x.new TreeNode(15),
				x.new TreeNode(7)
			)
		);
		assert(o.isBalanced(case1));
		
		// 输入：root = [1,2,2,3,3,null,null,4,4]	输出：false
		TreeNode case2 = x.new TreeNode(1,
				x.new TreeNode(2,
					x.new TreeNode(3,
						x.new TreeNode(4),
						x.new TreeNode(4)
					),
					x.new TreeNode(3)
				),
				x.new TreeNode(2)
		);
		assert(!o.isBalanced(case2));
		
		// [1,2,2,3,null,null,3,4,null,null,4] false
		TreeNode case3 = x.new TreeNode(1,
				x.new TreeNode(2,
					x.new TreeNode(3,
						x.new TreeNode(4),
						null
					),
					null
				),
				x.new TreeNode(2,
					null,
					x.new TreeNode(3,
						null,
						x.new TreeNode(4)
					)
				)
		);
		assert(!o.isBalanced(case3));		
	}
}
