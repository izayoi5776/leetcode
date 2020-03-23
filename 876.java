/******************************************************************************

876. 链表的中间结点
https://leetcode-cn.com/problems/middle-of-the-linked-list/

*******************************************************************************/


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pos = head;
        ListNode ret = head;
        int step = 0;
        while(pos!=null){
            pos = pos.next;
            step ++;
            if(step % 2 == 0){
                ret = ret.next;
            }
        }
        return ret;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString(){
        return "" + val + "," + next;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
	static void tbase(ListNode head){
	    Solution o = new Solution();
	    System.out.println("head=" + head + " ret=" + o.middleNode(head));
	}
	static void t1(){
	    // [1,2,3,4,5]
	    ListNode n1 = new ListNode(1);
	    ListNode n2 = new ListNode(2);
	    ListNode n3 = new ListNode(3);
	    ListNode n4 = new ListNode(4);
	    ListNode n5 = new ListNode(5);
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    tbase(n1);  // expect 3.4.5
	}
	static void t2(){
	    // [1,2,3,4,5,6]
	    ListNode n1 = new ListNode(1);
	    ListNode n2 = new ListNode(2);
	    ListNode n3 = new ListNode(3);
	    ListNode n4 = new ListNode(4);
	    ListNode n5 = new ListNode(5);
	    ListNode n6 = new ListNode(6);
	    n1.next = n2;
	    n2.next = n3;
	    n3.next = n4;
	    n4.next = n5;
	    n5.next = n6;
	    tbase(n1);    // expect 4.5.6
	}
}
