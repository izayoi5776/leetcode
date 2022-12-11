package leetcode;

// 653. 两数之和 IV - 输入二叉搜索树
public class T653 {
	class Solution {
		public boolean findTarget(TreeNode root, int k) {
			boolean ret = walkThrough(root, root, k);
			return ret;
		}
		/**
		 * 前序遍历二叉树 root，同时在检索二叉搜索树查找 k-root.val 是否存在
		 * @param root
		 * @param base
		 * @param k
		 * @return
		 */
		boolean walkThrough(TreeNode root, TreeNode base, int k){
			if(root==null) {
				return false;
			}
			// 等于 root.val 2倍的 k 值肯定无法实现
			if(k-root.val!=root.val) {
				if(find(base, k-root.val)) {
					return true;
				}
			}
			if(walkThrough(root.left, base, k)) {
				return true;
			}
			if(walkThrough(root.right, base, k)) {
				return true;
			}
			return false;
		}
		/**
		 * 在二叉搜索树中寻找指定数字 k
		 * @param root
		 * @param k
		 * @return
		 */
		boolean find(TreeNode root, int k){
			if(root==null) {
				return false;
			}
			if(k==root.val) {
				return true;
			}
			if(k>root.val) {
				return find(root.right, k);
			} else {
				return find(root.left, k);
			}
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
		T653 x = new T653();
		T653.Solution o = x.new Solution();
		
		// 输入: root = [5,3,6,2,4,null,7], k = 9		输出: true 
		TreeNode case1 = x.new TreeNode(5,
			x.new TreeNode(3,
				x.new TreeNode(2),
				x.new TreeNode(4)
			),
			x.new TreeNode(6,
				null,
				x.new TreeNode(7)
			)
		);
		assert(o.findTarget(case1,9));
		
		// 输入: root = [5,3,6,2,4,null,7], k = 28		输出: false
		TreeNode case2 = x.new TreeNode(5,
			x.new TreeNode(3,
				x.new TreeNode(2),
				x.new TreeNode(4)
			),
			x.new TreeNode(6,
				null,
				x.new TreeNode(7)
			)
		);
		assert(!o.findTarget(case2,28));
		
		assert(!o.findTarget(x.new TreeNode(1),2));
		
		// 417/423
		assert(o.findTarget(x.new TreeNode(2,
			x.new TreeNode(1),
			x.new TreeNode(3)
		),4));

	}

	
}
