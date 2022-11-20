package leetcode;

// 171. Excel 表列序号
public class L171 {
	class Solution {
		public int titleToNumber(String columnTitle) {
			int ret = 0;
			for(int i=0; i<columnTitle.length(); i++) {
				ret *= 26;
				char c = columnTitle.charAt(i);
				ret += ((int)c - 64);
			}
			return ret;
	    }
	}
	
	public static void main(String[] args){
		L171 x = new L171();
		L171.Solution o = x.new Solution();

		// 输入: columnTitle = "A"		输出: 1
		assert(o.titleToNumber("A")==1);

		// 输入: columnTitle = "AB"		输出: 28
		assert(o.titleToNumber("AB")==28);
	
		// 输入: columnTitle = "ZY"		输出: 701
		assert(o.titleToNumber("ZY")==701);
	}
}
