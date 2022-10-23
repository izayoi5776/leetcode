package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class L160 {
	class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			List<ListNode> a = linkTbl2Array(headA);
			List<ListNode> b = linkTbl2Array(headB);
			int cur = 1;
			while(cur<=a.size() && cur<=b.size() && a.get(a.size()-cur)==b.get(b.size()-cur)) {
				cur++;				
			}
			if(cur==1) {
				return null;
			}
	    	return a.get(a.size() - cur + 1);
	    }
		List<ListNode> linkTbl2Array(ListNode head){
			List<ListNode> ret = new ArrayList<>();
			ListNode cur = head; 
			while(cur!=null) {
				ret.add(cur);
				cur = cur.next;
			}
			return ret;
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
		L160 x = new L160();
		L160.Solution o = x.new Solution();

		// 输入：intersectVal = 8, listA = [4,1,8,4,5], 
		// listB = [5,6,1,8,4,5], skipA = 2, skipB = 3 		
		// 输出：Intersected at '8'
		ListNode c = x.new ListNode(8,
			x.new ListNode(4,
				x.new ListNode(5)
			)
		);
		ListNode a = x.new ListNode(4,
			x.new ListNode(1, c)
		);
		ListNode b = x.new ListNode(5,
			x.new ListNode(6,
				x.new ListNode(1, c)
			)
		);
		o.getIntersectionNode(a, b);
		
		// 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], 
		// skipA = 3, skipB = 1	输出：Intersected at '2'
		c = x.new ListNode(2,
			x.new ListNode(4)
		);
		a = x.new ListNode(1,
				x.new ListNode(9,
					x.new ListNode(1, c)
				)
			);
		b = x.new ListNode(3, c);
		o.getIntersectionNode(a, b);
		
		// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
		// 输出：null
		a = x.new ListNode(2,
			x.new ListNode(6,
				x.new ListNode(4)
			)
		);
		b = x.new ListNode(1,
			x.new ListNode(5)
		);
		o.getIntersectionNode(a, b);
	}
}
