package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 500. 键盘行
public class L500 {
	public class Solution {
		public String[] findWords(String[] words) {
			Set<Object> s1 = "qwertyuiopQWERTYUIOP".chars().mapToObj(c->(char)c).collect(HashSet::new, Set::add, Set::add);
			Set<Object> s2 = "asdfghjklASDFGHJKL".chars().mapToObj(c->(char)c).collect(HashSet::new, Set::add, Set::add);
			Set<Object> s3 = "zxcvbnmZXCVBNM".chars().mapToObj(c->(char)c).collect(HashSet::new, Set::add, Set::add);
			
			List<String> ret = new ArrayList<>();
			for(int i=0; i<words.length; i++) {
				String w = words[i];
				if(chk(s1,w) || chk(s2,w) || chk(s3,w)) {
					ret.add(w);
				}
			}
			
			return ret.toArray(new String[0]);
		}
		boolean chk(Set<Object>s, String w) {
			for(int i=0; i<w.length(); i++) {
				char c = w.charAt(i);
				if(!s.contains(c)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		L500 x = new L500();
		L500.Solution o = x.new Solution();
		
		// 输入：words = ["Hello","Alaska","Dad","Peace"]		输出：["Alaska","Dad"]
		assert(Arrays.equals(o.findWords(new String[] {"Hello","Alaska","Dad","Peace"})	,new String[] {"Alaska","Dad"}));
		// 输入：words = ["omk"]		输出：[]
		assert(Arrays.equals(o.findWords(new String[] {"omk"}),new String[] {}));
		// 输入：words = ["adsdf","sfd"]		输出：["adsdf","sfd"]
		assert(Arrays.equals(o.findWords(new String[] {"adsdf","sfd"}),new String[] {"adsdf","sfd"}));
	}
}
