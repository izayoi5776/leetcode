package leetcode;

// 1812. 判断国际象棋棋盘中一个格子的颜色
public class L1812 {
	public class Solution {
		public boolean squareIsWhite(String coordinates) {
			if(coordinates==null) {
				return false;
			}
			int m = coordinates.charAt(0) - (int)'a';
			int n = coordinates.charAt(1) - (int)'1';
			
			int ret = (int) Math.pow(-1, m);
			ret = ret * (int) Math.pow(-1, n);
			return ret==-1;
		}
	}
	
	public static void main(String[] args){
		L1812 x = new L1812();
		L1812.Solution o = x.new Solution();
		
		// 输入：coordinates = "a1"		输出：false
		assert(!o.squareIsWhite("a1"));
		// 输入：coordinates = "h3"		输出：true
		assert(o.squareIsWhite("h3"));
		// 输入：coordinates = "c7"		输出：false
		assert(!o.squareIsWhite("c7"));
	}
}
