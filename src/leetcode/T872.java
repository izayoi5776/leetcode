package leetcode;

import java.util.ArrayList;
import java.util.List;

// 872. 叶子相似的树
public class T872 {
	class Solution {
		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			List<Integer> lst1 = new ArrayList<>();
			List<Integer> lst2 = new ArrayList<>();
			leaf(lst1, root1);
			leaf(lst2, root2);
			return lst1.equals(lst2);
		}
		void leaf(List<Integer> lst, TreeNode root){
			if(root==null) {
				return;
			}
			if(root.left==null && root.right==null) {
				lst.add(root.val);
			}
			leaf(lst, root.left);
			leaf(lst, root.right);
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
		T872 x = new T872();
		T872.Solution o = x.new Solution();
		
		// 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], 
		// root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
		// 输出：true 
		TreeNode case11 = x.new TreeNode(3,
			x.new TreeNode(5,
				x.new TreeNode(6),
				x.new TreeNode(2,
					x.new TreeNode(7),
					x.new TreeNode(4)
				)
			),
			x.new TreeNode(1,
				x.new TreeNode(9),
				x.new TreeNode(8)
			)
		);
		TreeNode case12 = x.new TreeNode(3,
			x.new TreeNode(5,
				x.new TreeNode(6),
				x.new TreeNode(7)
			),
			x.new TreeNode(1,
				x.new TreeNode(4),
				x.new TreeNode(2,
					x.new TreeNode(9),
					x.new TreeNode(8)
				)
			)
		);
		assert(o.leafSimilar(case11, case12));
		
		// 输入：root1 = [1,2,3], root2 = [1,3,2]		输出：false
		TreeNode case21 = x.new TreeNode(1,
			x.new TreeNode(2),
			x.new TreeNode(3)
		);
		TreeNode case22 = x.new TreeNode(1,
				x.new TreeNode(3),
				x.new TreeNode(2)
			);
		assert(!o.leafSimilar(case21, case22));
	}

	
}
