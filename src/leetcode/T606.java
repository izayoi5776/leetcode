package leetcode;

// 606. 根据二叉树创建字符串
public class T606 {
	class Solution {
		public String tree2str(TreeNode root) {
			if(root==null) {
				return "";
			}
			if(root.left==null && root.right==null) {
				return "" + root.val;
			}
			String l = tree2str(root.left);
			String r = tree2str(root.right);
			if(root.left==null) {
				l = "()";
			} else {
				l = "(" + l + ")";
			}
			if(root.right==null) {
				r = "";
			} else {
				r = "(" + r + ")";
			}
			String ret = "" + root.val + l + r;
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
	     public String toString() {
	    	 String l = left==null ? "x" : left.toString();
	    	 String r = right==null ? "x" : right.toString();
	    	 return "[" + val + "," + l + "," + r + "]";
	     }
	 }
	
	public static void main(String[] args){
		T606 x = new T606();
		T606.Solution o = x.new Solution();
		
		// 输入：root = [1,2,3,4]		输出："1(2(4))(3)" 
		TreeNode case1 = x.new TreeNode(1,
			x.new TreeNode(2,
				x.new TreeNode(4),
				null
			),
			x.new TreeNode(3)
		);
		assert(o.tree2str(case1).equals("1(2(4))(3)"));
		
		// 输入：root = [1,2,3,null,4]		输出："1(2()(4))(3)"
		TreeNode case2 = x.new TreeNode(1,
			x.new TreeNode(2,
				null,
				x.new TreeNode(4)
			),
			x.new TreeNode(3)
		);
		assert(o.tree2str(case2).equals("1(2()(4))(3)"));
	
		assert(o.tree2str(x.new TreeNode(1)).equals("1"));
	}

	
}
