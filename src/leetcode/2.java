/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = null;
        ListNode cur = top;
        int cf = 0; // 进位寄存器

        int sum = 0;
        while(true){
            if(l1==null && l2==null && cf==0){
                break;
            }
            int a = l1==null ? 0 : l1.val;
            int b = l2==null ? 0 : l2.val;

            sum = a + b + cf;
            if(sum>=10){
                sum -= 10;
                cf = 1;
            } else {
                cf = 0;
            }

            ListNode next = new ListNode(sum);
            if(cur==null){
                cur = next;
                top = cur;
            } else {
                cur.next = next; 
                cur = cur.next;
            }

            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }
        return top;
    }
}
