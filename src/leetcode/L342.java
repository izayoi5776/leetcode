package leetcode;

// 342. 4的幂
public class L342 {
	
	class Solution {
		public boolean isPowerOfFour(int n) {
			if(Integer.bitCount(n)!=1) {
				return false;
			}
			while(true) {
				if(n==1) {
					return true;
				}
				if(n<1) {
					return false;
				}
				n = n>>>2;
			}
		}
	}
	
	public static void main(String[] args){
		L342 x = new L342();
		L342.Solution o = x.new Solution();
		
		// 输入：n = 16		输出：true 
		assert(o.isPowerOfFour(16));
		// 输入：n = 5		输出：false
		assert(!o.isPowerOfFour(5));
		// 输入：n = 1		输出：true
		assert(o.isPowerOfFour(1));
		
	}
}
