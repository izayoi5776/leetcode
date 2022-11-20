/******************************************************************************

最大连续1的个数
https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/788/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int cnt = 0;
        if(nums!=null){
            for(int i=0; i<nums.length; i++){
                if(nums[i]==1){
                    cnt++;
                }else{
                    if(cnt>ret){
                        ret = cnt;
                    }
                    cnt = 0;
                }
            }
            if(cnt>ret){
                ret = cnt;
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
    static void tbase(int[] p1, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.findMaxConsecutiveOnes(p1);
	    System.out.printf("tbase(%s, %s)=%s %s\n", s(p1), s(expect), s(ret), (chk(ret,expect)?" OK":" NG"));
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
	    tbase(new int[]{}, 0);
	    tbase(new int[]{0}, 0);
	    tbase(new int[]{0,0,0}, 0);
	    tbase(new int[]{1}, 1);
	    tbase(new int[]{1,1}, 2);
	    tbase(new int[]{1,1,1}, 3);
	    tbase(new int[]{1,1,0,1,1,1}, 3);
	    
	}
}
