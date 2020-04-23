/******************************************************************************

面试题 08.11. 硬币
https://leetcode-cn.com/problems/coin-lcci/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int waysToChange(int n) {
        int ret = 0;
        ret = chk25(n);
        return ret;
    }
    int chk25(int n){
        int ret = 0;
        while(n>=0){
            ret += chk10(n);
            n -= 25;
        }
        return ret;
    }

    int chk10(int n){
        int ret = 0;
        while(n>=0){
            ret += chk5(n);
            n -= 10;
        }
        return ret;
    }
    int chk5(int n){
        return n / 5 + 1;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int n, int expect){
	    Solution o = new Solution();
	    int ret = o.waysToChange(n);
	    System.out.println("n=" + n + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}

	static void t1(){
	    tbase(5, 2);
	    tbase(10, 4);
	}
	// case 28/30
	static void t2(){
	    tbase(900750, 2);
	}
}



