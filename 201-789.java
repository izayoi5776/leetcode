/******************************************************************************

长度最小的子数组
https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/789/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ret = 0;
        
        if(nums!=null){
            for(int i=0; i<nums.length; i++){
                int sum = 0;
                int j = i;
                for(; j<nums.length; j++){
                    sum += nums[j];
                    if(sum>=s){
                        break;
                    }
                }
                if(sum>=s){
                    if(j-i < ret || ret==0){
                        ret = j-i+1;
                    }
                }
            }
        }
        return ret;
    }
}

// -------------------------------------------------------
public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int p1, int[] p2, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.minSubArrayLen(p1, p2);
	    System.out.printf("tbase(%s, %s, %s)=%s %s\n", s(p1), s(p2), s(expect), s(ret), (chk(ret,expect)?" OK":" NG"));
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
	static String s(int n){
	    return "" + n;
	}
	static String s(int[] n){
	    return "" + Arrays.toString(n);
	}
	static void t1(){
	    tbase(0, new int[]{}, 0);
	    tbase(1, new int[]{}, 0);
	    tbase(2, new int[]{1,2,3,4}, 1);
	    tbase(11, new int[]{1,2,3,4}, 0);
	    tbase(10, new int[]{1,2,3,4}, 4);
	    tbase(9, new int[]{1,2,3,4}, 3);
	    tbase(8, new int[]{1,2,3,4}, 3);
	    tbase(7, new int[]{1,2,3,4}, 2);
	    tbase(6, new int[]{1,2,3,4}, 2);
	    tbase(5, new int[]{1,2,3,4}, 2);
	    tbase(4, new int[]{1,2,3,4}, 1);
	    tbase(3, new int[]{1,2,3,4}, 1);
	    tbase(2, new int[]{1,2,3,4}, 1);
	    tbase(0, new int[]{1,2,3,4}, 1);
	    tbase(7, new int[]{2,3,1,2,4,3}, 2);
	    
	}
}
