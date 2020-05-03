/******************************************************************************

反转字符串中的单词 III
https://leetcode-cn.com/explore/featured/card/array-and-string/202/conclusion/794/
https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public String reverseWords(String s) {
        String ret = "";
        if(s!=null && s.length()>0){
            char[] ss = new char[s.length()];
            int posSS = 0;
            int posS = 0;
            while(posS<s.length()){
                if(s.charAt(posS)==' '){
                    posSS = copyReverse(s, ss, posSS, posS-1);
                    ss[posSS++] = ' ';
                }
                posS++;
            }
            posSS = copyReverse(s, ss, posSS, s.length()-1);
            ret = new String(ss);
        }
        return ret;
    }
    int copyReverse(String s, char[] ss, int posSS, int posS){
        //System.out.printf("I N copyReverse(%s, %s, %d, %d)\n", s, Arrays.toString(ss), posSS, posS);
        while(posS>=0 && posSS<ss.length && s.charAt(posS)!=' '){
            ss[posSS++] = s.charAt(posS--);
        }
        //System.out.printf("OUT copyReverse(%s, %s, %d, %d)\n", s, Arrays.toString(ss), posSS, posS);
        return posSS;
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
                    ret = me.invoke(o, args);
                    System.out.printf("tbase(%s", s(expect));
                    for(Object ag : args){
                        System.out.printf(", %s", s(ag));
                    }
                    System.out.printf(")=%s %s\n", s(ret), chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static <T> boolean chk(T      youret, T      expect){	    return youret.equals(expect);	}
	static     boolean chk(int[]  youret, int[]  expect){	    return Arrays.equals(youret, expect);	}

	static <T> String  s(T n)    {
	    if(n instanceof int[]){
	        return Arrays.toString((int[])n);
	    }else{
    	    return "" + n;	
	    }
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}	
	static void t1(){
	    tbase("cba fed", "abc def");
	    tbase("s'teL ekat edoCteeL tsetnoc", "Let's take LeetCode contest");
	}
	
}
