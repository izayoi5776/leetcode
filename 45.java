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
    Map<Integer, Integer> mp = new HashMap<>();
    public int jump(int[] nums) {
        int ret = -1;
        ret = chk(nums, 0);
        return ret;
    }
    private int chk(int[] nums, int pos){
        //System.out.printf("I N chk(%s, %d) mp=%s\n", Arrays.toString(nums), pos, mp);
        int ret = -1;
        if(mp.containsKey(pos)){
            ret = mp.get(pos);
        }else{
            if(nums!=null && pos<nums.length){
                if(pos==nums.length-1){
                    ret = 0;
                }else if(pos + nums[pos] >= nums.length){
                    ret = 1;
                }else{
                    for(int i=1; i<=nums[pos]; i++){
                        int sub = chk(nums, pos+i);
                        if(sub!=-1 &&(ret==-1 || sub + 1 < ret)){
                            ret = sub + 1;
                        }
                        //System.out.printf("MID chk(%s, %d)=%d i=%d mp=%s\n", Arrays.toString(nums), pos, ret, i, mp);
                    }
                }
            }
            mp.put(pos, ret);
        }
        //System.out.printf("OUT chk(%s, %d)=%d mp=%s\n", Arrays.toString(nums), pos, ret, mp);
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
	    tbase(0, new int[]{});
	    tbase(0, new int[]{1});
	    tbase(1, new int[]{3,2,1,0});
	    tbase(2, new int[]{3,0,3,0,0,0});
	}
	
}
