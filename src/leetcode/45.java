/******************************************************************************

45. 跳跃游戏 II
https://leetcode-cn.com/problems/jump-game-ii/

*******************************************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int jump(int[] nums) {
        int ret = 0;
        if(nums!=null && nums.length>0){
            int pos = 0;
            out:while(pos<nums.length-1){
                if(pos + nums[pos]>=nums.length-1){
                    ret++;
                    break;
                }else{
                    int pos2Max = 0;
                    int posNext = 0;
                    for(int i=pos+1; i<=pos+nums[pos]; i++){
                        if(i>=nums.length){
                            ret++;
                            break;
                        }else{
                            int pos2 = i + nums[i];
                            if(pos2 > pos2Max){
                                pos2Max = pos2;
                                posNext = i;
                            }
                            //System.out.printf("nums=%s pos=%d i=%d pos2Max=%d posNext=%d ret=%d\n", Arrays.toString(nums), pos, i, pos2Max, posNext, ret);
                        }
                    }
                    pos = posNext;
                    ret++;
                }
            }
        }
        return ret;
    }
}

// -------------------------------------------------------
public class Main
{
	// 用反射调用就不需要每次改代码了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    Class cls = Solution.class;
	    Object ret = null;
        for(Method me : cls.getMethods()){
            // 只要Solution中的方法，应该只有一个
            if(me.getDeclaringClass()==cls){
                try{
                    ret = me.invoke(o, args);
                    System.out.printf("tbase(%s", s(expect));
                    for(Object ag : args){
                        System.out.printf(", %s", s(ag));
                    }
                    System.out.printf(")=%s %s\n", s(ret), chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static     boolean chk(int[]  youret, int[]  expect){	    return Arrays.equals(youret, expect);	}
	static <T> boolean chk(T      youret, T      expect){
	    boolean ret = false;
	    if(youret!=null){
	        ret = youret.equals(expect);
	    }else if(youret==expect){
	        ret = true;
	    }
	    return ret;
	}
	static <T> String  s(T n)    {
	    if(n instanceof int[]){
	        return Arrays.toString((int[])n);
	    }else{
    	    return "" + n;	
	    }
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}
	static void t1(){
	    tbase(2, new int[]{2,3,1,1,4});
	    tbase(-1, new int[]{});
	    tbase(0, new int[]{1});
	    tbase(1, new int[]{3,2,1,0});
	    tbase(2, new int[]{3,0,3,0,0,0});
	}
	
}
