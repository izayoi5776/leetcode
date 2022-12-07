package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 589. N 叉树的前序遍历
public class NT589 {
	public class Solution {
		public List<Integer> preorder(Node root) {
			List<Integer> ret = new ArrayList<Integer>();
			po(ret, root);
			return ret;
		}
		void po(List<Integer> ls, Node root) {
			if(ls==null || root==null) {
				return;
			}
			ls.add(root.val);
			if(root.children==null) {
				return;
			}
			for(int i=0; i<root.children.size(); i++) {
				po(ls, root.children.get(i));
			}
		}
	}
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	    public String toString() {
	    	return "" + val + " " + children;
	    }
	};	
	public static void main(String[] args){
		NT589 x = new NT589();
		NT589.Solution o = x.new Solution();
		
		// 输入：root = [1,null,3,2,4,null,5,6]		输出：[1,3,5,6,2,4]
		Node case1 = x.new Node(1,
			new ArrayList<Node>(){{
				add(x.new Node(3,
					new ArrayList<Node>(){{
						add(x.new Node(5));
						add(x.new Node(6));
					}}
				));
				add(x.new Node(2));
				add(x.new Node(4));
			}}
		);
		assert(o.preorder(case1).equals(Arrays.asList(new Integer[] {1,3,5,6,2,4})));
		//System.out.println(o.preorder(case1));
		//System.out.println(Arrays.asList(new Integer[] {1,3,5,6,2,4}));
		
		
		// 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
		// 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
		Node case2 = x.new Node(1,
			new ArrayList<Node>(){{
				add(x.new Node(2));
				add(x.new Node(3,
					new ArrayList<Node>(){{
						add(x.new Node(6));
						add(x.new Node(7,
								new ArrayList<Node>(){{
								add(x.new Node(11,
									new ArrayList<Node>(){{
										add(x.new Node(14));
									}}
								));
							}}
						));
					}}
				));
				add(x.new Node(4,
					new ArrayList<Node>(){{
						add(x.new Node(8,
							new ArrayList<Node>(){{
								add(x.new Node(12));
							}}
						));
					}}
				));
				add(x.new Node(5,
					new ArrayList<Node>(){{
						add(x.new Node(9,
							new ArrayList<Node>(){{
								add(x.new Node(13));
							}}
						));
						add(x.new Node(10));
					}}
				));
			}}
		);
		assert(o.preorder(case2).equals(Arrays.asList(new Integer[] {1,2,3,6,7,11,14,4,8,12,5,9,13,10})));
	}
}
