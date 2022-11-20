package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L58 {
	class Solution {
		Pattern p = Pattern.compile("([A-Za-z]+) *$");
		public int lengthOfLastWord(String s) {
			Matcher m = p.matcher(s);
			m.find();
			String ss = m.group(1);
	    	return ss.length();
	    }
	}
	public static void main(String[] args){
		L58 x = new L58();
		L58.Solution o = x.new Solution();
		assert(o.lengthOfLastWord("Hello World")==5);
		assert(o.lengthOfLastWord("   fly me   to   the moon  ")==4);
		assert(o.lengthOfLastWord("luffy is still joyboy")==6);
	}
}
