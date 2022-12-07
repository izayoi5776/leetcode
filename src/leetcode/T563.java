package leetcode;

// 563. 二叉树的坡度
public class T563 {
	class Solution {
		class TreeNodeEx extends TreeNode{
			int sum;
			int tilt;
			int sumtilt;
			TreeNodeEx(){}
			TreeNodeEx(int val) {
				this.val = val;
				sum = val;
			}
		    TreeNodeEx(int val, TreeNodeEx left, TreeNodeEx right) {
		         this.val = val;
		         this.left = left;
		         this.right = right;
		         int sl = left==null ? 0 : left.sum;
		         int sr = right==null ? 0 : right.sum;
		         this.sum = val + sl + sr; 
		         this.tilt = Math.abs(sl - sr);
		         this.sumtilt = tilt 
		        		 + (left==null ? 0 : left.sumtilt) 
		        		 + (right==null ? 0 : right.sumtilt);
		     }
		}
		public int findTilt(TreeNode root) {
			TreeNodeEx extree = buildExTree(root);
			return extree==null ? 0 : extree.sumtilt;
		}

		TreeNodeEx buildExTree(TreeNode root) {
			if(root==null) {
				return null;
			}
			if(root.left==null && root.right==null) {
				return new TreeNodeEx(root.val);
			}
			TreeNodeEx left = buildExTree(root.left);
			TreeNodeEx right = buildExTree(root.right);
			return new TreeNodeEx(root.val, left, right);
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
		T563 x = new T563();
		T563.Solution o = x.new Solution();
		
		// 输入：root = [1,2,3]		输出：1 
		TreeNode case1 = x.new TreeNode(1,
			x.new TreeNode(2),
			x.new TreeNode(3)
		);
		assert(o.findTilt(case1)==1);
		
		// 输入：root = [4,2,9,3,5,null,7]		输出：15
		TreeNode case2 = x.new TreeNode(4,
			x.new TreeNode(2,
				x.new TreeNode(3),
				x.new TreeNode(5)
			),
			x.new TreeNode(9,
				null,
				x.new TreeNode(7)
			)
		);
		assert(o.findTilt(case2)==15);
		
		// 输入：root = [21,7,14,1,1,2,2,3,3]		输出：9
		TreeNode case3 = x.new TreeNode(21,
				x.new TreeNode(7,
					x.new TreeNode(1,
						x.new TreeNode(3),
						x.new TreeNode(3)
					),
					x.new TreeNode(1)
				),
				x.new TreeNode(14,
					x.new TreeNode(2),
					x.new TreeNode(2)
				)
			);
		assert(o.findTilt(case3)==9);
		// []
		assert(o.findTilt(null)==0);

	}

	
}
