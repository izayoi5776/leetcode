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
        int ret = 1;
        while(chk(K, ret)<N){
            //System.out.println("K=" + K + " N=" + N + " ret=" + ret + " mp=" + mp);
            ret++;
        }

        return ret;
    }
    // K, step 步可以占据的最大空间
    int chk(int K, int step){
        //System.out.println("in  K=" + K + " step=" + step);
        int ret = 0;
        String key = "" + K + "_" + step;
        if(K<1){
            // ret = 0;
        }else if(K==1 || (K>=1 && step<2)){
            // 出口条件
            ret = Math.max(0, step);
        }else if(mp.containsKey(key)){
            // 计算过的流用
            ret = mp.get(key);
        }else{
            int up = chk(K, step-1);      // 上半, 所有鸡蛋都能用
            int dn = chk(K-1, step-1);    // 下半，鸡蛋少一个
            ret = up + dn + 1;        // 一共占据的位置
            //System.out.println("K=" + K + " N=" + N + " i=" + i + " ls=" + ls + " mp=" + mp);
            mp.put(key,ret);
        }
        //System.out.println("out K=" + K + " step=" + step + " ret=" + ret + " mp=" + mp);
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
		t10();
		t11();
		t12();
		t13();
		t14();
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
	
	// K > log_2^N 二分法就行。因为有0，所以exp(2,5)不够用
	static void t11(){tbase(8, 32, 6);}
	// 所以要算 N+1 的对数
	static void t12(){tbase(8, 31, 5);}
	// 对数个鸡蛋就正好够用
	static void t13(){tbase(5, 31, 5);}
	// 鸡蛋少了一个，就要再省下一个挨个实验，就是32，16，8，4。这时候3个鸡蛋用完，剩下4个逐个数。所以最坏 3+4 =7
	// 可是实际是6，为什么呢？
	// 
	static void t14(){tbase(4, 31, 6);}

}
