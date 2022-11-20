/******************************************************************************

存在重复元素
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
https://leetcode-cn.com/problems/contains-duplicate/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean ret = false;
        Set<Integer> se = new HashSet<>();
        if(nums!=null && nums.length>0){
            for(int i=0;i<nums.length;i++){
                se.add(nums[i]);
            }
            if(nums.length!=se.size()){
                ret = true;
            }
        }
        return ret;
    }
    private boolean containsDuplicate1(int[] nums) {
        boolean ret = false;
        if(nums!=null && nums.length>0){
            out:for(int i=0; i<nums.length-1; i++){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[i]==nums[j]){
                        ret = true;
                        break out;
                    }
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
	    tbase(true, new int[]{1,2,3,1});
	    tbase(false, new int[]{1,2,3,4});
	    tbase(true, new int[]{1,1,1,3,3,4,3,2,4,2});
	    tbase(false, new int[]{});
	    tbase(true, new int[]{1,2,3,4,5,6,7,8,9,0,2});

	}
}
