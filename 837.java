/******************************************************************************

837. 新21点
https://leetcode-cn.com/problems/new-21-game/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public double new21Game(int N, int K, int W) {
        double ret = 0.0;
        
        int t = K - K / W;
        double up = t * (K + W - 1 - N);
        double dn = 1.0 * W * t;
        for(int i=1; i<=t && K-i-1>0; i++){
            dn += P(K-i-1, i);
        }

        ret = 1 - up / dn;        
        System.out.printf("N=%d K=%d W=%d t=%d up=%f dn=%f ret=%f\n", N, K, W, t, up, dn, ret);
        return ret;
    }
    // 排列数计算
    double P(int n, int k){
        double ret = 1.0;
        if(n<k){
            int t=k;
            k = n;
            n = t;
        }
        for(int i=n; i>n-k; i--){
            ret *= i;
        }
        System.out.printf("P(%d %d)=%2.0f\n", n, k, ret);
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
		tbase(1.0, 10, 1, 10);
		tbase(0.6, 6, 1, 10);
		tbase(1.0 - 1.0/19.0, 10, 2, 10);
		tbase(0.73278, 21, 17, 10);
	}
}
