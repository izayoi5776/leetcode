/******************************************************************************

面试题56 - I. 数组中数字出现的次数
https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] singleNumbers(int[] nums) {
        return chk1(nums);
    }
    // 想不出时间复杂度 On，先写个On^2的看看
    int[] chk1(int[] nums){
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            if(st.contains(cur)){
                st.remove(cur);
            }else{
                st.add(cur);
            }
        }
        
        int[] ret = new int[st.size()];
        int pos = 0;
        for(Integer i:st){
            ret[pos++] = i;
        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[] n, int[] expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int[] ret = o.singleNumbers(n);
	    System.out.println("n=" + Arrays.toString(n) + " ret=" + Arrays.toString(ret) + " expect=" + Arrays.toString(expect) + (chk(ret,expect)?" OK":" NG"));
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

	static void t1(){
	    tbase(new int[]{4,1,4,6}, new int[]{1,6});
	    tbase(new int[]{1,2,10,4,1,4,3,3}, new int[]{2,10});
	}
}

