/******************************************************************************

76. 最小覆盖子串
https://leetcode-cn.com/problems/minimum-window-substring/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Character, List<Integer>> mps = new HashMap<>();   // char in s, positions
    Map<Character, Integer> mpt = new HashMap<>();   // char in t, count
    public String minWindow(String s, String t) {
        String ret = "";
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            List<Integer> ls = null;
            if(mps.containsKey(c)){
                ls = mps.get(c);
            }else{
                ls = new ArrayList<Integer>();
                mps.put(c, ls);
            }
            ls.add(i);
        }
        //System.out.printf("minWindow(%s, %s) mps=%s\n", s, t, mps);
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            int cnt = 1 + mpt.getOrDefault(c, 0);
            mpt.put(c, cnt);
        }
        //System.out.printf("minWindow(%s, %s) mpt=%s\n", s, t, mpt);
        
        // chk count
        boolean flg = true;
        for(char c : mpt.keySet()){
            int need = mpt.get(c);
            int real = mps.getOrDefault(c, new ArrayList<Integer>()).size();
            if(real<need){
                flg = false;
                break;
            }
        }
        //System.out.printf("minWindow(%s, %s) flg=%b mpt.ketSet()=%s\n", s, t, flg, mpt.keySet().stream().toArray((sz)->new Character[sz]));
        
        //Map<Character, Integer> mpchk = new HashMap<>();   // char in t, start pos in mps
        if(flg){
            //String loopkeys = mpt.keySet().stream().map(i->""+i).collect(Collectors.joining(""));
            //Character loopkeys[] = mpt.keySet().stream().toArray((sz)->new Character[sz]);
            int n = mpt.keySet().size();
            char[] loopkeys = new char[n];
            int[] loopvars = new int[n];
            int[] mptvals = new int[n];
            int[][] mpsvals = new int[n][];
            int[] looplims = new int[n];
            initLoop(loopkeys, loopvars, mptvals, looplims, mpsvals);

            int[] minpos = new int[2];
            int minlen = Integer.MAX_VALUE;
            do{
                int[] poss = getPos(loopkeys, loopvars, mpsvals, mptvals);
                int len = poss[1] - poss[0] + 1;
                if(len < minlen){
                    minlen = len;
                    minpos = poss;
                }
            }while(chkLoop(loopkeys, loopvars, looplims));
            
            System.out.printf("minWindow(%s, %s)=%s minlen=%d minpos=%s\n", s, t, ret, minlen, Arrays.toString(minpos));
            if(minlen>0 && minlen<=s.length()){
                ret = s.substring(minpos[0], minpos[1]+1);    
            }
        }

        return ret;
    }
    // init loop control var
    void initLoop(char[] loopkeys, int[] loopvars, int[] mptvals, int[] looplims, int[][] mpsvals){
        int i=0;
        for(char c : mpt.keySet()){
            loopkeys[i] = c;
            loopvars[i] = 0;    // not necessary
            mptvals[i]  = mpt.get(c);
            List<Integer> ls = mps.get(c);
            mpsvals[i] = ls.stream().mapToInt(j->j).toArray();
            looplims[i] = ls.size() - mpt.get(c);
            i++;
        }
        //System.out.printf("initLoop()=%s\n", ret);
    }
    // 从现在循环中取得位置信息
    //int[] getPos(Map<Character, Integer> loopvar){
    int[] getPos(char[] loopkeys, int[] loopvars, int[][] mpsvals, int[] mptvals){
        int[] ret = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<loopkeys.length; i++){
            //char c = loopkeys[i];
            int pos  = loopvars[i];
            //List<Integer> ls = mps.get(c);
            int need = mptvals[i];
            for(int j=0; j<need; j++){
                int n = mpsvals[i][pos+j];
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
        //System.out.printf("getPos(%s)=%s\n", loopvar, ret);
        ret[0] = min;
        ret[1] = max;
        return ret;
    }
    // 循环增1操作，结束则返回false
    //boolean chkLoop(Map<Character, Integer> loopvar){
    boolean chkLoop(char[] loopkeys, int[] loopvars, int[] looplims){
        boolean ret = false; // 可以继续循环标志。如果有人增1之后还可以，就设置为true
        //System.out.printf("IN chkLoop(%s, %s, %s)\n", Arrays.toString(loopkeys), Arrays.toString(loopvars), Arrays.toString(looplims));
        for(int i=0; i<loopkeys.length; i++){
            //char c = loopkeys[i];
            int curpos = loopvars[i];
            //int need = mpt.get(c);
            int loopmax = looplims[i];
            if(curpos<loopmax){
                curpos++;
                loopvars[i] = curpos;
                ret=true;
                //System.out.printf("   chkLoop(%s, %s, %s)=%b curpos=%d\n", Arrays.toString(loopkeys), Arrays.toString(loopvars), Arrays.toString(looplims), ret, curpos);
                break;
            }else{
                loopvars[i]=0;
                //System.out.printf("   chkLoop(%s, %s, %s)=%b curpos=%d\n", Arrays.toString(loopkeys), Arrays.toString(loopvars), Arrays.toString(looplims), ret, curpos);
            }
        }
        System.out.printf("   chkLoop(%s, %s, %s)=%b\n", Arrays.toString(loopkeys), Arrays.toString(loopvars), Arrays.toString(looplims), ret);
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
		t2();
		t3();
	}
	static void t1(){
		tbase("BANC", "ADOBECODEBANC", "ABC");
		tbase("", "ADOBECODEBANC", "ABCZ");
	}
	static void t2(){
		tbase("a", "a", "a");   // 1 of 268
		tbase("", "", "");
	}
    /**
     * timeout 45 of 268
     * 初始版，用List循环，并且取得所有pos
     * time:47,581,238,563 ns
     * 位置返回值从List变成固定的int[2]
     * time:17,159,043,433 ns
     * 循环变量变成配列
     * time:10,057,293,651 ns
     * 所有变量都变成配列
     * time:2,278,649,394 ns
     */
	static void t3(){
        tbase("sk_not_what_your_c", "ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country");
    }
}



