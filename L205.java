package leetcode;

import java.util.HashMap;
import java.util.Map;

// 205. 同构字符串
public class L205 {
	class Solution {
		public boolean isIsomorphic(String s, String t) {
			if(s==null && t==null) {
				return true;
			}
			if(s.length() != t.length()) {
				return false;
			}
			Map<Character , Character> st = new HashMap<>();
			Map<Character , Character> ts = new HashMap<>();
			for(int i=0; i<s.length(); i++) {
				char cs = s.charAt(i);
				char ct = t.charAt(i);
				if(ts.containsKey(ct) || st.containsKey(cs)) {
					try {
						if(ct!=st.get(cs) || cs!=ts.get(ct)) {
							return false;
						}
					}catch(Exception e) {
						return false;
					}
				} else {
					st.put(cs, ct);
					ts.put(ct, cs);
				}
			}
			return true;
	    }
	}
	
	public static void main(String[] args){
		L205 x = new L205();
		L205.Solution o = x.new Solution();

		// 输入：s = "egg", t = "add"		输出：true
		assert(o.isIsomorphic("egg", "add"));

		// 输入：s = "foo", t = "bar"		输出：false
		assert(!o.isIsomorphic("foo", "bar"));
	
		// 输入：s = "paper", t = "title"		输出：true
		assert(o.isIsomorphic("paper", "title"));
		
		// s ="badc" t ="baba"
		assert(!o.isIsomorphic("badc", "baba"));
	}
}
