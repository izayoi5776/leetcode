package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 637. 二叉树的层平均值
public class T637 {
	class Solution {
		public List<Double> averageOfLevels(TreeNode root) {
			List<Double> ret = new ArrayList<Double>();
			List<TreeNode> nextlvl = n2l(ret, new ArrayList<TreeNode>() {{add(root);}});
			while(nextlvl.size()>0) {
				nextlvl = n2l(ret, nextlvl);
			}
			return ret;
		}
		/**
		 * 计算一层的平均值，并取出下一层
		 * @param out 输出用，平均值容器
		 * @param nl 本层 Node 的 List
		 * @return 下一层 Node 的 List
		 */
		List<TreeNode> n2l(List<Double> out, List<TreeNode> nl){
			out.add(nl.stream().mapToInt(n->n.val).average().orElse(0));
			List<TreeNode> nextlvl = (List<TreeNode>) nl
					.stream()
					.flatMap(n->Arrays.stream(new TreeNode[]{n.left, n.right}))
					.filter(n->n!=null)
					.toList();
			return nextlvl;
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
		T637 x = new T637();
		T637.Solution o = x.new Solution();
		
		// 输入：root = [3,9,20,null,null,15,7]		输出：[3.00000,14.50000,11.00000] 
		TreeNode case1 = x.new TreeNode(3,
			x.new TreeNode(9),
			x.new TreeNode(20,
				x.new TreeNode(15),
				x.new TreeNode(7)
			)
		);
		assert(o.averageOfLevels(case1).equals(Arrays.asList(3.00000,14.50000,11.00000)));
		
		// 输入：root = [3,9,20,15,7]		输出：[3.00000,14.50000,11.00000]
		TreeNode case2 = x.new TreeNode(3,
			x.new TreeNode(9,
				x.new TreeNode(15),
				x.new TreeNode(7)
			),
			x.new TreeNode(20)
		);
		assert(o.averageOfLevels(case2).equals(Arrays.asList(3.00000,14.50000,11.00000)));
		
	}

	
}
