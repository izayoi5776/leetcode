package leetcode;

// 1796. 字符串中第二大的数字
public class L1796 {
	public class Solution {
		public int secondHighest(String s) {
			int m1 = -1;
			int m2 = -1;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c>='0' && c<='9') {
					int n = Integer.valueOf(String.valueOf(c));
					if(n>m1) {
						m2 = m1;
						m1 = n;
					} else if(n==m1) {
						continue;
					} else if(n>m2){
						m2 = n;
					}
				}
			}
			return m2;
		}
	}
	
	public static void main(String[] args){
		L1796 x = new L1796();
		L1796.Solution o = x.new Solution();
		
		// 输入：s = "dfa12321afd"		输出：2
		assert(o.secondHighest("dfa12321afd")==2);
		// 输入：s = "abc1111"		输出：-1
		assert(o.secondHighest("abc1111")==-1);
	}
}
