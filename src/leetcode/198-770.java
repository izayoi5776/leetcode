/******************************************************************************

寻找数组的中心索引
https://leetcode-cn.com/explore/featured/card/array-and-string/198/introduction-to-array/770/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int pivotIndex(int[] nums) {
        int ret = -1;
        if(nums!=null && nums.length>0){
            if(nums.length==1){
                ret = 0;
            }else{
                // 这里 length >= 2
                int sumL = 0;
                int sumR = 0;
                int pos = 0;
                for(int i=pos+1; i<nums.length; i++){
                    sumR += nums[i];
                }
                
                while(pos<nums.length){
                    System.out.printf("pivotIndex(%s) pos=(%d) sum=(%d, %d)\n", Arrays.toString(nums), pos, sumL, sumR);
                    if(sumL==sumR){
                        ret = pos;
                        break;
                    }else{
                        pos++;
                        if(pos<nums.length){
                            sumL += nums[pos-1];
                            sumR -= nums[pos];
                        }
                    }
                }
            }
        }
        return ret;
    }
    // 错，负数的时候不适用
    public int pivotIndex1(int[] nums) {
        int ret = -1;
        
        if(nums!=null && nums.length>0){
            if(nums.length==1){
                ret = 0;
            }else{
                // 这里 length >= 2
                int posL = 0;
                int posR = nums.length-1;
                int sumL = nums[posL];
                int sumR = nums[posR];
                while(posL<posR){
                    if(posL==posR-2 && sumL==sumR){
                        ret = posL+1;
                        break;
                    }else{
                        if(sumL<sumR){  // 这里错，负数时候不适用
                            posL++;
                            sumL += nums[posL];
                        }else{
                            posR--;
                            sumR += nums[posR];
                        }
                    }
                    System.out.printf("pivotIndex(%s) pos=(%d, %d) sum=(%d, %d)\n", Arrays.toString(nums), posL, posR, sumL, sumR);
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
    static void tbase(int[] n, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.pivotIndex(n);
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

	static void t1(){
	    tbase(new int[]{1, 7, 3, 6, 5, 6}, 3);
	    tbase(new int[]{1, 2, 3}, -1);
	    tbase(new int[]{-1,-1,-1,-1,-1,0}, 2);
	    tbase(new int[]{-1,-1,0,1,1,0}, 5);
	}
}
