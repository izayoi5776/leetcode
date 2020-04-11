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
    Map<String, Integer> mpos = new HashMap<>(); // DEBUG 找到最小值的位置
    public int superEggDrop(int K, int N) {
        int ret = 0;
        ret = chk(K, N);
        //System.out.println("K=" + K + " N=" + N + " mpos=" + mpos);
        return ret;
    }
    // N 从 1 开始
    int chk(int K, int N){
        //System.out.println("in  K=" + K + " N=" + N);
        int ret = 0;
        String key = "" + K + "_" + N;
        if(K<=1 || (K>=1 && N<=2)){
            // 出口条件
            ret = Math.max(0, N);
        }else if(mp.containsKey(key)){
            // 计算过的流用
            ret = mp.get(key);
        }else{
            int min = Integer.MAX_VALUE;
            List<Integer> ls = new ArrayList<>();
            // 扫描大部分可能的分割方式 N/4-N/2 TODO要证明
            //for(int i=Math.max(2,N/4-1); i<=N/2+1;i++){
            for(int i=2; i<=N/2+1;i++){
                int up = chk(K, N-i);       // 上半, 所有鸡蛋都能用
                int dn = chk(K-1, i-1);     // 下半，摔少了一个鸡蛋
                int rt = Math.max(up, dn);  // 较大的值是这种分割下需要的次数
                //ls.add(rt);
                if(rt < min){
                    min = rt;
                    mpos.put(key, i);
                }
                //System.out.println("K=" + K + " N=" + N + " i=" + i + " ls=" + ls + " mp=" + mp);
                
            }
            ret = 1;
            //if(ls.size()>0){
            //    ret = 1 + Collections.min(ls);
            //}
            if(min < Integer.MAX_VALUE){
                ret = 1 + min;
            }
            /*
            // 只算中间1种，TODO要证明
            {
                int i= (int)Math.ceil(N/2.0);
                int up = chk(K, N-i);       // 上半, 所有鸡蛋都能用
                int dn = chk(K-1, i-1);     // 下半，摔少了一个鸡蛋
                int rt1 = Math.max(up, dn) + 1;  // 较大的值是这种分割下需要的次数

                int i2= N/2;
                int rt2 = rt1;
                if(i2!=i){
                    int up2 = chk(K, N-i2);       // 上半, 所有鸡蛋都能用
                    int dn2 = chk(K-1, i2-1);     // 下半，摔少了一个鸡蛋
                    rt2 = Math.max(up2, dn2) + 1;  // 较大的值是这种分割下需要的次数
                }
                ret = Math.min(rt1, rt2);
            }*/
            
            mp.put(key,ret);
        }
        //System.out.println("out K=" + K + " N=" + N + " ret=" + ret + " mp=" + mp);
        //System.out.println("out K=" + K + " N=" + N + " ret=" + ret);
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
		t6();
		t7();
		t8();
		t9();
		//t10();
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
	static void t5(){tbase(4, 5000, 19);}
	static void t6(){
	    tbase(2, 9, 4);
	}
	static void t7(){
	    tbase(3, 25, 5);
	}
	static void t8(){tbase(1, 10, 10);}
	static void t9(){tbase(2, 10, 4);}
	
	// timeout
	static void t10(){tbase(4, 10000, 23);}

}
