//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    ListNode head = new ListNode(1);
    ListNode h2 = new ListNode(2);
    ListNode h3 = new ListNode(3);
    ListNode h4 = new ListNode(4);
    head.next = h2;
    h2.next = h3;
    h3.next = h4;
    Solution obj = new Solution();
    ListNode out = obj.swapPairs(head);
    //System.out.print(h2);
    out.print();
  }
}
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  public void print(){
    System.out.print(val);
    if(next != null){
      System.out.print(">");
      next.print();
    }
  }
}

/**
 * Definition for singly-linked list.
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
      if(head == null || head.next == null){
        return head;
      }else{
        ListNode h2 = head.next;
        ListNode h3 = h2.next; // maybe null
        h2.next = head;
        head.next = h3;
        if(h3 != null){
          head.next = swapPairs(h3);
        }
        return h2;
      }
    }
}

