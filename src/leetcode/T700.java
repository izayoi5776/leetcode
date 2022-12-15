package leetcode;

// 700. 二叉搜索树中的搜索
public class T700 {
	class Solution {
		public TreeNode searchBST(TreeNode root, int val) {
			if(root==null) {
				return null;
			}
			if(root.val==val) {
				return root;
			}
			if(root.val<val) {
				return searchBST(root.right, val);
			}
			return searchBST(root.left, val);
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
		T700 x = new T700();
		T700.Solution o = x.new Solution();
		
		// 输入：root = [4,2,7,1,3], val = 2		输出：[2,1,3] 
		TreeNode case1 = x.new TreeNode(4,
			x.new TreeNode(2,
				x.new TreeNode(1),
				x.new TreeNode(3)
			),
			x.new TreeNode(7)
		);
		System.out.println(o.searchBST(case1,2));
		
		// 输入：root = [4,2,7,1,3], val = 5		输出：[]
		TreeNode case2 = x.new TreeNode(2,
			x.new TreeNode(2),
			x.new TreeNode(2)
		);
		System.out.println(o.searchBST(case2,5));
		

	}

	
}
