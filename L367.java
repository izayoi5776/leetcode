package leetcode;

// 367. 有效的完全平方数
public class L367 {
	
	class Solution {
		public boolean isPerfectSquare(int num) {
			int q = (int) Math.sqrt(num);
			return q * q == num;
		}
	}
	
	public static void main(String[] args){
		L367 x = new L367();
		L367.Solution o = x.new Solution();
		
		// 输入：num = 16		输出：true 
		assert(o.isPerfectSquare(16));
		// 输入：num = 14		输出：false
		assert(!o.isPerfectSquare(14));
		
	}
}
