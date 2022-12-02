package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 501. 二叉搜索树中的众数
public class T501 {
	class Solution {
		public int[] findMode(TreeNode root) {
			Map<Integer, Integer> m = new HashMap<>();
			t2m(m, root);
			
			int max = 0;
			List<Integer> ret = new ArrayList<>();
			for(Map.Entry<Integer, Integer> t:m.entrySet()) {
				int k = t.getKey();
				int v = t.getValue(); 
				if(v>max) {
					max=v;
					ret.clear();
					ret.add(k);
				}else if(v==max) {
					ret.add(k);
				}
			}
			return ret.stream().mapToInt(i->i).toArray();
	    }
		void t2m(Map<Integer, Integer> m, TreeNode root){
			if(m==null || root==null) {
				return;
			}
			int k = root.val;
			int v = m.getOrDefault(k, 0);
			m.put(k, v+1);
			
			t2m(m, root.left);
			t2m(m, root.right);
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
		T501 x = new T501();
		T501.Solution o = x.new Solution();
		
		// 输入：root = [1,null,2,2]		输出：[2] 
		TreeNode case1 = x.new TreeNode(1,
			null,
			x.new TreeNode(2,
				x.new TreeNode(2),
				null
			)
		);
		assert(Arrays.equals(o.findMode(case1), new int[] {2}));
		
		// 输入：root = [0]		输出：[0]
		TreeNode case2 = x.new TreeNode(0);
		assert(Arrays.equals(o.findMode(case2), new int[] {0}));
		
		// [1,null,2] [2,1]
		TreeNode case3 = x.new TreeNode(1,
				null,
				x.new TreeNode(2)
			);
			assert(Arrays.equals(o.findMode(case3), new int[] {1,2}));
	}
}
