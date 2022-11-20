package leetcode;

// 203. 移除链表元素
public class L203 {
	class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode n = head;	// 处理中
			ListNode h = head;	// 头
			ListNode p = null;	// 前一个
			while(n!=null) {
				 if(n.val == val) {
					 if(p==null) {
						 // head
						 h = n.next;
					 } else {
						p.next = n.next;
					 }
				 }else {
					 p = n;
				 }
				 n = n.next;
			}
	    	return h;
	    }
	}
	
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	     int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
	public static void main(String[] args){
		L203 x = new L203();
		L203.Solution o = x.new Solution();
		// 输入：head = [1,2,6,3,4,5,6], val = 6		输出：[1,2,3,4,5]
		ListNode case1 = x.new ListNode(1,
				x.new ListNode(2,
					x.new ListNode(6,
						x.new ListNode(3,
							x.new ListNode(4,
								x.new ListNode(5,
									x.new ListNode(6)
								)
							)
						)
					)
				)
			);
		o.removeElements(case1, 6);
		
		// 输入：head = [], val = 1		输出：[]
		ListNode case2 = x.new ListNode();
		o.removeElements(case2, 1);
		
		// 输入：head = [7,7,7,7], val = 7		输出：[]
		ListNode case3 = x.new ListNode(7,
			x.new ListNode(7,
				x.new ListNode(7,
					x.new ListNode(7)
				)
			)
		);
		o.removeElements(case3, 7);
	}
}
