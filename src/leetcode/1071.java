/******************************************************************************

1071. 字符串的最大公因子
https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/

*******************************************************************************/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int ret = 0;
        int l1 = str1.length(); // 文字列１長さ
        int l2 = str2.length(); // 文字列２長さ
        for(int i=1; i<=Math.min(l1, l2); i++){
            // 長さが整除できる時のみ
            if(l1 % i == 0 && l2 % i == 0){
                //System.out.println("str1(" + l1 + ")=" + str1 + " str2(" + l2 + ")=" + str2 + " i=" + i);
                // 両方整除できるなら値を残す
                String s2 = str1.substring(0, i);
                if(chk(str1, s2) && chk(str2, s2)){
                    ret = i;
                }
            }
            
        }
        //System.out.println("str1=" + str1 + " str2=" + str2 + " ret=" + ret);
        return str1.substring(0, ret);
    }
    // s1 可以被 s2 整除则true
    private boolean chk(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        boolean ret = false;
        if(l1 < l2){
            //return false;
        }else if(l1 == l2){
            if(s1.equals(s2)){
                ret = true;
            }
        }else{
            // l1 > l2
            //System.out.println("s1.startsWith(s2)=" + s1.startsWith(s2) + " s1.substring(l2)=" + s1.substring(l2));
            return s1.startsWith(s2) && chk(s1.substring(l2), s2);
        }
        //System.out.println("s1=" + s1 + " s2=" + s2 + " ret=" + ret);
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
	    Solution o = new Solution();
	    
		//System.out.println(o.gcdOfStrings("AAAA", "AA")); // should be AA
		//System.out.println(o.gcdOfStrings("ABAB", "AB")); // should be AB
		System.out.println(o.gcdOfStrings("ABCABC", "ABC")); // should be ABC
		//System.out.println(o.gcdOfStrings("LEET", "CODE")); // should be null
	}
}


