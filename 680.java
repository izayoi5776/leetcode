/******************************************************************************

680. 验证回文字符串 Ⅱ
https://leetcode-cn.com/problems/valid-palindrome-ii/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public boolean validPalindrome(String s) {
        boolean ret = false;
        ret = chk(s, 0, s.length()-1, false);
        return ret;
    }
    // fix = true when already deleted one char
    boolean chk(String s, int fm, int to, boolean fix){
        boolean ret = true;
        while(fm<to && fm>=0 && to>=0 && fm<s.length() && to<s.length()){
            if(s.charAt(fm)==s.charAt(to)){
                fm++;
                to--;
            }else if(fix){
                ret = false;
                break;
            }else{
                ret = chk(s, fm+1, to, true) ||
                      chk(s, fm, to-1, true);
                break;
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
		tbase(true, "aba");
		tbase(true, "abca");
		tbase(true, "aab");
		tbase(true, "abb");

	}
}
