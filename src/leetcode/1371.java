/******************************************************************************

1371. 每个元音包含偶数次的最长子字符串
https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    String as = "aeiou";
    public int findTheLongestSubstring(String s) {
        int ret = 0;
        
        for(int i=0; i<s.length()-ret; i++){
            boolean[] ab = new boolean[]{true, true, true, true, true};   // aeiou true表示偶数个
            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                addChar(ab, c);
                if(even(ab)){
                    int cnt = j-i+1;
                    if(cnt>ret){
                        ret = cnt;
                    }
                }
                //System.out.printf("s=%s i=%d j=%d c=%c ret=%d ab=%s\n", s, i, j, c, ret, Arrays.toString(ab));
            }
        }
        return ret;
    }
    // is Vowel; 
    // found == 0~4
    // -1 if not found
    int vowel(char c){
        int i = as.length()-1;
        while(i>=0 && as.charAt(i)!=c){
            i--;
        }
        return i;
    }
    boolean even(boolean[] ab){
        boolean ret = true;
        for(int i=0; i<ab.length; i++){
            ret &= ab[i];
        }
        return ret;
    }
    // 把字符 c 计算进去ab
    boolean addChar(boolean[] ab, char c){
        boolean ret = false;
        int v = vowel(c);
        if(v!=-1){
            ab[v] = !ab[v];
            ret = true;
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
		tbase(13, "eleetminicoworoep");
		tbase(5, "leetcodeisgreat");
		tbase(6,"bcbcbc");

	}
}
