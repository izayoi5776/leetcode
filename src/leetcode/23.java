/******************************************************************************

23. 合并K个排序链表
https://leetcode-cn.com/problems/merge-k-sorted-lists/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;


class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;   // 头
        ListNode last = null;   // 上一个
        ListNode cur  = null;   // 现在处理中的一个
        // Integer.MAX_VALUE == 2147483647
        long n =               10000000000L;
        if(lists!=null && lists.length>0){
            //ret = lists[0];
            //ListNode[] ls = Arrays.copyOfRange(lists, 0, lists.length);
            SortedMap<Long, ListNode> mp = new TreeMap<>();   // 保存最左边一组 ListNode
            // 第一组上膛
            for(int i=0; i<lists.length; i++){
                ListNode nd = lists[i];
                if(nd!=null){
                    long key = (long)nd.val * n + i;   // 同时解决 key 重复和数字排序的问题
                    mp.put(key, nd);
                }
            }

            while(mp.size()>0){
                //System.out.println("1 mp=" + mp + " head=" + head + " last=" + last + " cur=" + cur);
                long key = mp.firstKey();
                long i = (key + n) % n; // 负数对应
                if(i<0){
                    i = ( i + n ) % n;
                }
                cur = mp.remove(key);
                //System.out.println("2 mp=" + mp + " head=" + head + " last=" + last + " cur=" + cur);
                if(cur!=null){
                    if(head==null){
                        head = cur;
                        last = cur;
                        //System.out.println("3 mp=" + mp + " head=" + head + " last=" + last + " cur=" + cur);
                    }else{
                        last.next = cur;
                        last = cur;
                        //System.out.println("4 mp=" + mp + " head=" + head + " last=" + last + " cur=" + cur);
                    }
                    if(cur.next!=null){
                        Long keynext = cur.next.val * n + i;
                        //System.out.println("5 mp=" + mp + " head=" + head + " last=" + last + " cur=" + cur + " key=" + key + " i=" + i);
                        mp.put(keynext, cur.next);
                    }
                }
            }
        }
        return head;
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
        return "" + val + "-" + (next==null ? "_" : next);
    }
}
// 避免直接修改 leetcode 提供的类
class ListNodeHelper{
    // 构造一系列 ListNode
    static ListNode buildList(int[] vals){
        ListNode head = null;
        ListNode cur  = null;
        if(vals!=null && vals.length>0){
            head = new ListNode(vals[0]);
            cur  = head;
            for(int i=1; i<vals.length; i++){
                ListNode next = new ListNode(vals[i]);
                cur.next = next;
                cur = next;
            }
        }
        return head;
    }
    static boolean equals(ListNode a, ListNode b){
        boolean ret = false;
        if(a!=null && b!=null){
            if(a.val == b.val){
               if(a.next==b.next){
                   ret = true;
               }else{
                   if(a.next!=null && b.next!=null){
                        ret = equals(a.next, b.next);
                   }
               }
            }
        }
        return ret;
    }
}
public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
		t4();
	}
    static void tbase(ListNode[] lists, ListNode expect){
        System.out.println("--------------------");
	    Solution o = new Solution();
	    ListNode ret = o.mergeKLists(lists);
	    System.out.println("lists=" + lists + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(ListNode youret, ListNode expect){
	    return ListNodeHelper.equals(youret, expect);
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}

	// case 29/131
	static void t1(){
	    tbase(new ListNode[]{
	        ListNodeHelper.buildList(new int[]{1,4,5}),
	        ListNodeHelper.buildList(new int[]{1,3,4}),
	        ListNodeHelper.buildList(new int[]{2,6})
	    },
	    ListNodeHelper.buildList(new int[]{1,1,2,3,4,4,5,6}));
	}
	// case 35/131
	static void t2(){
	    tbase(new ListNode[]{
	        ListNodeHelper.buildList(new int[]{}),
	        ListNodeHelper.buildList(new int[]{-1,5,11}),
	        ListNodeHelper.buildList(new int[]{}),
	        ListNodeHelper.buildList(new int[]{6,10})
	    },
	    ListNodeHelper.buildList(new int[]{-1,5,6,10,11}));
	}
	// case 72/131
	static void t3(){
	    tbase(new ListNode[]{
	        ListNodeHelper.buildList(new int[]{}),
	        ListNodeHelper.buildList(new int[]{-1,5}),
	        ListNodeHelper.buildList(new int[]{1,4,6}),
	        ListNodeHelper.buildList(new int[]{4,5,6})
	    },
	    ListNodeHelper.buildList(new int[]{-1,1,4,4,5,5,6,6}));
	}
	// case 70/131
	static void t4(){
	    tbase(new ListNode[]{
	        ListNodeHelper.buildList(new int[]{-8,-7,-6,-3,-2,-2,0,3}),
	        ListNodeHelper.buildList(new int[]{-10,-6,-4,-4,-4,-2,-1,4}),
	        ListNodeHelper.buildList(new int[]{-10,-9,-8,-8,-6}),
	        ListNodeHelper.buildList(new int[]{-10,0,4})
	    },
	    ListNodeHelper.buildList(new int[]{-10,-10,-10,-9,-8,-8,-8,-7,-6,-6,-6,-4,-4,-4,-3,-2,-2,-2,-1,0,0,3,4,4}));
	}

}
