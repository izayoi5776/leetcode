package leetcode;

// 859. 亲密字符串
public class L859 {
	public class Solution {
		public boolean buddyStrings(String s, String goal) {
			// 基本检查
			if(s==null || goal==null || s.length()!=goal.length()) {
				return false;
			}
			// 串相同
			if(s.equals(goal)) {
				// 长度0，1的字符串无法交换
				if(s.length()<2) {
					return false;
				}
				// 长度超过26必定有重复字符，所以可以无损交换
				if(s.length()>26) {
					return true;
				}
				for (int i = 0; i < s.length()-1; i++) {
					char c1 = s.charAt(i);
					for (int j = i+1; j < s.length(); j++) {
						char c2 = s.charAt(j);
						if(c1==c2) {
							// 找到重复字母就是可以无损交换
							return true;
						}
					}
				}
				// 找不到重复字母就不可以无损交换
				return false;
			}
			// 串不同
			int cnt = 0;
			char c11=' ', c21=' ';
			for (int i = 0; i < s.length(); i++) {
				char c1 = s.charAt(i);
				char c2 = goal.charAt(i);
				if(c1==c2) {
					continue;
				}
				// 不可以超过2处不同
				cnt++;
				if(cnt>2) {
					return false;
				}
				// 第一次不同时保存
				if(cnt==1) {
					c11=c1;
					c21=c2;
				} else {
					// 第二次不同检查是否为同一字母的交换
					if(c1!=c21 || c2!=c11) {
						return false;
					}
				}
			}
			return cnt==2;
		}
	}
	public static void main(String[] args){
		L859 x = new L859();
		L859.Solution o = x.new Solution();
		
		// 输入：s = "ab", goal = "ba"		输出：true
		assert(o.buddyStrings("ab", "ba"));
		
		// 输入：s = "ab", goal = "ab"		输出：false
		assert(!o.buddyStrings("ab", "ab"));

		// 输入：s = "aa", goal = "aa"		输出：true
		assert(o.buddyStrings("aa", "aa"));

		assert(o.buddyStrings("aaaaaa", "aaaaaa"));
		assert(!o.buddyStrings("a", "a"));
		assert(o.buddyStrings("abcde", "abced"));
		//32/34
		assert(!o.buddyStrings("abac", "abad"));
	}
}
