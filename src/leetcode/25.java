/******************************************************************************

25. K 个一组翻转链表
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Rec{
    ListNode nd;
    Rec pre;
    public Rec(ListNode nd, Rec pre){
        this.nd = nd;
        this.pre = pre;
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = null;
        ListNode preGrpRevTail = null; // 前一组反转后的末尾(也就是反转前的开头)，需要在后一组完成之后才能填写
        ListNode curGrpHead    = null; // 现在组反转前开头
        ListNode pos = head;
        Rec r = null;
        while(pos!=null){
            int cnt = 0;
            curGrpHead = pos;
            for(; cnt<k && pos!=null; cnt++){
                r = new Rec(pos ,r);
                pos = pos.next;
                //System.out.printf("loop1 cnt=%d pos=%s \n", cnt, pos);
            }
            if(ret==null){
                ret = r.nd;
            }
            if(cnt==k){
                if(preGrpRevTail!=null){
                    preGrpRevTail.next = r.nd;
                }
                for(cnt=k-1; cnt>=0 && r!=null; cnt--){
                    r.nd.next = r.pre==null ? null : r.pre.nd;
                    if(cnt==0){
                        preGrpRevTail = r.nd;
                    }
                    r = r.pre;
                }
            }else{
                // 没能整除的
                if(preGrpRevTail!=null){
                    preGrpRevTail.next = curGrpHead;
                }
            }
        }
        
        return ret;
    }
}
// -------------------------------------------------------
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

public class Main
{
	// 用反射?用就不需要?次改代?了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
		Solution o = new Solution();
		Class cls = Solution.class;
		Object ret = null;
		for(Method me : cls.getMethods()){
			// 只要Solution中的方法，??只有一个
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
		tbase(new ListNode(new int[]{2,1,4,3,5}), new ListNode(new int[]{1,2,3,4,5}), 2);
		tbase(new ListNode(new int[]{3,2,1,4,5}), new ListNode(new int[]{1,2,3,4,5}), 3);
        tbase(new ListNode(new int[]{}), new ListNode(new int[]{}), 1);
        tbase(new ListNode(new int[]{1}), new ListNode(new int[]{1}), 1);
        tbase(new ListNode(new int[]{2,1}), new ListNode(new int[]{1,2}), 2);
        tbase(new ListNode(new int[]{2,1,4,3,6,5}), new ListNode(new int[]{1,2,3,4,5,6}), 2);
        tbase(new ListNode(new int[]{2,1,4,3,6,5,7}), new ListNode(new int[]{1,2,3,4,5,6,7}), 2);
	}
}

