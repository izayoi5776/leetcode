package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 392. 判断子序列
public class L392 {
	
	public class Solution {
		public boolean isSubsequence(String s, String t) {
			// 创建一个包含所有 t 字符和位置的 Map
			Map<Character, List<Integer>> m = new HashMap<>();
			// key=char, val=pos in t
			for(int i=0; i<t.length(); i++) {
				char c = t.charAt(i);
				List<Integer> lst = null;
				if(m.containsKey(c)) {
					lst = m.get(c);
				}else {
					lst = new ArrayList<>();
				}
				lst.add(i);
				m.put(c, lst);
			}

			// 对 s 的每一个字符，抽出所有可能的后续字符放在 lst 里
			List<Integer> lst = null;
			for (int i=0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!m.containsKey(c)) {
					return false;
				}
				if(lst==null) {
					lst = m.get(c);
					if(lst.size()<=0) {
						return false;
					}
					continue;
				}
				List<Integer> lst2 = m.get(c);
				int min = lst.get(0);
				lst = lst2.stream().filter(n -> n > min).toList();
				if(lst.size()<=0) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		L392 x = new L392();
		L392.Solution o = x.new Solution();
		
		// 输入：s = "abc", t = "ahbgdc"		输出：true
		assert(o.isSubsequence("abc", "ahbgdc"));
		// 输入：s = "axc", t = "ahbgdc"		输出：false
		assert(!o.isSubsequence("axc", "ahbgdc"));
		assert(!o.isSubsequence("abcabc", "abcda"));
		assert(!o.isSubsequence("abcabc", "bacdabc"));

	}
}
