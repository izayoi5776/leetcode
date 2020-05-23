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
import java.util.Collections;

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
        //System.out.printf("minWindow(%s, %s) flg=%b\n", s, t, flg);
        
        Map<Character, Integer> mpchk = new HashMap<>();   // char in t, start pos in mps
        if(flg){
            Map<Character, Integer> loopvar = initLoop(); // loop contral. key=char in t, val=start pos in mps
            List<Integer> minpos = null;
            int minlen = s.length()+1;
            do{
                List<Integer> poss = getPos(loopvar);
                int len = getStrLen2(poss);
                if(len < minlen){
                    minlen = len;
                    minpos = poss;
                }
            }while(chkLoop(loopvar));
            
            //System.out.printf("minWindow(%s, %s)=%s minlen=%d minpos=%s\n", s, t, ret, minlen, minpos);
            if(minpos.size()>0){
                ret = s.substring(minpos.get(0), minpos.get(0)+minlen);    
            }
            
        }

        return ret;
    }
    // init loop control var
    Map<Character, Integer> initLoop(){
        Map<Character, Integer> ret = new HashMap<>();
        for(char c : mpt.keySet()){
            ret.put(c, 0);
        }
        //System.out.printf("initLoop()=%s\n", ret);
        return ret;
    }
    // 从现在循环中取得位置信息
    List<Integer> getPos(Map<Character, Integer> loopvar){
        List<Integer> ret = new ArrayList<>();
        for(char c : loopvar.keySet()){
            int pos  = loopvar.get(c);
            List<Integer> ls = mps.get(c);
            int need = mpt.get(c);
            for(int i=0; i<need; i++){
                ret.add(ls.get(pos+i));
            }
        }
        //System.out.printf("getPos(%s)=%s\n", loopvar, ret);
        return ret;
    }
    // 循环增1操作，结束则返回false
    boolean chkLoop(Map<Character, Integer> loopvar){
        boolean ret = false; // 可以继续循环标志。如果有人增1之后还可以，就设置为true
        //System.out.printf("IN chkLoop(%s)=%b\n", loopvar, ret);
        for(char c : loopvar.keySet()){
            int curpos = loopvar.get(c);
            int need = mpt.get(c);
            int loopmax = mps.get(c).size() - need;
            if(curpos<loopmax){
                curpos++;
                loopvar.put(c, curpos);
                ret=true;
                //System.out.printf("   chkLoop(%s)=%b\n", loopvar, ret);
                break;
            }else{
                curpos=0;
                loopvar.put(c, curpos);
                //System.out.printf("   chkLoop(%s)=%b\n", loopvar, ret);
            }
        }
        return ret;
    }
    // 返回子串长度
    int getStrLen(List<Integer> pos){
        Integer[] a = new Integer[pos.size()];
        pos.toArray(a);
        Arrays.sort(a);
        int min = a[0];
        int max = a[a.length-1];
        int ret = max - min + 1;
        //System.out.printf("getStrLen(%s)=%d a=%s\n", pos, ret, Arrays.toString(a));
        return ret;
    }
    int getStrLen2(List<Integer> pos){
        int ret = 0;
        if(pos!=null && pos.size()>0){
            Collections.sort(pos);
            int min = pos.get(0);
            int max = pos.get(pos.size()-1);
            ret = max - min + 1;
        }
        //System.out.printf("getStrLen2(%s)=%d\n", pos, ret);
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
	// timeout
	static void t3(){
        tbase("sk_not_what_your_c", "ask_not_what_your_country_can_do_for_you_ask_what_you_can_do_for_your_country", "ask_country");
    }
}



