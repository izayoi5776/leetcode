/******************************************************************************

旋转数组
https://leetcode-cn.com/explore/featured/card/array-and-string/202/conclusion/791/
https://leetcode-cn.com/problems/rotate-array/submissions/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums!=null && nums.length>0 && k>0){
            k = k % nums.length;
            if(k>0){
                int tmp = nums[nums.length-1];
                for(int i=nums.length-1; i>0; i--){
                    nums[i] = nums[i-1];
                }
                nums[0] = tmp;
                rotate(nums, k-1);
            }
        }
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
                    System.out.printf(")=%s\n", s(ret));
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
	    tbase(null, new int[]{1,2,3,4,5,6,7}, 3);
	    tbase(null, new int[]{1,2}, 2);

	}
	
}
