/******************************************************************************

836. 矩形重叠
https://leetcode-cn.com/problems/rectangle-overlap/

*******************************************************************************/

import java.util.Arrays;

class Solution {
    // true = 重叠
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 矩形以列表 [x1, y1, x2, y2] 的形式表示，
        // 其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
        int alb_x = rec1[0];    // rec a left below x
        int alb_y = rec1[1];
        int aur_x = rec1[2];
        int aur_y = rec1[3];
        
        int blb_x = rec2[0];    // rec b left below x
        int blb_y = rec2[1];
        int bur_x = rec2[2];
        int bur_y = rec2[3];
        
        boolean ret = true;
        if(   blb_x >= aur_x || blb_y >= aur_y    // 第二矩形的左下角 大于 第一矩形的右上角
           || alb_x >= bur_x || alb_y >= bur_y    // 或者对调
        ){
            ret = false;
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t2();
	}
	private static void t1(){
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        Solution o = new Solution();
        System.out.println("re1=" + Arrays.toString(rec1) + " rec2=" 
            + Arrays.toString(rec2) 
            + " ret=" + o.isRectangleOverlap(rec1, rec2)); // should be true
	}
    private static void t2(){
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        Solution o = new Solution();
        System.out.println("re1=" + Arrays.toString(rec1) + " rec2=" 
            + Arrays.toString(rec2) 
            + " ret=" + o.isRectangleOverlap(rec1, rec2)); // should be false
	}
}
