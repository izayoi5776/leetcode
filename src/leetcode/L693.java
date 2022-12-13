package leetcode;

// 693. 交替位二进制数
public class L693 {
	public class Solution {
		public boolean hasAlternatingBits(int n) {
			int last = n%2;
			n = n>>1;
			while(n>0) {
				int c = n%2;
				if(c==last) {
					return false;
				}
				last = c;
				n = n>>1;
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		L693 x = new L693();
		L693.Solution o = x.new Solution();
		
		// 输入：n = 5		输出：true
		assert(o.hasAlternatingBits(5));
		// 输入：n = 7		输出：false
		assert(!o.hasAlternatingBits(7));
		// 输入：n = 11		输出：false
		assert(!o.hasAlternatingBits(11));

	}
}
