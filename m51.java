/******************************************************************************

面试题51. 数组中的逆序对
https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int reversePairs(int[] nums) {
        int ret = 0;
        
        ret = chk(nums);
        
        return ret;
    }
    // 简单算算看
    int chk(int[] nums){
        int ret = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                ret += nums[i]>nums[j] ? 1 : 0;
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
    static void tbase(int[] nums, int expect){
	    Solution o = new Solution();
	    int ret = o.reversePairs(nums);
	    System.out.println("nums=" + Arrays.toString(nums) + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}

	static void t1(){
	    tbase(new int[]{7,5,6,4}, 5);
	}
}
