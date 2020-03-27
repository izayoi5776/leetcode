/******************************************************************************

914. 卡牌分组
https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        boolean ret = false;
        // 保存到 Map 中，< 值，个数 >
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0;i<deck.length;i++){
            int key = deck[i];
            int value = mp.getOrDefault(key, 0);
            mp.put(key, value +1);
        }
        
        // 个数 放到 SrotedMap 里去
        SortedMap <Integer, Integer> mp2 = new TreeMap<Integer, Integer>();
        for(Integer i:mp.values()){
            mp2.put(i, 0);
        }
        
        SortedMap<Integer, Integer> mp3 = new TreeMap<Integer, Integer>();
        // 最小个数不能是 1
        int fstkey = mp2.firstKey();
        if(fstkey > 1){
            if(mp2.size()==1){
                ret = true;
            }else{
                // 2 的倍数确认
                boolean div2 = true;
                for(Integer i:mp2.keySet()){
                    if(i % 2 != 0){
                        div2 = false;
                        break;
                    }
                }
                if(div2){
                    ret = true;
                }else{
                    // 个数的差值存进 mp3
                    int base = fstkey;
                    for(Integer i:mp2.tailMap(fstkey+1).keySet()){
                        mp3.put(i-base, 0);
                        base = i;
                    }
                    
                    // 个数的差值不能是 1
                    int fstdiff = mp3.firstKey();
                    if(fstdiff > 1){
                        // 如果答案为true, 则这个最小的差值一定是公约数（的倍数）。反之也成立
                        for(int i=3; i<=mp3.lastKey(); i+=2){
                            if(fstdiff % i == 0){
                                boolean divi = true;
                                for(Integer j:mp2.keySet()){
                                    if(j % i != 0){
                                        divi = false;
                                        break;
                                    }
                                }
                                if(divi){
                                    // 全部 mp2 可以被 i 整除
                                    ret = true;
                                }
                            }
                        }
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
		t5();
	}
	static void tbase(int[] deck, boolean exp){
	    Solution o = new Solution();
	    System.out.println("deck=" + Arrays.toString(deck) + " ret=" + o.hasGroupsSizeX(deck) + " expect=" + exp);
	}
	static void t1(){
	    tbase(new int[]{1,2,3,4,4,3,2,1}, true);
	}
	static void t2(){
	    tbase(new int[]{1,1,1,2,2,2,3,3}, false);
	}
	static void t3(){
	    tbase(new int[]{1}, false);
	}
	static void t4(){
	    tbase(new int[]{1,1}, true);
	}
	static void t5(){
	    tbase(new int[]{1,1,2,2,2,2}, true);
	}

}
