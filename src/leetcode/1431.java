/******************************************************************************

1431. 拥有最多糖果的孩子
https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ret = new ArrayList<>();
        if(candies!=null && candies.length>0){
            int max = 0;
            for(int i=0; i<candies.length; i++){
                if(candies[i]>max){
                    max = candies[i];
                }
            }
            for(int i=0; i<candies.length; i++){
                ret.add(candies[i]+extraCandies>=max);
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
	static <T, R> String  s(T n)	{
		if(n instanceof int[]){
			return Arrays.toString((int[])n);
		}else if(n instanceof int[][]){
			return Arrays.deepToString((int[][])n);
		}else if(n instanceof boolean[]){
			return Arrays.toString((boolean[])n);
		}else if(n instanceof boolean[][]){
			return Arrays.deepToString((boolean[][])n);
		}else{
			return "" + n;	
		}
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}
	static void t1(){
		tbase(new boolean[]{true,true,true,false,true}, new int[]{2,3,5,1,3}, 3);
		tbase(new boolean[]{true,false,false,false,false}, new int[]{4,2,1,1,2}, 1);
        tbase(new boolean[]{true,false,true}, new int[]{12,1,12}, 10);
        tbase(new boolean[]{true}, new int[]{1}, 0);
	}
}

