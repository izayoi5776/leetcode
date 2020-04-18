/******************************************************************************

11. 盛最多水的容器
https://leetcode-cn.com/problems/container-with-most-water/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; j<height.length; j++){
                int n = (j-i) * Math.min(height[i], height[j]);
                if(ret < n){
                    ret = n;
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
    static void tbase(int[] height, int expect){
	    Solution o = new Solution();
	    int ret = o.maxArea(height);
	    System.out.println("height=" + height + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static void t1(){
	    tbase(new int[]{1,8,6,2,5,4,8,3,7}, 49);
	}
}
