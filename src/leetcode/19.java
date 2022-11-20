/******************************************************************************

删除链表的倒数第N个节点
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode ret = head;
        ListNode pos = head;
        int cnt = n;
        while(--cnt>0){
            pos = pos.next;
        }
        
        while(pos.next!=null){
            pos=pos.next;
            pre=ret;
            ret=ret.next;
        }

        if(ret==head){
            ret = ret.next;
        }else{
            pre.next = ret.next;    
            ret = head;
        }
        
        return ret;
    }
}
// -------------------------------------------------------
/**
 * Definition for singly-linked list.
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
		tbase(new ListNode(new int[]{1,2,3,5}), new ListNode(new int[]{1,2,3,4,5}), 2);
        tbase(null, new ListNode(new int[]{1}), 1); // 1 of 208
        tbase(new ListNode(new int[]{2}), new ListNode(new int[]{1, 2}), 2); // 187 of 208
	}
}
