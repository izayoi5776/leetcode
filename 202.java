/******************************************************************************

202. 快乐数
https://leetcode-cn.com/problems/happy-number/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        boolean ret = false;
        Set<Integer> se = new HashSet<>();
        
        while(true){
            if(se.contains(n)){
                break;
            }else{
                se.add(n);
                int sum = 0;
                while(n > 0){
                    int cur = n % 10;
                    sum += cur * cur;
                    n = n / 10;
                    //System.out.printf("isHappy(%d) se=%s ret=%b sum=%d\n", n, se, ret, sum);
                }
                
                if(sum==1){
                    ret = true;
                    break;
                }else{
                    n = sum;
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
	}
    static void tbase(int n, boolean expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    boolean ret = o.isHappy(n);
	    System.out.println("n=" + n + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static void t1(){
	    tbase(19, true);
	}
}
