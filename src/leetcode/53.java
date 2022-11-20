/******************************************************************************

53. 最大子序和
https://leetcode-cn.com/problems/maximum-subarray/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        int ret = Integer.MIN_VALUE;    // 空数组的情况题目没有定义
        
        if(nums!=null && nums.length>0){
            for(int i=0; i<nums.length; i++){
                long sum = 0L;
                for(int j=i; j<nums.length; j++){
                    sum += nums[j];
                    if(sum>ret){
                        ret = (int)sum;
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
    static void tbase(int[] p1, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.maxSubArray(p1);
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
	    tbase(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);
	    tbase(new int[]{}, 0);
	    tbase(new int[]{0,0,0,0}, 0);
	    tbase(new int[]{-1,-2,-3}, -1);

	}
}
