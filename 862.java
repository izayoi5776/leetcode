/******************************************************************************

365. 水壶问题
https://leetcode-cn.com/problems/water-and-jug-problem/

*******************************************************************************/

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    // 广度优先搜索
    Map<String, Integer> mpDone = new HashMap<String, Integer>();    // 调查完成队列
    Map<String, Integer> mpWait = new HashMap<String, Integer>();    // 等待执行队列
    //Stack<String> mpWait = new Stack<String>();    // 等待执行队列
    boolean canMeasureWater(int maxx, int maxy, int z){
        mpWait.put("0_0", 0);
        boolean ret = false;
        //boolean flgChange = true; // 
        while(!ret && mpWait.size()>0){
            String key = mpWait.keySet().iterator().next();
            mpWait.remove(key);
            mpDone.put(key, 0);
            String[] xy = key.split("_", 0);
            int x = Integer.valueOf(xy[0]);
            int y = Integer.valueOf(xy[1]);
            //flgChange = false;
            if(x + y == z){
                ret = true;
            }else{
                ret |= chkAndAdd(0, y, z);      // action clear x
                ret |= chkAndAdd(x, 0, z);      // action clear y
                ret |= chkAndAdd(maxx, y, z);   // action full x
                ret |= chkAndAdd(x, maxy, z);   // action full y
                ret |= chkAndAdd(Math.max(0, x - (maxy - y)), Math.min(maxy, y+x), z);       // action x -> y
                ret |= chkAndAdd(Math.min(maxx, x+y), Math.max(0, y - (maxx - x)), z);   // action y -> x
            }
            //System.out.println("x=" + x + " y=" + y + " ret=" + ret + " mpDone.size()=" + mpDone.size() + " mpWait=" + Arrays.toString(mpWait.keySet().toArray()));
        }
        return ret;
    }
    // check if x,y not in mpDone, add it to mpWait
    // return true if add new item to mpWait
    private boolean chkAndAdd(int x, int y, int z){
        String key = "" + x + "_" + y;
        boolean ret = false; // true if x + y == z
        if(x==z || y == z || x + y == z){
            ret = true;
        }else if(mpDone.containsKey(key)){
            // do nothing
        }else{
            mpWait.put(key, 0);
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
        tbase(3,5,4); // should be true
        tbase(2,6,5); // should be false
        tbase(1,2,3); // should be true
        tbase(22003,31237,1); // timeout
        tbase(11,13,3); // should be true
	}
	private static void tbase(int x, int y, int z){
	    Solution o = new Solution();
	    System.out.println("x=" + x + " y=" + y + " z=" + z + " ret=" + o.canMeasureWater(x,y,z));
	}
}
