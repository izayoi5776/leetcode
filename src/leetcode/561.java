/******************************************************************************

数组拆分 I
https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/784/
https://leetcode-cn.com/problems/array-partition-i/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        int ret = 0;
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2){
            ret += nums[i];
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
	    int ret = o.arrayPairSum(p1);
	    System.out.printf("tbase(%s, %s)=%s %s\n", Arrays.toString(p1), ""+expect, ""+ret, (chk(ret,expect)?" OK":" NG"));
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
	    tbase(new int[]{1,4,3,2}, 4);
	}
}
