/******************************************************************************

72. 编辑距离
https://leetcode-cn.com/problems/edit-distance/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<String, Integer> mp = new HashMap<String, Integer>();
    public int minDistance(String word1, String word2) {
        int ret = 0;
        ret = chk(word1, word2);
        return ret;
    }
    /**
     * 重复的，同序的最长字串
     * w1, w2 非null，非空
     */
    int chk(String w1, String w2){
        int ret = 0;
        int sub1 = 0;
        int sub2 = 0;
        int sub3 = 0;
        int sub4 = 0;
        int sub5 = 0;
        if(w1==null && w2==null){ // 两串都空返回0，这里特别除去null的可能性为了下面方便
            // ret = 0;
        }else if( (w1==null || w1.length()==0) && (w2==null || w2.length()==0) ){   // 两串都空返回0
            // ret = 0;
        }else if(w2.length()==0){   // 串2是空，则串1每个字符都删除，用w1.length()次
            ret = w1.length();
        }else if(w1.length()==0){   // 串1是空，则串2每个字符都插入，用w2.length()次
            ret = w2.length();
        }else{
            String key = w1 + "_" + w2;
            if(mp.containsKey(key)){
                ret = mp.get(key);
            }else{
                char c = w2.charAt(0);
                int pos = w1.indexOf(c);
                if(pos==-1){
                    // w1 中没有 c
                    // 选择1 替换w1的第一个字符
                    sub1 = 1 + chk(w1.substring(1, w1.length()), w2.substring(1, w2.length()));
                    // 选择2 在 w1 前插入c
                    sub2 = 1 + chk(w1, w2.substring(1, w2.length()));
                    ret = Math.min(sub1, sub2);
                }else{
                    // w1 中有 c
                    // 选择3 把 c 放在搜到的位置
                    sub3 = pos + chk(w1.substring(pos+1, w1.length()), w2.substring(1, w2.length()));
                    // 选择4 不用 c 替换 w1 的第一个字符
                    sub4 = 1 + chk(w1.substring(1, w1.length()), w2.substring(1, w2.length())); // 同 sub1
                    // 选择5 不用 c 在 w1 前插入 c
                    sub5 = 1 + chk(w1, w2.substring(1, w2.length())); // 同 sub2
                    ret = Math.min(Math.min(sub3, sub4), sub5);
                }
            }
            mp.put(key, ret);
        }
        //System.out.println(w1 + "," + w2 + "=>" + sub1 +"," + sub2 +"," + sub3 +"," + sub4 +"," + sub5 +" ret="+ ret);
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(String word1, String word2, int expect){
	    Solution o = new Solution();
	    int ret = o.minDistance(word1, word2);
	    System.out.println("" + word1 + "=>" + word2 + " ret=" + ret + " expect=" + expect + (ret==expect?" OK":" NG"));
	}
	static void t1(){
	    tbase("horse", "ros", 3);
	}
	static void t2(){
	    tbase("intention", "execution", 5);
	}

}

