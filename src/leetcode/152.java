/******************************************************************************

152. 乘积最大子数组
https://leetcode-cn.com/problems/maximum-product-subarray/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums!=null && nums.length>0){
            max = nums[0];
            for(int i=0; i<nums.length; i++){
                int mul = 1;
                max = Math.max(max, nums[i]);
                for(int j=i; j<nums.length; j++){
                    mul *= nums[j];
                    max = Math.max(max, nums[j]);
                    max = Math.max(Math.max(max, nums[j]), mul);
                }
                
            }
        }
        
        return max;
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
					long tm1 = System.nanoTime();
					ret = me.invoke(o, args);
					long tm2 = System.nanoTime();
					System.out.printf("tbase(%s", s(expect));
					for(Object ag : args){
						System.out.printf(", %s", s(ag));
					}
					System.out.printf(")=%s time:%,d ns %s\n", s(ret), tm2-tm1, chk(ret, expect)?"OK":"NG");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	static	 boolean chk(String youret, String expect){		return youret.equals(expect);	}
	static	 boolean chk(int	youret, int	expect){		return youret==expect;	}
	static <T> boolean chk(T	  youret, T	  expect){
		boolean ret = false;
		if(youret!=null){
			if(youret instanceof int[]){
				ret = Arrays.equals((int[])youret, (int[])expect);
			}else{
				ret = youret.equals(expect);	
			}
		}else if(youret==expect){
			ret = true;
		}
		return ret;
	}
	static <T> String  s(T n)	{
		if(n instanceof int[]){
			return Arrays.toString((int[])n);
		}else if(n instanceof int[][]){
			return Arrays.deepToString((int[][])n);
		}else{
			return "" + n;	
		}
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
	static void t1(){
		tbase(6, new int[]{2,3,-2,4});
		tbase(0, new int[]{-2,0,-1});
		tbase(6, new int[]{-3,-2,-1});
		tbase(-1, new int[]{-1});
		tbase(2, new int[]{-1, -2});
	}
	// 74 of 184
	static void t2(){
	    tbase(2, new int[]{0, 2});
	}
	// 96 of 184
	static void t3(){
	    tbase(24, new int[]{-2,3,-4});
	}
}




