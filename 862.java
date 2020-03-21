/******************************************************************************

365. 水壶问题
https://leetcode-cn.com/problems/water-and-jug-problem/

*******************************************************************************/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Rec{
    int fromx;
    int fromy;
    //int act; // 0=clearx, 1=cleary, 2=y->x, 3=x->y
    String act; // 0x=clearx, 0y=cleary, 1x=fullx 1y=fully, yx=y->x, xy=x->y
    int tox;
    int toy;
    boolean flg;
    public Rec(int fx, int fy, String ac, int tx, int ty){
        fromx = fx;
        fromy = fy;
        act = ac;
        tox = tx;
        toy = ty;
        flg = false; // true = searched
    }
    public String getKey(){
        return "" + fromx + "_" + fromy + "_" + act;
    }
    public String getKey2(){
        return "" + tox + "_" + toy;
    }
    public String toString(){
        return "fromx=" + fromx + " fromy=" + fromy + " act=" + act + " tox=" + tox + " toy=" + toy;
    }
}
class Solution {
    private Map<String, Rec> mp = new HashMap<String, Rec>();
    private Map<String, List<Rec> > mp2 = new HashMap<String, List<Rec> >();
    public boolean canMeasureWater(int x, int y, int z) {
        boolean ret = false;
        if(z<0 || (z>x+y) ){
            //ret = false;
        }else if(z==0){
            ret = true;
        }else{
            int maxx = x;
            int maxy = y;
            buildMap(maxx, maxy); // x means maxx, y means maxy here
            // DEBUG
            //printMap();
            buildMap2();
            for(int x2=0; !ret && x2<=maxx; x2++){
                for(int y2=0; !ret && y2<=maxy; y2++){
                    if((x2 + y2) == z){
                        if(search(x2, y2)){
                            ret = true;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
    private void buildMap(int maxx, int maxy){
        for(int x=0;x<=maxx;x++){
            for(int y=0;y<=maxy;y++){
                // 0=clearx
                Rec r0 = new Rec(x, y, "0x", 0, y);
                // 1=cleary
                Rec r1 = new Rec(x, y, "0y", x, 0);
                // 2=y->x
                Rec r2 = new Rec(x, y, "yx", Math.min(maxx, x+y), Math.max(0,y-(maxx-x)));
                // 3=x->y
                Rec r3 = new Rec(x, y, "xy", Math.max(0, x-(maxy-y)), Math.min(x, x+y));
                // fullx
                Rec r4 = new Rec(x, y, "1x", maxx, y);
                // fully
                Rec r5 = new Rec(x, y, "1y", x, maxy);
                
                
                // save to Map
                mp.put(r0.getKey(), r0);
                mp.put(r1.getKey(), r1);
                mp.put(r2.getKey(), r2);
                mp.put(r3.getKey(), r3);
                mp.put(r4.getKey(), r4);
                mp.put(r5.getKey(), r5);
            }
        }
    }
    private void printMap(){
        for(Rec r:mp.values()){
            System.out.println(r);
        }
    }
    // 按照结果创建map2
    private void buildMap2(){
        for(Rec r:mp.values()){
            String key2 = "" + r.tox + "_" + r.toy;
            List<Rec> ls = null;
            if(mp2.containsKey(key2)){
                ls = mp2.get(key2);
            }else{
                ls = new ArrayList<Rec>();
            }
            ls.add(r);
            mp2.put(key2, ls);
        }
    }
    // 反复检索map2，同时删掉检索过的节点，直到找到起始点00，则true，否则false
    private boolean search(int x, int y){
        boolean ret = false;
        String key2 = "" + x + "_" + y;
        List<Rec> ls = mp2.get(key2);

        if(ls==null || ls.size()<=0){
            // return false;
        }else{
            for(Rec r:ls){
                if(r.fromx==0 && r.fromy==0){
                    ret = true;
                    break;
                }else if(!r.flg){ // only not searched
                    r.flg = true;
                    if(search(r.fromx, r.fromy)){
                        ret = true;
                        break;
                    }
                }
            }
        }
        // DEBUG
        //System.out.println("search x=" + x + " y=" + y + " ret=" + ret);
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
        tbase(3,5,4); // should be true
        tbase(2,6,5); // should be false
        tbase(1,2,3); // should be false
        tbase(22003,31237,1); // timeout
	}
	private static void tbase(int x, int y, int z){
	    Solution o = new Solution();
	    System.out.println("x=" + x + " y=" + y + " z=" + z + " ret=" + o.canMeasureWater(x,y,z));
	}
    private static void tbase(){	
        tbase(3,5,4); // should be true
    }
}
