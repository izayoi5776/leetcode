package leetcode;

// 671. 二叉树中第二小的节点
public class T671 {
	class Solution {
		public int findSecondMinimumValue(TreeNode root) {
			if(root==null) {
				return -1;
			}
			// 最小节点一定是 root 
			return second(root, root.val);
		}
		int second(TreeNode root, int min) {
			if(root==null) {
				return -1;
			}
			if(root.val!=min) {
				return root.val;
			}
			int l = second(root.left, min);
			int r = second(root.right, min);
			if(l==-1) {
				return r;
			}
			if(r==-1) {
				return l;
			}
			return Math.min(l, r);
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
		T671 x = new T671();
		T671.Solution o = x.new Solution();
		
		// 输入：root = [2,2,5,null,null,5,7]		输出：5 
		TreeNode case1 = x.new TreeNode(2,
			x.new TreeNode(2),
			x.new TreeNode(5,
				x.new TreeNode(7),
				null
			)
		);
		assert(o.findSecondMinimumValue(case1)==5);
		
		// 输入：root = [2,2,2]		输出：-1
		TreeNode case2 = x.new TreeNode(2,
			x.new TreeNode(2),
			x.new TreeNode(2)
		);
		assert(o.findSecondMinimumValue(case2)==-1);
		

	}

	
}
