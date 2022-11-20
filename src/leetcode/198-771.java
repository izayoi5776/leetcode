/******************************************************************************

至少是其他数字两倍的最大数
https://leetcode-cn.com/explore/featured/card/array-and-string/198/introduction-to-array/771/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // nums 的长度范围在[1, 50].
    // 每个 nums[i] 的整数范围在 [0, 100].
    public int dominantIndex(int[] nums) {
        int ret = -1;
        int posMax = -1;
        int posSec = -1;
        
        if(nums!=null && nums.length>0){
            if(nums.length==1){
                ret = 0;
            }else{
                for(int i=0; i<nums.length; i++){
                    if(posMax==-1 || nums[i]>nums[posMax]){
                        posSec = posMax;
                        posMax = i;
                    }else if(posSec==-1 || nums[i]>nums[posSec]){
                        posSec = i;
                    }
                }
                
                if(posSec!=-1){
                    if(nums[posMax] >= 2 * nums[posSec]){
                        if(nums[posMax]!=0){
                            ret = posMax;
                        }
                    }
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
		t2();
	}
    static void tbase(int[] n, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.dominantIndex(n);
	    System.out.println("n=" + Arrays.toString(n) + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
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
	    tbase(new int[]{3, 6, 1, 0}, 1);
	    tbase(new int[]{1, 2, 3, 4}, -1);
	}
	static void t2(){
	    tbase(new int[]{}, -1);
	    tbase(new int[]{0}, 0);
	    tbase(new int[]{1}, 0);
	    tbase(new int[]{0,0}, -1);
	    tbase(new int[]{1,1}, -1);
	    tbase(new int[]{0,1}, 1);
	    tbase(new int[]{1,0}, 0);
	    tbase(new int[]{0,0,0}, -1);
	    tbase(new int[]{0,0,1}, 2);
	    tbase(new int[]{0,1,0}, 1);
	    tbase(new int[]{0,1,1}, -1);
	    tbase(new int[]{1,0,0}, 0);
	    tbase(new int[]{1,0,1}, -1);
	    tbase(new int[]{1,1,0}, -1);
	    tbase(new int[]{1,1,1}, -1);
	    
	    tbase(new int[]{1,1,1,2}, 3);
	    tbase(new int[]{1,0,0,0}, 0);
	}
}
