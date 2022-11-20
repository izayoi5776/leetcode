package leetcode;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
public class L83 {
	class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode n = head;
			while(n!=null && n.next != null) {
				 if(n.val == n.next.val) {
					 n.next = n.next.next;
				 }else {
					 n = n.next;
				 }
			}
	    	return head;
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
		L83 x = new L83();
		L83.Solution o = x.new Solution();
		//[1,1,2]
		ListNode n3 = x.new ListNode(2);
		ListNode n2 = x.new ListNode(1, n3);
		ListNode n1 = x.new ListNode(1, n2);
		o.deleteDuplicates(n1);
		
		// [1,1,2,3,3]
		ListNode case2 = x.new ListNode(1,
			x.new ListNode(1,
				x.new ListNode(2,
					x.new ListNode(3,
						x.new ListNode(3)
					)
				)
			)
		);
		o.deleteDuplicates(case2);
	}
}
