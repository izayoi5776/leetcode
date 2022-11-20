/******************************************************************************

394. 字符串解码
https://leetcode-cn.com/problems/decode-string/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isNum(c)){
                i = chk(s, i, sb)-1;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    // 返回 [0] 前置的正数
    //      [1] 下一个字符的起始位置
    int[] getInt(String s, int pos){
        int N = 0;
        int to = pos;
        while(to<s.length()){
            char c = s.charAt(to);
            if(isNum(c)){
                to++;
            }else{
                break;
            }
        }
        if(to>pos){
            N = Integer.valueOf(s.substring(pos, to));
        }
        int[] ret = new int[2];
        ret[0] = N;
        ret[1] = to;
        return ret;
    }

    boolean isNum(char c){
        boolean ret = false;
        if(c>='0' && c<='9'){
            ret = true;
        }
        return ret;
    }
    // 从指定位置开始，返回需要重复的子串
    int chk(String s, int start, StringBuilder sb){
        StringBuilder sb2 = new StringBuilder();
        int[] ai = getInt(s, start);
        int N = ai[0];
        int i = ai[1];
        i++; // skip [
        for(; i<s.length(); i++){
            char c = s.charAt(i);
            if(isNum(c)){
                i = chk(s, i, sb2) - 1;
            }else if(c==']'){
                i++;
                break;
            }else{
                sb2.append(c);
            }
        }
        String ss = multiString(N, sb2.toString());
        sb.append(ss);
        return i;
    }
    String multiString(int n, String s){
        StringBuilder sb = new StringBuilder((int)(n * s.length()));
        while(n-->0){
            sb.append(s);
        }
        return sb.toString();
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
        t2();
	}
	static void t1(){
		tbase("aaabcbc", "3[a]2[bc]");
		tbase("accaccacc", "3[a2[c]]");
		tbase("abcabccdcdcdef", "2[abc]3[cd]ef");
        tbase("", "");
        tbase("a", "a");
        tbase("abc", "a1[b]c");
        tbase("aaaaaaaaaaaaaaaaaaaaaaaa", "1[2[3[4[a]]]]");
    }
    // 23 of 29
    static void t2(){
        tbase("aaabFFFFcbFFFFc", "3[a]2[b4[F]c]");
    }
}
