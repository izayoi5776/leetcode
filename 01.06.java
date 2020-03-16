/******************************************************************************

面试题 01.06. 字符串压缩
https://leetcode-cn.com/problems/compress-string-lcci/

*******************************************************************************/

class Solution {
    public String compressString(String S) {
        String ret = "";
        if(S.length()<=1){
            return S;
        }
        char[] ca = S.toCharArray();
        char c = ca[0];
        int n = 1;
        for(int i=1;i<ca.length;i++){
            if(c==ca[i]){
                n++;
            }else{
                ret = ret + c + n;
                c = ca[i];
                n = 1;
            }
        }
        ret = ret + c + n;
        
        if(ret.length() < S.length()){
            return ret;
        }else{
            return S;
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		t2();
	}
	private static void t1(){
	    String s = "aabcccccaaa";
	    String c = "a2b1c5a3";
	    Solution o = new Solution();
	    String ret = o.compressString(s);
	    System.out.println("len(" + s + ")=" + s.length() + " len(" + ret + ")=" + ret.length() + " " + c.equals(ret));
	}
	private static void t2(){
	    String s = "abbccd";
	    String c = "abbccd";
	    Solution o = new Solution();
	    String ret = o.compressString(s);
	    System.out.println("len(" + s + ")=" + s.length() + " len(" + ret + ")=" + ret.length() + " " + c.equals(ret));
	    
	}
}

