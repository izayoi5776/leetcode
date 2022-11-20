package leetcode;

// 326. 3 的幂
public class L326 {
	
	class Solution {
		public boolean isPowerOfThree(int n) {
			String s = Integer.toString(n, 3);
			if(s.charAt(0)!='1') {
				return false;
			}
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i)!='0') {
					return false;
				}
			}
			return true;
		}
		public boolean isPowerOfThree1(int n) {
			if(n<=0) {
				return false;
			}
			if(n==1 || n==3 || n==27 || n==81) {
				return true;
			}
			int m = n % 10;
			// m must be 1,3,7,9
			if (!(m==1 || m==3 || m==7 || m==9)) {
				return false;
			}
			if(n%3==0) {
				return isPowerOfThree(n/3);
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L326 x = new L326();
		L326.Solution o = x.new Solution();
		
		// 输入：n = 27		输出：true 
		assert(o.isPowerOfThree(27));
		// 输入：n = 0		输出：false
		assert(!o.isPowerOfThree(0));
		// 输入：n = 9		输出：true
		assert(o.isPowerOfThree(9));
		// 输入：n = 45		输出：false
		assert(!o.isPowerOfThree(45));
		
	}
}
