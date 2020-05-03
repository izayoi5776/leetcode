/******************************************************************************

移动零
https://leetcode-cn.com/explore/featured/card/array-and-string/202/conclusion/796/
https://leetcode-cn.com/problems/move-zeroes/

*******************************************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums!=null && nums.length>0){
            int cnt = 0;
            
            for(int i=0; i<nums.length-cnt; i++){
                int c = nums[i];
                if(c==0){
                    for(int j=i; j<nums.length-1; j++){
                        nums[j] = nums[j+1];
                    }
                    nums[nums.length-1]=0;
                    cnt++;
                }
                if(nums[i]==0){
                    i--;
                }
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
                    System.out.printf(")=%s %s\n", s(ret), chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static <T> boolean chk(T      youret, T      expect){
	    boolean ret = false;
	    if(youret!=null){
	        ret = youret.equals(expect);
	    }else if(youret==expect){
	        ret = true;
	    }
	    return ret;
	}
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
		t2();
	}
	static void t1(){
	    tbase(null, new int[]{1,2,3,4,5,6,7});
	    tbase(null, new int[]{0,1,0,3,12});
	    tbase(null, new int[]{});
	    tbase(null, new int[]{0,0,0});
	}
	static void t2(){
	    tbase(null, new int[]{0,0,1});
	}

	
}
