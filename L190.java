package leetcode;

// 190. 颠倒二进制位
public class L190 {
	class Solution {
		// you need treat n as an unsigned value
	    public int reverseBits(int n) {
	    	int r = Integer.reverse(n);
			return r;
	    }
	}
	
	public static void main(String[] args){
		L190 x = new L190();
		L190.Solution o = x.new Solution();

		// 输入：n = 43261596	输出：964176192
		assert(o.reverseBits(43261596)==964176192);

		// 输入表示有符号整数 -3，输出表示有符号整数 -1073741825
		assert(o.reverseBits(-3)==-1073741825);
	
		assert(o.reverseBits(0)==0);
		assert(o.reverseBits(1)==Integer.MIN_VALUE);

	}
}
