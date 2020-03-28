/******************************************************************************

820. 单词的压缩编码
https://leetcode-cn.com/problems/short-encoding-of-words/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        // 用 map 除重复
        Map<String, Integer> mp = new HashMap<String, Integer>();
        // save to map
        for(int i=0;i<words.length;i++){
            mp.put(words[i], 0);
            //System.out.println("mp=" + Arrays.toString(mp.keySet().toArray()) + " i=" + i + " words[i]=" + words[i]);
        }
        // 按照长度排序
        List<String> ls = new ArrayList<String>(mp.keySet());
        Collections.sort(ls,
            new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.length() - s2.length();
                }
            }
        );
        //System.out.println("sorted=" + ls);
        
        // 从短的看 endwith, 找到就丢弃
        List<String> ls2 = new ArrayList<String>(); // 保存结果
        for(int i=0;i<ls.size();i++){
            String s = ls.get(i); // 现在调查中文字列
            boolean tailflg = false;
            for(int j=i+1; j<ls.size(); j++){
                if(ls.get(j).endsWith(s)){
                    tailflg = true;
                    break;
                }
            }
            // 如果现在文字列 s 不是之后任何文字列的尾巴，就把它保存下来
            if(!tailflg){
                ls2.add(s);
            }
        }
        System.out.println("ls1=" + ls + " ls2=" + ls2);
        
        // 算最后的长度，每个单词要一个结尾字符
        int ret = 0;
        for(String s:ls2){
            ret += s.length();
        }
        ret += ls2.size();
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
	}
	static void tbase(String[] words, int expect){
	    Solution o = new Solution();
	    System.out.println("words=" + Arrays.toString(words) + " ret=" + o.minimumLengthEncoding(words) + " expect=" + expect);
	}
	static void t1(){
	    tbase(new String[]{"time", "me", "bell"}, 10);
	}
}

