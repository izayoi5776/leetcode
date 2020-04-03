/******************************************************************************

42. 接雨水
https://leetcode-cn.com/problems/trapping-rain-water/

*******************************************************************************/
import java.util.Arrays;

/***
 * 思路
 * 从左至右，从下至上扫描空格
 * 从空格开始向左右扫描看有没有墙 
 */
class Solution {
    public int trap(int[] height) {
        int ret = 0;
        
        // left = 0
        // right = height.length
        // 找第二高
        int max = 0;
        int sec = 0;
        for(int i=0;i<height.length;i++){
            if(height[i]>sec){
                sec = height[i];
                if(sec>max){
                    int t = max;
                    max = sec;
                    sec = t;
                }
            }
        }
        
        for(int i=1; i<=sec; i++){              // 在所有高度上循环
            for(int j=0; j<height.length; j++){     // 对所有位置循环
                if(height[j]<i){
                    // 此地点高度 < 搜索高度
                    // 向左找
                    boolean left = false;
                    for(int k=j-1; k>=0; k--){
                        if(height[k]>=i){
                            left = true;
                        }
                    }
                    // 向右找
                    boolean right = false;
                    for(int k=j+1; left && k<height.length; k++){
                        if(height[k]>=i){
                            right = true;
                        }
                    }
                    if(left && right){
                        ret++;
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
	}
    static void tbase(int[] height, int expect){
	    Solution o = new Solution();
	    System.out.println("height=" + Arrays.toString(height) + " ret=" + o.trap(height) + " expect=" + expect);
	}
	static void t1(){
	    tbase(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
	}
}
