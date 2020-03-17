/******************************************************************************

1160. 拼写单词
https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int countCharacters(String[] words, String chars) {
        String[] wkWords = new String[words.length];
        System.arraycopy(words, 0, wkWords, 0, words.length);
        char[] cs = chars.toCharArray();
        //对chars中的每一个文字
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            // 对 words 中的每一个词
            for(int j=0;j<words.length;j++){
                char[] wo = wkWords[j].toCharArray();
                char[] wn = new char[wo.length];
                int wnpos = 0;
                char wkChar = c;
                // 对现在的单词中的每一个字符
                for(int k=0;k<wo.length;k++){
                    if(wo[k]!=wkChar){
                       wn[wnpos] = wo[k];
                       wnpos++;
                    }else{
                       // 一个单词里面 c 只用一次
                       wkChar = '\0'; 
                    }
                    //System.out.println("i=" + i + " j=" + j + " k=" + k + " c=" + c + " wo=" + new String(wo) + " wn=" + new String(wn));
                }
                // 变短的单词存回words准备下次使用
                if(wnpos < wo.length){
                    wkWords[j] = new String(wn).replace("\0", "");
                }
            }
            //System.out.println("i=" + i + " c=" + c + " wkWords=" + Arrays.toString(wkWords));
        }
        // wkWords中长度变为0的，是完全拼写的单词
        int ret = 0;
        for(int i=0; i<words.length;i++){
            //System.out.println("i=" + i + " words[i]=" + words[i] + " wkWords[i]=[" + wkWords[i] + "] wkWords[i].length()=" + wkWords[i].length() + " ret=" + ret);
            if(wkWords[i].length()==0){
                ret += words[i].length();
            }
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t3();
	}
	// should be 6
	private static void t1(){
	    String[] words = {"cat","bt","hat","tree"};
	    String chars = "atach";
	    Solution o = new Solution();
	    int n = o.countCharacters(words, chars);
        System.out.println("words=" + Arrays.toString(words) + " chars=" + chars + " ret=" + n);
	}
	private static void t2(){
	    char[] sa = new char[4];
	    sa[0] = 'z';
	    sa[1] = 0;
	    String s = String.valueOf(sa);
	    String s2 = s.replace("\0", "");
	    System.out.println("s=" + s + " s.length()=" + s.length() + " s2.length()=" + s2.length());
	    //for(char c:sa){
	        //System.out.println("c=" + c);
	    //}
	}
	// should be 10
	private static void t3(){
	    String[] words = {"hello","world","leetcode"};
	    String chars = "welldonehoneyr";
	    Solution o = new Solution();
	    int n = o.countCharacters(words, chars);
        System.out.println("words=" + Arrays.toString(words) + " chars=" + chars + " ret=" + n);
	}
}




