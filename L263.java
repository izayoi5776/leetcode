package leetcode;

// 263. 丑数
public class L263 {
	class Solution {
		public boolean isUgly(int n) {
			if(n<=0) {
				return false;
			}
			if(n==1 || n==2 || n==3 || n==5) {
				return true;
			}
			if(n%2 == 0) {
				return isUgly(n/2);
			}
			if(n%3 == 0) {
				return isUgly(n/3);
			}
			if(n%5 == 0) {
				return isUgly(n/5);
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L263 x = new L263();
		L263.Solution o = x.new Solution();
		
		// 输入：n = 6		输出：true 
		assert(o.isUgly(6));
		
		// 输入：n = 1		输出：true
		assert(o.isUgly(1));
		
		// 输入：n = 14		输出：false
		assert(!o.isUgly(14));

		assert(!o.isUgly(0));
		assert(!o.isUgly(-1));
		assert(o.isUgly(150));
		assert(!o.isUgly(210));

	}
}
