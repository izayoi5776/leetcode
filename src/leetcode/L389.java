package leetcode;

import java.util.HashMap;
import java.util.Map;

// 389. 找不同
public class L389 {
	
	public class Solution {
		public char findTheDifference(String s, String t) {
			Map<Character, Integer> ms = s2m(s);
			Map<Character, Integer> mt = s2m(t);
			char ret = mt.entrySet()
				.stream()
				.filter( e -> {	return
					!ms.containsKey(e.getKey())
					||
					ms.get(e.getKey())!=e.getValue();
				})
				.map(Map.Entry::getKey)
				.findFirst()
				.get();
			return ret;
		}
		Map<Character, Integer> s2m(String s){
			Map<Character, Integer> m = new HashMap<>();
			s.chars().forEach(c ->{
				if(m.containsKey((char)c)) {
					m.put((char) c, 1 + m.get((char)c));
				}else {
					m.put((char) c, 1);
				}
			});
			return m;
		}
	}
	
	public static void main(String[] args){
		L389 x = new L389();
		L389.Solution o = x.new Solution();
		
		// 输入：s = "abcd", t = "abcde"		输出："e"
		assert(o.findTheDifference("abcd", "abcde")=='e');
		// 输入：s = "", t = "y"		输出："y"
		assert(o.findTheDifference("", "y")=='y');

	}
}
