/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // -----------------
    ListNode(int[] a){
        if(a!=null && a.length>0){
            val = a[0];
            ListNode c = this;
            for(int i=1; i<a.length; i++){
                ListNode n = new ListNode(a[i]);
                c.next = n;
                c = n;
            }
        }
    }
    public String toString(){
        return "" + val + "->" + (next==null?"_":next);
    }
    @Override
    public boolean equals(Object o){
        ListNode b = (ListNode)o;
        //System.out.printf("I N equals(%s) this=%s\n", b, this);
        boolean ret = false;
        if(this==b){
            ret = true;
        }else{
            if(b!=null && val==b.val){
                if(next==null && b.next==null){
                    ret = true;
                }else if(next!=null){
                    ret = next.equals(b.next);
                }
            }
        }
        //System.out.printf("OUT equals(%s)=%b this=%s\n", b, this, ret);
        return ret;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
