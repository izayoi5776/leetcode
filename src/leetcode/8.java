/******************************************************************************

8. 字符串转换整数 (atoi)
https://leetcode-cn.com/problems/string-to-integer-atoi/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    String imax = "2147483647";  // 2^31 - 1 
    String imin = "2147483648";  // - 2^31
    public int myAtoi(String str) {
        int ret = 0;

        int maxlen = imax.length(); // 最大长度
        int pos  = 0;               // 数字开始位置
        int pos2 = 0;               // 数字结束位置
        boolean sign = true;        // 符号。true = 正
        if(str.length()<=0){
            // ret = 0;
        }else{
            // skip heading space
            while(pos < str.length() && str.charAt(pos)==' '){
                pos++;
            }
            // sign 
            if(pos < str.length() && str.charAt(pos)=='-'){
                sign = false;
                pos++;
            }else if(pos < str.length() && str.charAt(pos)=='+'){
                pos++;
            }
            // skip heading 0
            while(pos < str.length() && str.charAt(pos)=='0'){
                pos++;
            }
            pos2 = pos;
            while(pos2<str.length()){
                if(pos2 - pos + 1 > maxlen + 1){
                    break; // 数字超长
                }
                char c = str.charAt(pos2);
                if(c >= '0' && c <= '9'){
                    pos2++;
                }else{
                    break;
                }
            }
            String n = str.substring(pos, pos2);
            boolean flg = true; // true means in int range, false mean over. only use 
            if(n.length() == imax.length()){
                if((sign && n.compareTo(imax) >= 0 ) || (!sign && n.compareTo(imin) >= 0 )){
                    flg = false;
                }
            }
            if(n.length() > imax.length() || !flg){
                if(sign){
                    ret = Integer.MAX_VALUE;
                }else{
                    ret = Integer.MIN_VALUE;
                }
            }else{
                try{
                    ret = Integer.valueOf(n);    
                }catch(Exception ex){
                    //
                }
                if(!sign){
                    ret = -1 * ret;
                }
            }

            //System.out.println("str=" + str + " pos=" + pos + " pos2=" + pos2 + " sign=" + sign + " n=" + n + " ret=" + ret + " flg=" + flg);
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
		t4();
		t5();
		t6();
		t7();
		t8();
		t9();
		t10();
		t11();
	}
    static void tbase(String str, int expect){
	    Solution o = new Solution();
	    System.out.println("str=" + str + " ret=" + o.myAtoi(str) + " expect=" + expect);
	}
	static void t1(){	    tbase("42", 42);	}
	static void t2(){	    tbase("   -42", -42);	}
	static void t3(){	    tbase("4193 with words", 4193);	}
	static void t4(){	    tbase("words and 987", 0);	}
	static void t5(){	    tbase("-91283472332", -2147483648);	}
	static void t6(){	    tbase("+1", 1);	}
	static void t7(){	    tbase("  0000000000012345678", 12345678);	}
	static void t8(){	    tbase("+", 0);	}
	static void t9(){	    tbase("-2147483647", -2147483647);	}
	static void t10(){	    tbase("-2147483648", -2147483648);	}
	static void t11(){	    tbase("20000000000000000000", 2147483647);	}


}
