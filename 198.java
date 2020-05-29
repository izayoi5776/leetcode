/******************************************************************************

198. 打家劫舍
https://leetcode-cn.com/problems/house-robber/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    int[] umax;         // 从右边开始，到此处的合计中最大的，条件是此数字被选择
    int[] nmax;         // 从右边开始，到此处的合计中最大的，条件是此数字未被选择
    boolean[] bmax;     // 如果本 umax>nmax，则true
    public int rob(int[] nums) {
        int ret = 0;
        umax = new int[nums.length];
        nmax = new int[nums.length];
        bmax = new boolean[nums.length];
        
        if(nums!=null && nums.length>0){
            int pos = nums.length-1;
            umax[pos] = nums[pos];  // 选择最后一个数字
            nmax[pos] = 0;          // 不选择最后一个数字
            bmax[pos] = true;       // nums是正整数，一定是选择的大
            for(int i=pos-1; i>=0; i--){
                int u = nums[i] + Math.max(nmax[i+1], bmax[i+1]?0:umax[i+1]) ;    // 选择本数字
                int n = Math.max(umax[i+1], nmax[i+1]);   // 不选择本数字
                if(u>n){
                    bmax[i]=true;
                }
                umax[i]=u;
                nmax[i]=n;
                //System.out.printf("rob(%s) umax=%s nmax=%s bmax=%s\n", Arrays.toString(nums), Arrays.toString(umax), Arrays.toString(nmax), Arrays.toString(bmax));
            }
            ret = Math.max(umax[0], nmax[0]);
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
	}
	static void t1(){
		tbase(4, new int[]{1,2,3,1});
		tbase(12, new int[]{2,7,9,3,1});
		tbase(0, new int[]{});
		tbase(1, new int[]{1});
		tbase(1, new int[]{1,1});
		tbase(2, new int[]{1,1,1});
		tbase(2, new int[]{1,1,1,1});
        tbase(30, new int[]{10,9,8,7,6,5,4,3,2,1});
	}
}

