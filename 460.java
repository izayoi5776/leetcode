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
    boolean getflg = false;  // get flag
    Rec prev;
    Rec next;
    Rec(int key, int value){
        this.key = key;
        this.value = value;
    }
    String printTree(){
        String ret = "(" + key + "," + value + "," + (getflg?"T":"F") + "," + (prev==null?"N":prev.key) + "," + (next==null?"N":next.key) +")";
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
            r.getflg = true;
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
            if(r.value==value){
                // 值不变不需要追加
            }else{
                r.getflg = false;
                r.value = value;
                m.put(key, r);

                if(head==r){
                    // do nothing
                }else{
                    if(!r.getflg){
                        if(ins != r){
                            Rec rp = r.prev;
                            Rec rn = r.next;
                            if(rp!=null){rp.next = rn;}
                            if(rn!=null){rn.prev = rp;}
                            if(tail==r){tail = rp;}
                            if(head==ins){head=r;}
        
                            r.next = ins;
                            r.prev = ins.prev;
                            if(ins.prev!=null){
                                ins.prev.next=r;
                            }
                            ins.prev = r;
                            ins = r;
                        }
                    }
                }
            }
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
    // 删除一项
    void remove(int key){
        if(m.containsKey(key)){
            Rec r = m.get(key);
            m.remove(r);
            if(head==r){
                head = r.next;
            }
            if(ins==r){
                ins = r.next;
            }
            if(tail==r){
                tail = r.prev;
            }
            
            Rec rp = r.prev;
            Rec rn = r.next;
            if(rp!=null){rp.next = rn;}
            if(rn!=null){rn.prev = rp;}
        }
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
		t1();
		t2();
		t3();
		t4();
		t5(); 
		t6();
		t7();
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
	    System.out.println("---------------");
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
	        try{
	            //System.in.read();    
	        }catch(Exception ex){
	            
	        }
	        
	    }
	}
	// 注意，put 不计算为使用，所以get(3)得到-1。
	// 所以不能用 LinkedHashMap 了
	static void t2(){
	    tbase2(new String[]{"LFUCache","put","put","get","get","get","put","put","get","get","get","get"},
	        new int[][]{{3},{2,2},{1,1},{2},{1},{2},{3,3},{4,4},{3},{2},{1},{4}},
	        new Integer[]{null,null,null,2,1,2,null,null,-1,2,1,4}
        );
	}
	// put() 并不是在最后，而是按顺序。所以同是没有get过的2和3，较老的3被删掉。
	static void t3(){
	    tbase2(new String[]{"LFUCache","put","put","put","put","get"},
	        new int[][]{{2},{3,1},{2,1},{2,2},{4,4},{2}},
	        new Integer[]{null,null,null,null,null,2}
        );
	}
	// cap == 0 时
	static void t4(){
	    tbase2(new String[]{"LFUCache","put","get"},
	        new int[][]{{0},{0,0},{0}},
	        new Integer[]{null,null,-1}
        );
	}

	static void t5(){
	    tbase2(new String[]{"LFUCache","put","put","get","put","put","get"},
	        new int[][]{{2},{2,1},{2,2},{2},{1,1},{4,1},{2}},
	        new Integer[]{null,null,null,2,null,null,2}
        );
	}
	static void t6(){
	    tbase2(new String[]{"LFUCache","put","put","put","put","get","get"},
	        new int[][]{{2},{2,1},{1,1},{2,3},{4,1},{1},{2}},
	        new Integer[]{null,null,null,null,null,-1,3}
        );
	}
	static void t7(){
	    tbase2(new String[]{"LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"},
	        new int[][]{{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}},
	        new Integer[]{null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null}
        );
	}
    
}
