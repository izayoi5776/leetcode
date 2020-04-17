/******************************************************************************

55. 跳跃游戏
https://leetcode-cn.com/problems/jump-game/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        boolean ret = true;
        // 思路：找0，只有0才能阻止前进
        // 向前倒推，找离开0，值大于距离的
        if(nums.length>1){
            for(int i=0; i<nums.length; i++){
                ret = true;
                if(nums[i]==0){
                    boolean flg = false; // 对i位置的0，找到可以跳过的数字为true
                    for(int j=i-1; j>=0; j--){
                        if(nums[j]>i-j){
                            flg = true;
                            break;
                        // 最后一个特殊处理
                        }else if(i==nums.length-1 && nums[j]>=i-j){
                            flg = true;
                            break;
                        }
                    }
                    if(flg){
                        // 找到，就算了，下一个
                    }else{
                        // 没找到，就是跳不过
                        ret = false;
                        break;
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
		t3();
		t4();
	}
    static void tbase(int[] nums, boolean expect){
	    Solution o = new Solution();
	    boolean ret = o.canJump(nums);
	    System.out.println("nums" + Arrays.toString(nums) + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(boolean youret, boolean expect){
	    return youret==expect;
	}
	static void t1(){
	    tbase(new int[]{2,3,1,1,4}, true);
	}
	static void t2(){
	    tbase(new int[]{3,2,1,0,4}, false);
	}
	// 1个时候这么定义
	static void t3(){
	    tbase(new int[]{0}, true);
	}
	// 最后是0
	static void t4(){
	    tbase(new int[]{2,0,0}, true);
	}
}
