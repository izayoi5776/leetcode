package leetcode;

// 459. 重复的子字符串
public class L459 {
	public class Solution {
		public boolean repeatedSubstringPattern(String s) {
			int n = s.length();
			char c = s.charAt(0);
			outerloop:
			for(int i=1; i<n; i++) {
				// 子串必然从 c 开始
				if(s.charAt(i)!=c) {
					continue;
				}
				// 子串长度必须能被全长整除
				if(n % i != 0) {
					continue;
				}
				// 检查所有子串是否完全相同
				String sub0 = s.substring(0,i); 
				for(int j=1; j< n/i; j++) {
					String sub1 = s.substring(i*j, i*j+i);
					if(!sub0.equals(sub1)) {
						continue outerloop;
					}
				}
				// 到这里就找到了
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L459 x = new L459();
		L459.Solution o = x.new Solution();
		
		// 输入: s = "abab"		输出: true
		assert(o.repeatedSubstringPattern("abab"));
		// 输入: s = "aba"		输出: false
		assert(!o.repeatedSubstringPattern("aba"));
		// 输入: s = "abcabcabcabc"		输出: true
		assert(o.repeatedSubstringPattern("abcabcabcabc"));
		assert(o.repeatedSubstringPattern("abacabadabacabad"));
	}
}
