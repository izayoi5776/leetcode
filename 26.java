/******************************************************************************

删除排序数组中的重复项
https://leetcode-cn.com/explore/featured/card/array-and-string/202/conclusion/795/
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/submissions/

*******************************************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;


class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        if(nums!=null && nums.length>0){
            for(int i=1; i<nums.length; i++){
                if(nums[i]==nums[pos]){
                    // 無視
                }else{
                    nums[++pos]=nums[i];
                }
            }
            
        }
        return pos+1;
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
	static <T> boolean chk(T      youret, T      expect){	    return youret.equals(expect);	}
	static     boolean chk(int[]  youret, int[]  expect){	    return Arrays.equals(youret, expect);	}

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
	    tbase(2, new int[]{1,1,2});
	    tbase(5, new int[]{0,0,1,1,1,2,2,3,3,4});

	}
	
}
