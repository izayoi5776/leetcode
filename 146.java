/******************************************************************************

146. LRU缓存机制
https://leetcode-cn.com/problems/lru-cache/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;


class Rec{
    int key;
    int val;
    Rec pre;
    Rec nex;
    public Rec(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    Map<Integer, Rec> mp = new HashMap<>();
    Rec head;
    Rec tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int ret = -1;
        if(mp.containsKey(key)){
            Rec r = mp.get(key);
            moveToHead(r);
            ret = r.val;
        }
        return ret;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Rec r = mp.get(key);
            moveToHead(r);
            r.val = value;
        }else{
            Rec r = new Rec(key, value);
            addToHead(r);
        }
    }
    private void moveToHead(Rec r){
        if(mp.size()>1 && r!=head){
            Rec t_pre = r.pre;
            Rec t_nex = r.nex;

            head.pre = r;
            r.nex = head;
            r.pre = null;
            t_pre.nex = t_nex;
            head = r;
            if(r==tail){
                tail = t_pre;
            }else{
                if(t_nex!=null){
                    t_nex.pre = t_pre;
                }
            }
        }
    }
    private void addToHead(Rec r){
        if(head == null){
            head = r;
            tail = r;
        }else{
            r.nex = head;
            head.pre = r;
            head = r;
        }
        mp.put(r.key, r);
        chkCapacity();
    }
    private void chkCapacity(){
        while(mp.size()>0 && mp.size()>capacity){
            mp.remove(tail.key);
            tail = tail.pre;
            tail.nex = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// -------------------------------------------------------
public class Main
{

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
	static void tbase2(String[] cmds, int[][] parms, Integer[] expects){
        List<Integer> ret = new ArrayList<>();
	    System.out.println("---------------");
        LRUCache cache = null;
	    for(int i=0; i<cmds.length; i++){
	        String c = cmds[i];
	        if(c.equals("LRUCache")){
                cache = new LRUCache(parms[i][0]);
                ret.add(null);
	        }else if(c.equals("put")){
                cache.put(parms[i][0], parms[i][1]);
                ret.add(null);
	        }else if(c.equals("get")){
                int val = cache.get(parms[i][0]);
                ret.add(val);
	        }
	        try{
	            //System.in.read();    
	        }catch(Exception ex){
	            
	        }
        }
        System.out.printf("expect=%s\n", Arrays.toString(expects));
        System.out.printf("result=%s\n", ret);
	}
	public static void main(String[] args) {
		t2();
	}
	/*
	LRUCache cache = new LRUCache( 2  缓存容量  );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
	*/
	static void t2(){
	    tbase2(new String[]{"LRUCache","put","put","get","put","get","put","get","get","get"},
	        new int[][]{{2},{1,1},{2,2},{1},{3,3},{2},{4,4},{1},{3},{4}},
	        new Integer[]{null,null,null,1,null,-1,null,-1,3,4}
        );
	}
}
