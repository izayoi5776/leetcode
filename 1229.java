//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    ListNode a4 = new ListNode(4);
    ListNode a2 = new ListNode(2); a2.next = a4;
    ListNode a1 = new ListNode(1); a1.next = a2;
    ListNode b4 = new ListNode(4);
    ListNode b3 = new ListNode(3); b3.next = b4;
    ListNode b1 = new ListNode(1); b1.next = b3;
    
    Solution obj = new Solution();
    ListNode out = obj.mergeTwoLists(a1, b1);
    System.out.print(out);
  }
}

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  public String toString(){
    String ret = "" + val;
    if(next != null){
      ret += "->";
      ret += next.toString();
    }else{
      ret += "->NULL";
    }
    return ret;
  }
}

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
