/******************************************************************************

实现 strStr()
https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/780/
https://leetcode-cn.com/problems/implement-strstr/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {
        int ret = -1;
        if(haystack!=null && needle!=null){
            if(needle.length()==0){
                ret=0;
            }else{
                int pos1 = 0;
                int pos2 = 0;
                while(pos1<haystack.length()){
                    //System.out.printf("strStr(%s, %s) pos(%d, %d) s(%s, %s)\n", haystack, needle, pos1, pos2, haystack.substring(pos1), needle.substring(pos2));
                    if(haystack.charAt(pos1)==needle.charAt(pos2)){
                        if(pos2==needle.length()-1){
                            ret = pos1-pos2;
                            break;
                        }
                        pos2++;
                        pos1++;
                    }else{
                        if(pos2!=0){
                            pos1 -= pos2;
                            pos2=0;
                        }
                        pos1++;
                    }
                }
            }
        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		//t1();
		t2();
	}
    static void tbase(String p1, String p2, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.strStr(p1, p2);
	    System.out.printf("tbase(%s, %s, %s)=%s %s\n", p1, p2, ""+expect, ""+ret, (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static void t1(){
	    tbase("hello", "ll", 2);
	    tbase("aaaaa", "bba", -1);
	    tbase("aaaaa", "", 0);
	    tbase("", "", 0);
	    tbase("", "abc", -1);
	    tbase(null, "", -1);
	    tbase(null, null, -1);
	}
    static void t2(){	
	    tbase("mississippi", "issip", 4); // 67 of 74
    }
}
