package leetcode;

// https://leetcode.cn/problems/excel-sheet-column-title/description/
public class L168 {
	class Solution {
		public String convertToTitle(int columnNumber) {
			int n = columnNumber;
			StringBuffer sb = new StringBuffer(10);
			
			while(n>0) {
				int m = (n-1) % 26;
				sb.insert(0, int2char(m));
				n = (n-1) / 26;
			}
			return sb.toString();
	    }
		/**
		 * 变换数字到一个字母
		 * @param n 必须在[0,25]
		 * @return
		 */
		char int2char(int n) {
			return (char)(65 + n);
		}
	}
	
	public static void main(String[] args){
		L168 x = new L168();
		L168.Solution o = x.new Solution();

		// 输入：columnNumber = 1		输出："A"
		assert(o.convertToTitle(1)).equals("A");

		// 输入：columnNumber = 28		输出："AB"
		assert(o.convertToTitle(28)).equals("AB");
		
		// 输入：columnNumber = 701		输出："ZY"
		assert(o.convertToTitle(701)).equals("ZY");
		
		// 输入：columnNumber = 2147483647		输出："FXSHRXW"
		assert(o.convertToTitle(2147483647)).equals("FXSHRXW");
		
	}
}
