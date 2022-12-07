package leetcode;

import java.util.ArrayList;
import java.util.List;

// 559. N 叉树的最大深度
public class NT559 {
	public class Solution {
		public int maxDepth(Node root) {
			//System.out.println(root);
			//System.out.println("" + root.val + " " + root.children);
			
			if(root==null) {
				return 0;
			}
			if(root.children==null || root.children.size()==0) {
				return 1;
			}
			int sub = root.children.stream().mapToInt(n->maxDepth(n)).max().getAsInt();
			return sub+1;
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
//	    public String toString() {
//	    	return "" + val + " " + children;
//	    }
	};	
	public static void main(String[] args){
		NT559 x = new NT559();
		NT559.Solution o = x.new Solution();
		
		// 输入：root = [1,null,3,2,4,null,5,6]		输出：3
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
		assert(o.maxDepth(case1)==3);
		// 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]		输出：5
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
		assert(o.maxDepth(case2)==5);
	}
}
