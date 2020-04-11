/******************************************************************************

887. 鸡蛋掉落
https://leetcode-cn.com/problems/super-egg-drop/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    Map<String, Integer> mp = new HashMap<>();
    public int superEggDrop(int K, int N) {
        int ret = 0;
        ret = chk(K, N);
        return ret;
    }
    // N 从 1 开始
    int chk(int K, int N){
        //System.out.println("in  K=" + K + " N=" + N);
        int ret = 0;
        String key = "" + K + "_" + N;
        if(K<=1 || N<=2){
            // 出口条件
            ret = Math.max(0, N);
        }else if(mp.containsKey(key)){
            // 计算过的流用
            ret = mp.get(key);
        }else{
            List<Integer> ls = new ArrayList<>();
            // 扫描大部分可能的分割方式
            for(int i=2; i<=N-1;i++){
                int up = chk(K, N-i);       // 上半, 所有鸡蛋都能用
                int dn = chk(K-1, i-1);     // 下半，摔少了一个鸡蛋
                int rt = Math.max(up, dn);  // 较大的值是这种分割下需要的次数
                ls.add(rt);
            }
            ret = 1;
            if(ls.size()>0){
                ret = 1 + Collections.min(ls);
            }
            mp.put(key,ret);
        }
        //System.out.println("out K=" + K + " N=" + N + " ret=" + ret + " mp=" + mp);
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
    static void tbase(int K, int N, int expect){
	    System.out.println("-------------------------");
	    Solution o = new Solution();
	    int ret = o.superEggDrop(K, N);
	    System.out.println("K=" + K + " N=" + N + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int youret, int expect){
	    return youret == expect;
	}
	static void t1(){
	    tbase(1, 2, 2);
	}
	static void t2(){
	    tbase(2, 6, 3);
	}
	static void t3(){
	    tbase(3, 14, 4);
	}
	static void t4(){
	    tbase(2, 3, 2);
	}
	// timeout
	static void t5(){
	    tbase(4, 5000, 0);
	}
}
