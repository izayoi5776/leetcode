/******************************************************************************

3. 无重复字符的最长子串
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        for(int i=0; i<s.length()-ret; i++){
            int len = chk(s, i);
            if(len>ret){
                ret = len;
            }
        }
        return ret;
    }
    int chk(String s, int pos){
        int ret = 0;
        if(pos<s.length()){
            ret = 1;
        }
        out:for(int i=pos+1; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=pos; j<i; j++){
                if(c==s.charAt(j)){
                    break out;
                }
            }
            ret++;
        }
        //System.out.printf("chk(%s, %d)=%d sub=%s\n", s, pos, ret, s.substring(pos, pos+ret));
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(String s, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.lengthOfLongestSubstring(s);
	    System.out.println("n=" + s + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
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
	    tbase("abcabcbb", 3);
	    tbase("bbbbb", 1);
	    tbase("pwwkew", 3);
	    tbase("", 0);
	    tbase("a", 1);
	    tbase(" ", 1); // 879 of 987
	    
	}
}

