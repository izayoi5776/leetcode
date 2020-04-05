/******************************************************************************

460. LFU缓存
https://leetcode-cn.com/problems/lfu-cache/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;

class MyMap<E, F> extends LinkedHashMap<E, F>{
    int cap = 100;
    MyMap(int capacity){
        super(capacity, 0.75f, true);
        cap = capacity;
        //System.out.println("MyMap() called");
    }
    protected boolean removeEldestEntry(Map.Entry eldest) {
        boolean ret = size() > cap;
        System.out.println("MyMap::removeEldestEntry() called eldest=[" + eldest + "] size=" + size() + " ret=" + ret);
        return ret;
    }
}

class LFUCache {
    MyMap<Integer, Integer> m = null;

    public LFUCache(int capacity) {
        m = new MyMap<Integer, Integer>(capacity);
        //System.out.println("LFUCache() called cap=" + capacity + " m=" + m);
    }
    
    public int get(int key) {
        int ret = -1;
        Integer val = m.get(key);
        if(val!=null){
            ret = val;
        };
        //System.out.println("LFUCache::get() called key=" + key + " ret=" + ret);
        return ret;
    }
    
    public void put(int key, int value) {
        m.put(key, value);
        System.out.println("LFUCache::put() called key=" + key + " value=" + value + " m=" + m);
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
		//t1();
		t2();
	}
    static void tbase(LFUCache cache, int val, int expect){
	    System.out.println("ret=" + val + " expect=" + expect);
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
	static void t2(){
	    tbase2(new String[]{"LFUCache","put","put","get","get","get","put","put","get","get","get","get"},
	        new int[][]{{3},{2,2},{1,1},{2},{1},{2},{3,3},{4,4},{3},{2},{1},{4}},
	        new Integer[]{null,null,null,2,1,2,null,null,-1,2,1,4}
        );
	}
}
