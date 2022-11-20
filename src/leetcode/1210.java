//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.ArrayList;

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    Solution obj = new Solution();
    ListNode head = new ListNode(1);
    ListNode h2 = new ListNode(2);
    ListNode h3 = new ListNode(3);
    ListNode h4 = new ListNode(4);
    ListNode h5 = new ListNode(5);
    head.next = h2;
    h2.next = h3;
    h3.next = h4;
    h4.next = h5;
    ListNode out = obj.reverseList(head);
    out.print();
  }
}

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  public void print(){
    System.out.print(val);
    if(next != null){
      System.out.print("->");
      next.print();
    }else{
      System.out.println("->NULL");
    }
  }
}

class Solution {
    public ListNode reverseList(ListNode head) {
      // base on old list, we call last -> cur -> next
      ListNode cur = head;
      ListNode last = null;
      while(cur != null){
        ListNode next = cur.next;
        cur.next = last;
        last = cur;
        cur = next;
        // debug
        //System.out.print(" cur= ");
        //if(cur!=null){cur.print();}
        //System.out.print("last= ");
        //if(last!=null){ last.print(); }
      }
        return last;
    }
}

