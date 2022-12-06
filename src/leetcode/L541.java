package leetcode;

// 541. 反转字符串 II
public class L541 {
	public class Solution {
		public String reverseStr(String s, int k) {
			StringBuilder sb = new StringBuilder();
			int i=k+k;
			for(; i<s.length(); i+=k+k) {
				StringBuilder s1 = new StringBuilder(s.substring(i-k-k, i-k));
				StringBuilder s2 = new StringBuilder(s.substring(i-k, i));
				sb.append(s1.reverse());
				sb.append(s2);
			}
			if(i-k-k<s.length()) {
				StringBuilder s1 = new StringBuilder(s.substring(i-k-k, Math.min(i-k, s.length())));
				StringBuilder s2 = new StringBuilder(s.substring(Math.min(Math.max(i-k,0),s.length()), Math.min(i, s.length())));
				sb.append(s1.reverse());
				sb.append(s2);
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args){
		L541 x = new L541();
		L541.Solution o = x.new Solution();
		
		// 输入：s = "abcdefg", k = 2		输出："bacdfeg"
		assert(o.reverseStr("abcdefg", 2).equals("bacdfeg"));
		// 输入：s = "abcd", k = 2		输出："bacd"
		assert(o.reverseStr("abcd", 2).equals("bacd"));
		// 34/60
		assert(o.reverseStr("abcd", 4).equals("dcba"));
		// 7/60
		assert(o.reverseStr("a", 2).equals("a"));
	}
}
