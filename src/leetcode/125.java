/******************************************************************************

125. 验证回文串
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
https://leetcode-cn.com/problems/valid-palindrome/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public boolean isPalindrome(String s) {
        boolean ret = true;
        
        if(s!=null && s.length()>0){
            String s3 = s.toLowerCase().replaceAll("[^a-z0-9]", "");
            int p1 = 0;
            int p2 = s3.length()-1;
            while(p1<p2){
                if(s3.charAt(p1++)!=s3.charAt(p2--)){
                    ret = false;
                    break;
                }
            }
            //System.out.printf("isPalindrome(%s) %s \n", s, s3);
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
		tbase(true, "A man, a plan, a canal: Panama");
		tbase(false, "race a car");
		tbase(true, "");
		tbase(true, "a");
		tbase(true, "aa");
		tbase(true, "aaa");
		tbase(true, "a b b a");
		tbase(false, "0P"); // 454 of 476
	}
}
