/******************************************************************************

445. 两数相加 II
https://leetcode-cn.com/problems/add-two-numbers-ii/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] n1 = List2Vector(l1);
        int[] n2 = List2Vector(l2);
        int[] ret1 = new int[Math.max(n1.length, n2.length) + 1];
        for(int i=ret1.length-1; i>0; i--){
            int add1 = getN(n1, ret1.length-1, i-1);
            int add2 = getN(n2, ret1.length-1, i-1);
            ret1[i] += add1 + add2;
            if(ret1[i]>=10){
                ret1[i] -= 10;
                ret1[i-1]=1;
            }
        }
        
        //System.out.println("n1=" + Arrays.toString(n1) + " n2=" + Arrays.toString(n2) + " ret1=" + Arrays.toString(ret1));
        
        return ret1[0]==0 ? vector2List(ret1, 1) : vector2List(ret1, 0);
    }
    // int[] -> ListNode
    // call this pos == 1 when ar[0] == 0;
    ListNode vector2List(int[] ar, int pos){
        //System.out.println("ar=" + Arrays.toString(ar) + " pos=" + pos);
        ListNode ret = null;
        if(ar!=null){
            if(pos>=0 && pos<ar.length){
                ret = new ListNode(ar[pos]);
                ret.next = vector2List(ar, pos+1);
            }
        }
        return ret;
    }
    // 假装 ar 是length为 N 的数组，不足时候右对齐，返回第 n 个数字，没有值返回 0
    int getN(int[] ar, int N, int n){
        int ret = 0;
        int N2 = ar.length;
        int pos = n - (N - N2);
        if(pos<0 || pos>=N2){
            // ret = 0;
        }else{
            ret = ar[pos];
        }
        //System.out.println("getN(" + Arrays.toString(ar) + "," + N + "," + n +") pos=" + pos + " ret=" + ret);
        return ret;
    }
    // listnode -> int[]
    int[] List2Vector(ListNode nd){
        int[] ret = new int[]{};
        int n = 0;
        if(nd!=null){
            ListNode t = nd;
            while(t!=null){
                n++;
                t = t.next;
            }
            ret = new int[n];
            t = nd;
            for(int i=0;i<n;i++){
                ret[i] = t.val;
                t = t.next;
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
    ListNode(int[] xa, int start){
        if(xa!=null && xa.length > start){
            val = xa[start];
            if(xa.length>start+1){
                next = new ListNode(xa, start+1);
            }
        }
    }
    public String toString(){
        return "" + val + (next==null ? "" : "," + next);
    }
    boolean equals(ListNode b){
        boolean ret1 = false;
        boolean ret2 = false;
        if(b!=null){
            ret1 = val == b.val;
            if(next==null && b.next==null){
                ret2 = true;
            }else if(next!=null && b.next!=null){
                ret2 = next.equals(b.next);
            }else{
                // ret2 = false;
            }
        }
        return ret1 && ret2;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
    static void tbase(ListNode l1, ListNode l2, ListNode expect){
	    Solution o = new Solution();
	    ListNode ret = o.addTwoNumbers(l1, l2);
	    System.out.println("l1=" + l1 + " l2=" + l2 + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(ListNode youret, ListNode expect){
	    return youret.equals(expect);
	}
	// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 输出：7 -> 8 -> 0 -> 7
	static void t1(){
	    tbase(new ListNode(new int[]{7,2,4,3}, 0)
	        , new ListNode(new int[]{  5,6,4}, 0)
	        , new ListNode(new int[]{7,8,0,7}, 0)
	   );
	}
	static void t2(){
	    tbase(new ListNode(new int[]{5}, 0)
	        , new ListNode(new int[]{5}, 0)
	        , new ListNode(new int[]{1,0}, 0)
	   );
	}
	static void t3(){
	    tbase(new ListNode(new int[]{1}, 0)
	        , new ListNode(new int[]{9,9}, 0)
	        , new ListNode(new int[]{1,0,0}, 0)
	   );
	}
}
