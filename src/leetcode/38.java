/******************************************************************************

38. 外观数列
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
https://leetcode-cn.com/problems/count-and-say/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, String> mp = new HashMap<>();
    public String countAndSay(int n) {
        mp.put(1, "1");
        return chk(n);
    }
    String chk(int n){
        String ret = "";
        //System.out.printf("I N chk(%d) mp=%s\n", n, mp);
        if(mp.containsKey(n)){
            ret = mp.get(n);
        }else{
            String s = chk(n-1);
            int pos = 1;
            int cnt = 1;
            char c0 = s.charAt(0);
            while(pos<s.length()){
                char c = s.charAt(pos);
                if(c0 == c){
                    cnt++;
                }else{
                    ret = ret + cnt + "" + c0;
                    mp.put(n, ret);
                    c0 = c;
                    cnt = 1;
                }
                pos++;
            }
            if(pos>=s.length()){
                ret = ret + cnt + "" + c0;
                mp.put(n, ret);
            }
        }
        //System.out.printf("OUT chk(%d)=%s mp=%s\n", n, ret, mp);
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
		tbase("1", 1);
		tbase("11", 2);
		tbase("21", 3);
        tbase("1211", 4);
        tbase("111221", 5);
        
	}
}
