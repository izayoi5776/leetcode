/******************************************************************************

1094. 拼车
https://leetcode-cn.com/problems/car-pooling/

*******************************************************************************/

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Collection;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        boolean ret = true;
        // key=station, value=net numbers >0 means up to bus, <0 means leave bus
        SortedMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        if(trips==null){
            //ret = true;
        }else{
            if(trips[0].length<3){
                // ASSERT FALSE
            }else{
                for(int i=0;i<trips.length;i++){
                    chk(mp, trips[i][1], trips[i][0]); // 上车
                    chk(mp, trips[i][2], -1 * trips[i][0]); // 下车
                    //System.out.println("i=" + i + " mp=" + mp);
                }
                //System.out.println("mp=" + mp);
                
                Collection<Integer> vs = mp.values();  // 每一站上下车人数
                int sum = 0; // 车上动态人数
                for(Integer i:vs){
                    sum += i;
                    if(sum > capacity){
                        ret = false;
                        break;
                    }
                    //System.out.println("i=" + i + " sum=" + sum);
                }
            }
        }
        
        return ret;
    }
    /**
     * mp 保存用Map
     * station 车站
     * num 上下车人数，>0是上车， <0 是下车
     */
    void chk(SortedMap<Integer, Integer> mp, int station, int num){
        //System.out.println("chk() mp=" + mp + " station=" + station + " num=" + num);
        if(mp==null){
            // do nothing
        }else{
            if(mp.containsKey(station)){
                int val = mp.get(station) + num;
                if(val==0){
                    mp.remove(station); // 0 不保存
                }else{
                    mp.put(station, val);
                }
            }else{
                if(num!=0){
                    mp.put(station, num);
                }
            }
        }
    }
}


public class Main
{
	public static void main(String[] args) {
		//t1();
		//t2();
		//t3();
		//t4();
		t5();
	}
    static void tbase(int[][] trips, int capacity, boolean expect){
	    Solution o = new Solution();
	    System.out.println("trips=" + Arrays.deepToString(trips) + " ret=" + o.carPooling(trips, capacity) + " expect=" + expect);
	}
	static void t1(){
	    tbase(new int[][]{{2,1,5},{3,3,7}}, 4, false);
	}
	static void t2(){
	    tbase(new int[][]{{2,1,5},{3,3,7}}, 5, true);
	}
	static void t3(){
	    tbase(new int[][]{{2,1,5},{3,5,7}}, 3, true);
	}
	static void t4(){
	    tbase(new int[][]{{3,2,7},{3,7,9},{8,3,9}}, 11, true);
	}
	static void t5(){
	    tbase(new int[][]{{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}}, 12, false);
	}

    
}



