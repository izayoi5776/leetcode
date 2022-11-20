package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 290. 单词规律
public class L290 {
	
	public class Solution {
	    public boolean wordPattern(String pattern, String s) {
	    	Map<Character, String> mab = new HashMap<>();
	    	Map<String, Character> mba = new HashMap<>();
	    	
	    	if(pattern==null || s==null) {
	    		return false;
	    	}
	    	
	    	Pattern p = Pattern.compile("([a-z]+)");
	    	Matcher m = p.matcher(s);
	    	int pos = 0;
	    	while(m.find()) {
	    		String word = m.group();
	    		if(pos>=pattern.length()) {
	    			return false;
	    		}
	    		char c = pattern.charAt(pos);
	    		if(mab.containsKey(c)) {
	    			String oldword = mab.get(c);
	    			if(!word.equals(oldword)) {
	    				return false;
	    			}
	    		}else {
	    			if(mba.containsKey(word)) {
	    				return false;
	    			}
	    			mab.put(c, word);
	    			mba.put(word, c);
	    		}
	    		pos++;
	    	}
	    	return pos==pattern.length();
	    }
	}
	
	public static void main(String[] args){
		L290 x = new L290();
		L290.Solution o = x.new Solution();
		
		// 输入: pattern = "abba", s = "dog cat cat dog"		输出: true
		assert(o.wordPattern("abba", "dog cat cat dog"));
		
		// 输入:pattern = "abba", s = "dog cat cat fish"		输出: false
		assert(!o.wordPattern("abba", "dog cat cat fish"));

		// 输入: pattern = "aaaa", s = "dog cat cat dog"		输出: false
		assert(!o.wordPattern("aaaa", "dog cat cat dog"));

		// 输入: pattern = "jquery", s = "jquery"		输出: false
		assert(!o.wordPattern("jquery", "jquery"));

	}
}
