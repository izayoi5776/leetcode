package leetcode;

// 292. Nim 游戏
public class L292 {
	
	public class Solution {
		public boolean canWinNim(int n) {
			return n % 4 != 0;
	    }
	}
	
	public static void main(String[] args){
		L292 x = new L292();
		L292.Solution o = x.new Solution();
		
		// 输入：n = 4		输出：false 
		assert(!o.canWinNim(4));
		
		// 输入：n = 1		输出：true
		assert(o.canWinNim(1));

		// 输入：n = 2		输出：true
		assert(o.canWinNim(2));

	}
}
