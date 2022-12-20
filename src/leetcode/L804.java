package leetcode;

import java.util.HashSet;
import java.util.Set;

// 804. 唯一摩尔斯密码词
public class L804 {
	public class Solution {
		public int uniqueMorseRepresentations(String[] words) {
			String[] sa = new String[] {".-","-...","-.-.","-..",".",
					"..-.","--.","....","..",".---",
					"-.-",".-..","--","-.","---",
					".--.","--.-",".-.","...","-",
					"..-","...-",".--","-..-","-.--",
					"--.."};
			Set<String> st = new HashSet<>();
			for (int i = 0; i < words.length; i++) {
				String s = words[i];
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					int n = c-'a';
					String m = sa[n];
					sb.append(m);
				}
				st.add(sb.toString());
			}
			return st.size();
		}
	}
	public static void main(String[] args){
		L804 x = new L804();
		L804.Solution o = x.new Solution();
		
		// 输入: words = ["gin", "zen", "gig", "msg"]		输出: 2
		assert(o.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"})==2);
		// 输入：words = ["a"]		输出：1
		assert(o.uniqueMorseRepresentations(new String[] {"a"})==1);
	}
}
