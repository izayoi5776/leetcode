/******************************************************************************

21. 合并两个有序链表
https://leetcode-cn.com/problems/merge-two-sorted-lists/

*******************************************************************************/

import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1==null && l2==null){
        return null;
      }else if(l1==null){
        return l2;
      }else if(l2==null){
        return l1;
      }else{
        if(l1.val <= l2.val){
          l1.next = mergeTwoLists(l1.next, l2);
          return l1;
        }else{
          l2.next = mergeTwoLists(l1, l2.next);
          return l2;
        }
      }
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
        return "" + val + "->" + (next==null ? "_" : next);
    }
}

// one class needs to have a main() method
public class Main
{
    public static void main(String[] args) {
		t1();
	}
    static void tbase(ListNode l1, ListNode l2, ListNode expect){
		System.out.println("--------------------");
	    System.out.println("l1=" + l1 + " l2=" + l2 );
	    Solution o = new Solution();
	    ListNode ret = o.mergeTwoLists(l1, l2);
	    System.out.println("l1=" + l1 + " l2=" + l2 + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}

    static void t1(){
        ListNode a4 = new ListNode(4);
        ListNode a2 = new ListNode(2); a2.next = a4;
        ListNode a1 = new ListNode(1); a1.next = a2;
        ListNode b4 = new ListNode(4);
        ListNode b3 = new ListNode(3); b3.next = b4;
        ListNode b1 = new ListNode(1); b1.next = b3;
        
        //Solution obj = new Solution();
        //ListNode out = obj.mergeTwoLists(a1, b1);
        //System.out.print(out);
        tbase(a1, b1, null);
    }
}

