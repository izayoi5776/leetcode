/******************************************************************************

151. 翻转字符串里的单词
https://leetcode-cn.com/problems/reverse-words-in-a-string/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        String ret = "";
        String[] sa = s.split(" +");
        for(int i=sa.length-1; i>=0; i--){
            if(sa[i].length()>0){
                if(ret.length()>0){
                    ret += " ";
                }
                ret += sa[i];    
            }
            //System.out.println("i=" + i + " sa=" + Arrays.toString(sa) + " ret=" + ret);
        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
    static void tbase(String s, String expect){
	    Solution o = new Solution();
	    String ret = o.reverseWords(s);
	    System.out.println("s" + s + " ret=[" + ret + "] expect=[" + expect + "]"+ (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static void t1(){
	    tbase("the sky is blue", "blue is sky the");
	}
	static void t2(){
	    tbase("  hello world!  ", "world! hello");
	}
	static void t3(){
	    tbase("a good   example", "example good a");
	}
}


