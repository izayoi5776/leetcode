package leetcode;

// 696. 计数二进制子串
public class L696 {
	public class Solution {
		public int countBinarySubstrings(String s) {
			int cnt = 0;
			for(int i=1; i<s.length(); i++) {
				// 找到01转换点
				if(s.charAt(i-1)!=s.charAt(i)) {
					cnt++;
					int offset = 1;
					while(true) {
						// 向前向后查找
						if(i-1-offset <0) {
							break;
						}
						if(i+offset>=s.length()) {
							break;
						}
						if(s.charAt(i-1-offset)==s.charAt(i-1)
							&& s.charAt(i+offset)==s.charAt(i)) {
							cnt++;
							offset++;
						} else {
							break;
						}
					}
				}
			}
			return cnt;
		}
	}
	
	public static void main(String[] args){
		L696 x = new L696();
		L696.Solution o = x.new Solution();
		
		// 输入：s = "00110011"		输出：6
		assert(o.countBinarySubstrings("00110011")==6);
		// 输入：s = "10101"		输出：4
		assert(o.countBinarySubstrings("10101")==4);
		assert(o.countBinarySubstrings("10")==1);
		assert(o.countBinarySubstrings("1")==0);
		assert(o.countBinarySubstrings("111")==0);
		assert(o.countBinarySubstrings("110")==1);

		// 34/91
		assert(o.countBinarySubstrings("1010001")==4);

	}
}
