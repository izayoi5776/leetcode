/******************************************************************************

最长公共前缀
https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/781/
https://leetcode-cn.com/problems/longest-common-prefix/submissions/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        int pos = 0;
        if(strs!=null && strs.length>0 && strs[0].length()>0){
            out:while(pos < strs[0].length()){
                char c = strs[0].charAt(pos);
                for(int i=1; i<strs.length; i++){
                    if(strs[i].length()<pos+1 || strs[i].charAt(pos)!=c){
                        break out;
                    }
                }
                pos++;
            }
            ret = strs[0].substring(0, pos);
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(String[] p1, String expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    String ret = o.longestCommonPrefix(p1);
	    System.out.printf("tbase(%s, %s)=%s %s\n", Arrays.toString(p1), ""+expect, ""+ret, (chk(ret,expect)?" OK":" NG"));
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
	    tbase(new String[]{"flower","flow","flight"}, "fl");
	    tbase(new String[]{"dog","racecar","car"}, "");
	    tbase(new String[]{""}, ""); // 3 of 118
	    tbase(new String[]{"abc", ""}, "");
	    tbase(new String[]{"c", "c"}, "c"); // 8 of 118
	}
}



