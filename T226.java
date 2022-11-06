package leetcode;

// 226. 翻转二叉树
public class T226 {
	class Solution {
		public TreeNode invertTree(TreeNode root) {
			if(root==null) {
				return null;
			}
			TreeNode l = invertTree(root.left);
			TreeNode r = invertTree(root.right);
			root.left = r;
			root.right = l;
	    	return root;
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
		T226 x = new T226();
		T226.Solution o = x.new Solution();
		
		// 输入：root = [4,2,7,1,3,6,9]		输出：[4,7,2,9,6,3,1]
		TreeNode case1 = x.new TreeNode(4,
			x.new TreeNode(2,
				x.new TreeNode(1),
				x.new TreeNode(3)
			),
			x.new TreeNode(7,
				x.new TreeNode(6),
				x.new TreeNode(9)
			)
		);
		o.invertTree(case1);
		
		// 输入：root = [2,1,3]		输出：[2,3,1]
		TreeNode case2 = x.new TreeNode(2,
				x.new TreeNode(1),
				x.new TreeNode(3)
		);
		o.invertTree(case2);
		
		// 输入：root = []		输出：[]
		TreeNode case3 = null;
		o.invertTree(case3);
	}
}
