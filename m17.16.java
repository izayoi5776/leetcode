/******************************************************************************

面试题 17.16. 按摩师
https://leetcode-cn.com/problems/the-masseuse-lcci/

*******************************************************************************/

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    public int massage(int[] nums) {
        return chk(nums, 0);
    }
    public int chk(int[] nums, int start) {
        int ret = 0;
        if(nums==null || nums.length==0 || start >= nums.length){
            // ret = 0;
        }else if(mp.containsKey(start)){
            ret = mp.get(start);
        }else{
            int r_use    = chk(nums, start+2);  // 答案中使用 nums[start] 项时，要跳过一项
            int r_no_use = chk(nums, start+1);  // 答案中不使用 nums[start] 项时，则可以使用邻接的下一项
            ret = Math.max(nums[start] + r_use, r_no_use);
            mp.put(start, ret);
        }
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
	}
	static void tbase(int[] nums, int res){
	    Solution o = new Solution();
	    System.out.println("nums=" + Arrays.toString(nums) + " respec=" + res + " ret=" + o.massage(nums));
	}
	static void t1(){
	    int[] nums = {1,2,3,1};
	    tbase(nums, 4);
	}
	static void t2(){
	    int[] nums = {2,7,9,3,1};
	    tbase(nums, 12);
	}
	static void t3(){
	    int[] nums = {2,1,4,5,3,1,1,3};
	    tbase(nums, 12);
	}
	static void t4(){
	    int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
	    tbase(nums, 4173); // timeout
	}
}





