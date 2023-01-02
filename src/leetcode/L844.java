package leetcode;

// 844. 比较含退格的字符串
public class L844 {
	public class Solution {
		public boolean backspaceCompare(String s, String t) {
			if(s==null || t==null) {
				return false;
			}
			
			String s1 = clean(s);
			String t1 = clean(t);
			
			return s1.equals(t1);
		}
		String clean(String s){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c=='#') {
					if(sb.length()>0) {
						sb.deleteCharAt(sb.length()-1);
					}
				} else {
					sb.append(c);
				}
			}
			return sb.toString();
		}
	}
	public static void main(String[] args){
		L844 x = new L844();
		L844.Solution o = x.new Solution();
		
		// 输入：s = "ab#c", t = "ad#c"		输出：true
		assert(o.backspaceCompare("ab#c", "ad#c"));
		
		// 输入：s = "ab##", t = "c#d#"		输出：true
		assert(o.backspaceCompare("ab##", "c#d#"));

		// 输入：s = "a#c", t = "b"		输出：false
		assert(!o.backspaceCompare("a#c", "b"));
		
		assert(o.backspaceCompare("a##b##", "c###d#"));
	}
}
