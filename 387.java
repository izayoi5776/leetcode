/******************************************************************************

387. 字符串中的第一个唯一字符
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
https://leetcode-cn.com/problems/first-unique-character-in-a-string/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
    Map<Character, Integer> mp  = new LinkedHashMap<>(); // char, count
    Map<Character, Integer> mp2 = new HashMap<>();       // char, pos
    public int firstUniqChar(String s) {
        int ret = -1;
        
        if(s!=null){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(mp.containsKey(c)){
                    int n = mp.get(c);
                    mp.put(c, n+1);
                }else{
                    mp.put(c, 1);
                    mp2.put(c, i);
                }
            }
            //System.out.printf("firstUniqChar(%s) mp=%s\n", s, mp);

            for(Character c : mp.keySet()){
                if(mp.get(c)==1){
                    ret = mp2.get(c);
                    break;
                }
                //System.out.printf("firstUniqChar(%s)=%d cnt=%d c=%c mp=%s\n", s, ret, cnt, c, mp);
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
	}
	static void t1(){
	    tbase(0, "leetcode");
	    tbase(2, "loveleetcode");
        tbase(-1, "");
        // 37 of 104
        tbase(8, "dddccdbba");
	}
}
