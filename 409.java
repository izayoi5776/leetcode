/******************************************************************************

409. 最长回文串
https://leetcode-cn.com/problems/longest-palindrome/

*******************************************************************************/

class Solution {
    public int longestPalindrome(String s) {
        int[] an = new int[256]; // A..Za..z
        for(char c:s.toCharArray()){
            // A-Z 65-90
            // a-z 97-122
            an[c]++;
            //System.out.println("c=" + c + " int=" + ((int)c));
        }
        boolean flg = false; // 奇数存在ならtrue
        int ret = 0; // 戻り値
        for(char c = 'a'; c<='z'; c++){
            int n = an[c];
            if(n % 2 == 1){
                flg = true;
            }
            ret += n / 2;
        }
       for(char c = 'A'; c<='Z'; c++){
            int n = an[c];
            if(n % 2 == 1){
                flg = true;
            }
            ret += n / 2;
        }
        
        ret *= 2;
        if(flg){
            ret += 1;
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		tbase("abccccdd"); // should be 7
		tbase(""); // should be 0
		tbase("abcd"); // should be 1
	}
	private static void tbase(String s){
	    Solution o = new Solution();
	    
	    System.out.println(o.longestPalindrome(s)); 
	}
}
