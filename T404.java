package leetcode;

// 404. 左叶子之和
public class T404 {
	class Solution {
		public int sumOfLeftLeaves(TreeNode root) {
			if(root==null) {
				return 0;
			}
			int l = 0; 
			if(root.left!=null && root.left.left==null && root.left.right==null) {
				l = root.left.val;
			}else {
				l = sumOfLeftLeaves(root.left); 
			}
			int r = 0; 
			if(root.right!=null) {
				r = sumOfLeftLeaves(root.right);
			}
			
			return l+r;
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
		T404 x = new T404();
		T404.Solution o = x.new Solution();
		
		// 输入: root = [3,9,20,null,null,15,7]		输出: 24 
		TreeNode case1 = x.new TreeNode(3,
			x.new TreeNode(9),
			x.new TreeNode(20,
				x.new TreeNode(15),
				x.new TreeNode(7)
			)
		);
		assert(o.sumOfLeftLeaves(case1)==24);
		
		// 输入: root = [1]		输出: 0
		TreeNode case2 = x.new TreeNode(1);
		assert(o.sumOfLeftLeaves(case2)==0);
		

	}
}
