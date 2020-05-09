/******************************************************************************

242. 有效的字母异位词
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
https://leetcode-cn.com/problems/valid-anagram/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        boolean ret = true;
        if(s!=null && t!=null && s.length()>0 && t.length()>0){
            if(s.length()!=t.length()){
                ret = false;
            }else{
                Map<Character, Integer> mp = new HashMap<>();   // char, cnt
                for(int i=0; i<s.length(); i++){
                    char c = s.charAt(i);
                    mp.put(c, mp.getOrDefault(c, 0)+1);
                }
    
                for(int i=0; i<t.length(); i++){
                    char c = t.charAt(i);
                    if(mp.containsKey(c)){
                        int cnt = mp.remove(c);
                        cnt--;
                        if(cnt>0){
                            mp.put(c, cnt);
                        }
                    }else{
                        ret = false;
                        break;
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
		tbase(true, "anagram", "nagaram");
		tbase(false, "rat", "cat");
		tbase(true, "", "");
		tbase(true , "a", "a");
		tbase(true , "z", "z");
		tbase(false, "a", "b");
		tbase(false, "a", "ab");
	}
}






