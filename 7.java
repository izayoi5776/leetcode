/******************************************************************************

7. 整数反转
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
https://leetcode-cn.com/problems/reverse-integer/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public int reverse(int x) {
        int ret = 0;

        if(x!=0 && x > Integer.MIN_VALUE){
            int minus = 1;
            if(x<0){
                x *= -1;
                minus = -1;
            }
            while(x>0){
                int c = x % 10;
                if(ret==0){
                    ret = c;
                }else{
                    if(ret > Integer.MAX_VALUE / 10){
                        ret = 0;
                        break;
                    }else{
                        ret *= 10;
                        if(ret > Integer.MAX_VALUE - c){
                            ret = 0;
                            break;
                        }else{
                            ret += c;
                            //System.out.printf("reverse(%d) c=%d ret=%d, MAX=%d\n", x, c, ret, Integer.MAX_VALUE);
                        }
                    }
                }
                x /= 10;
            }
            ret *= minus;
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
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static <T> boolean chk(T      youret, T      expect){
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
	static <T> String  s(T n)    {
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
	}
	static void t1(){
	    tbase(321, 123);
	    tbase(-321, -123);
	    tbase(0, Integer.MIN_VALUE);
	    tbase(0, 0);
	    tbase(1, 1);
	    tbase(-1, -1);
	    tbase(0, -0);
	    
	}
	// 1028 of 1032
	static void t2(){
	    tbase(0, 1534236469);
	}
}
