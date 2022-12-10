package leetcode;

// 617. 合并二叉树
public class T617 {
	class Solution {
		public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
			if(root1==null && root2==null) {
				return null;
			}
			if(root1==null) {
				return root2;
			}
			if(root2==null) {
				return root1;
			}
			TreeNode l = mergeTrees(root1.left, root2.left);
			TreeNode r = mergeTrees(root1.right, root2.right);
			TreeNode ret = new TreeNode(root1.val + root2.val, l, r);
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
		T617 x = new T617();
		T617.Solution o = x.new Solution();
		
		// 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]		输出：[3,4,5,5,4,null,7] 
		TreeNode case1 = x.new TreeNode(1,
			x.new TreeNode(3,
				x.new TreeNode(5),
				null
			),
			x.new TreeNode(2)
		);
		TreeNode case12 = x.new TreeNode(2,
				x.new TreeNode(1,
					null,
					x.new TreeNode(4)
				),
				x.new TreeNode(3,
					null,
					x.new TreeNode(7)
				)
			);
		System.out.println(o.mergeTrees(case1, case12));
		
		// 输入：root1 = [1], root2 = [1,2]		输出：[2,2]
		TreeNode case2 = x.new TreeNode(1,
			x.new TreeNode(2),
			null
		);
		System.out.println(o.mergeTrees(x.new TreeNode(1), case2));
	
		
	}

	
}
