/******************************************************************************

141. 环形链表
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
https://leetcode-cn.com/problems/linked-list-cycle/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean hasCycle(ListNode head) {
        boolean ret = false;
        Set<ListNode> se = new HashSet<>();
        while(head!=null){
            if(se.contains(head)){
                ret = true;
                break;
            }else{
                se.add(head);
                head = head.next;
            }
        }
        return ret;
    }
}
// -------------------------------------------------------
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
    //public String toString(){
    //    return "" + val + "->" + (next==null?"_":next);
    //}
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
    //@Override
    //public int hashCode() {
    //    return super.hashCode();
    //}
}

public class Main
{
	// 用反射调用就不需要每次改代码了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
		Solution o = new Solution();
		Class cls = Solution.class;
		Object ret = null;
		for(Method me : cls.getMethods()){
			// 只要Solution中的方法，应该只有一个
			if(me.getDeclaringClass()==cls){
				try{
					long tm1 = System.nanoTime();
					ret = me.invoke(o, args);
					long tm2 = System.nanoTime();
					System.out.printf("tbase(%s", s(expect));
					for(Object ag : args){
						System.out.printf(", %s", s(ag));
					}
					System.out.printf(")=%s time:%,d ns %s\n", s(ret), tm2-tm1, chk(ret, expect)?"OK":"NG");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	static	 boolean chk(String youret, String expect){		return youret.equals(expect);	}
	static	 boolean chk(int	youret, int	expect){		return youret==expect;	}
	static <T> boolean chk(T	  youret, T	  expect){
		boolean ret = false;
		if(youret!=null){
			if(youret instanceof int[]){
				ret = Arrays.equals((int[])youret, (int[])expect);
			}else{
				ret = youret.equals(expect);	
			}
		}else if(youret==expect){
			ret = true;
		}
		return ret;
	}
	static <T> String  s(T n)	{
		if(n instanceof int[]){
			return Arrays.toString((int[])n);
		}else if(n instanceof int[][]){
			return Arrays.deepToString((int[][])n);
		}else{
			return "" + n;	
		}
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}
	static void t1(){
	    ListNode nd = new ListNode(new int[]{3,2,0,-4});
	    nd.next.next.next.next = nd.next;
		tbase(true, nd);
		
		nd = new ListNode(new int[]{1,2});
		nd.next.next = nd;
		tbase(true, nd);
		
		tbase(false, new ListNode(new int[]{1}));
	}
}


