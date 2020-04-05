/******************************************************************************

460. LFU缓存
https://leetcode-cn.com/problems/lfu-cache/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
//import java.util.LinkedHashMap;

class Rec{
    int key;
    int value;
    Rec prev;
    Rec next;
    Rec(int key, int value){
        this.key = key;
        this.value = value;
    }
    String printTree(){
        String ret = "" + key + "=" + value;
        if(next!=null){
            ret += "/" + next.printTree();
        }
        return ret;
    }
}
class LFUCache {
    Map<Integer, Rec> m = new HashMap<Integer, Rec>();
    int capacity = 0;
    Rec head = null;    // 真的开头
    Rec tail = null;    // 结尾
    Rec ins  = null;    // 插入点

    public LFUCache(int capacity) {
        this.capacity = capacity;
        //System.out.println("LFUCache() called cap=" + capacity + " m=" + m);
    }
    
    public int get(int key) {
        int ret = -1;
        if(m.containsKey(key)){
            Rec r = m.get(key);
            if(head!=r){
                Rec rp = r.prev;
                Rec rn = r.next;
                if(rp!=null){rp.next = rn;}
                if(rn!=null){rn.prev = rp;}

                if(ins==r){
                    ins=rn;
                }    
                if(tail==r){
                    tail=rp;
                }

                r.next = head;
                r.prev = null;
                head.prev = r;
                head = r;
            }else{
                if(ins==r){
                    ins = r.next;    
                }
            }
            ret = r.value;
        }
        printStatus("LFUCache::get(" + key + ")=" + ret);
        return ret;
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            Rec r = m.get(key);
            r.value = value;
            m.put(key, r);
        }else{
            if(chkCap()){
                Rec r = new Rec(key, value);
                if(head==null){
                    head = r;
                }
                if(tail==null){
                    tail = r;
                }
                if(ins==null){
                    ins = r;    // 指向最新插入的记录
                    if(tail!=null && tail != r){
                        tail.next = r;
                        r.prev = tail;
                    }
                    tail = r;
                }else{
                    Rec rp = ins.prev;
                    if(rp!=null){rp.next = r;}
                    r.prev = rp;
    
                    if(head==ins){
                        head = r;
                    }
    
                    ins.prev = r;
                    r.next = ins;
    
                    ins = r;
                }
                m.put(key, r);
            }
        }
        printStatus("LFUCache::put(" + key + "," + value + ")");
    }
    boolean chkCap(){
        if(m.size() > capacity -1){
            if(tail!=null){
                printStatus("LFUCache::chkCap() size()=" + m.size() + ">" + (capacity - 1) + " REMOVE ");
                m.remove(tail.key);
                if(head==tail){
                    head = null;
                    tail = null;
                    ins = null;
                }else{
                    if(ins==tail){
                        ins = null;
                    }
                    if(tail.prev!=null){
                        tail = tail.prev;
                        tail.next = null;
                    }
                }
            }
        }
        printStatus("LFUCache::chkCap()");
        return m.size() < capacity;
    }
    void printStatus(String s){
        if(true){
            String shead = null;
            String sins = null;
            String stail = null;
            if(head!=null){shead = head.printTree();}
            if(ins!=null){sins = ins.printTree();}
            if(tail!=null){stail = tail.printTree();}
            System.out.println(s + " keys=" + m.keySet() + " head=" + shead + " ins=" + sins + " tail=" + stail);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Main
{
	public static void main(String[] args) {
		/*t1();
		t2();
		t3();
		t4();
		t5(); */
		t6();
	}
    static void tbase(LFUCache cache, int val, int expect){
	    System.out.println("ret=" + val + " expect=" + expect +  (val==expect?" OK":" NG"));
	}
	static void t1(){
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
        cache.put(1, 1);
        cache.put(2, 2);
        tbase(cache, cache.get(1), 1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        tbase(cache, cache.get(2), -1);       // 返回 -1 (未找到key 2)
        tbase(cache, cache.get(3), 3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        tbase(cache, cache.get(1), -1);       // 返回 -1 (未找到 key 1)
        tbase(cache, cache.get(3), 3);       // 返回 3
        tbase(cache, cache.get(4), 4);       // 返回 4
	}
	static void tbase2(String[] cmds, int[][] parms, Integer[] expects){
        LFUCache cache = null;
	    for(int i=0; i<cmds.length; i++){
	        String c = cmds[i];
	        if(c.equals("LFUCache")){
	            cache = new LFUCache(parms[i][0]);
	        }else if(c.equals("put")){
	            cache.put(parms[i][0], parms[i][1]);
	        }else if(c.equals("get")){
	            tbase(cache, cache.get(parms[i][0]), expects[i]);
	        }
	    }
	}
	// 注意，put 不计算为使用，所以get(3)得到-1。
	// 所以不能用 LinkedHashMap 了
	static void t2(){
	    System.out.println("---------------");
	    tbase2(new String[]{"LFUCache","put","put","get","get","get","put","put","get","get","get","get"},
	        new int[][]{{3},{2,2},{1,1},{2},{1},{2},{3,3},{4,4},{3},{2},{1},{4}},
	        new Integer[]{null,null,null,2,1,2,null,null,-1,2,1,4}
        );
	}
	// put() 并不是在最后，而是按顺序。所以同是没有get过的2和3，较老的3被删掉。
	static void t3(){
	    System.out.println("---------------");
	    tbase2(new String[]{"LFUCache","put","put","put","put","get"},
	        new int[][]{{2},{3,1},{2,1},{2,2},{4,4},{2}},
	        new Integer[]{null,null,null,null,null,2}
        );
	}
	// cap == 0 时
	static void t4(){
	    System.out.println("---------------");
	    tbase2(new String[]{"LFUCache","put","get"},
	        new int[][]{{0},{0,0},{0}},
	        new Integer[]{null,null,-1}
        );
	}

	static void t5(){
	    System.out.println("---------------");
	    tbase2(new String[]{"LFUCache","put","put","get","put","put","get"},
	        new int[][]{{2},{2,1},{2,2},{2},{1,1},{4,1},{2}},
	        new Integer[]{null,null,null,2,null,null,2}
        );
	}
	static void t6(){
	    System.out.println("---------------");
	    tbase2(new String[]{"LFUCache","put","put","put","put","get","get"},
	        new int[][]{{2},{2,1},{1,1},{2,3},{4,1},{1},{2}},
	        new Integer[]{null,null,null,null,null,-1,3}
        );
	}
    
}
