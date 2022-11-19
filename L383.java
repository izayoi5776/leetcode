package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 383. 赎金信
public class L383 {
	
	public class Solution {
		public boolean canConstruct(String ransomNote, String magazine) {
			Map<Character, Integer> mr = s2m(ransomNote);
			Map<Character, Integer> mm = s2m(magazine);
			for (Map.Entry<Character, Integer> e : mr.entrySet()) {
				char k = e.getKey();
				int v = e.getValue();
				if(!mm.containsKey(k)) {
					return false;
				}
				if(mm.get(k)<v) {
					return false;
				}
			}
			return true;
		}
		Map<Character, Integer> s2m(String s){
			Map<Character, Integer> map = new HashMap<>();
			s.chars().forEach(c -> {
				if(map.containsKey((char)c)) {
					map.put((char)c, 1 + map.get((char)c));
				}else {
					map.put((char) c, 1);	
				}
			});
			return map;
		}
	}
	
	public static void main(String[] args){
		L383 x = new L383();
		L383.Solution o = x.new Solution();
		
		// 输入：ransomNote = "a", magazine = "b"		输出：false
		assert(!o.canConstruct("a", "b"));
		// 输入：ransomNote = "aa", magazine = "ab"		输出：false
		assert(!o.canConstruct("aa", "ab"));
		// 输入：ransomNote = "aa", magazine = "aab"		输出：true
		assert(o.canConstruct("aa", "aab"));

	}
}
