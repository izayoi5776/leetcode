package leetcode;

import java.util.Set;
import java.util.stream.Collectors;

// 521. 最长特殊序列 Ⅰ
public class L521 {
	public class Solution {
		public int findLUSlength(String a, String b) {
			int la = a.length();
			int lb = b.length();
			// 长度不同时，更长的串一定不是短串的子串
			if(la>lb) {
				return la;
			} else if(lb>la) {
				return lb;
			}
			// 所以只需要处理长度相同的情况
			// 完全相同的串没有独立子串
			if(a.equals(b)) {
				return -1;
			}
			
			// 字符集不同，则最长独立子串就是包含这个字符的串本身，尔已知a，b长度相同
			Set<Character> sa = a.chars().mapToObj(i->(char)i).collect(Collectors.toSet());
			Set<Character> sb = b.chars().mapToObj(i->(char)i).collect(Collectors.toSet());
			if(!sa.equals(sb)) {
				// la == lb
				return la;
			}
			
			// 能到这里，a,b是长度相同，字符集相同的不同字符串
			// 也就是说，除了相同的串返回-1，不相同的串答案是一定是更长的那个串，气死了。
			return la;			
		}
	}
	
	public static void main(String[] args){
		L521 x = new L521();
		L521.Solution o = x.new Solution();
		
		// 输入: a = "aba", b = "cdc"		输出: 3
		assert(o.findLUSlength("aba", "cdc")==3);
		// 输入：a = "aaa", b = "bbb"		输出：3
		assert(o.findLUSlength("aaa", "bbb")==3);

		// 输入：a = "aaa", b = "aaa"		输出：-1
		assert(o.findLUSlength("aaa", "aaa")==-1);
	}
}
