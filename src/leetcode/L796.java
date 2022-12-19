package leetcode;

// 796. 旋转字符串
public class L796 {
	public class Solution {
		public boolean rotateString(String s, String goal) {
			// 长度必须一样
			int n = s.length();
			if(n!=goal.length()) {
				return false;
			}
			if(n==0 || s.equals(goal)) {
				return true;
			}
			char c = s.charAt(0);
			int pos = goal.indexOf(c);
			while(pos!=-1) {
				String s1 = s.substring(0, n-pos);
				String s2 = goal.substring(pos);
				String s3 = s.substring(n-pos);
				String s4 = goal.substring(0, pos);
				if(s1.equals(s2) && s3.equals(s4)) {
					return true;
				}
				pos = goal.indexOf(c, pos+1);
			}
			return false;
		}
	}
	public static void main(String[] args){
		L796 x = new L796();
		L796.Solution o = x.new Solution();
		
		// 输入: s = "abcde", goal = "cdeab"		输出: true
		assert(o.rotateString("abcde", "cdeab"));
		// 输入: s = "abcde", goal = "abced"		输出: false
		assert(!o.rotateString("abcde", "abced"));
		assert(o.rotateString("ababcabcd", "abcdababc"));
		assert(!o.rotateString("a", "b"));
		assert(o.rotateString("a", "a"));
	}
}
