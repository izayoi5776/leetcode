package leetcode;

import java.util.ArrayList;
import java.util.List;

// 231. 2 的幂
public class L231 {
	class Solution {
		public boolean isPowerOfTwo(int n) {
			return n>0 && Integer.bitCount(n)==1;
	    }
	}

	public static void main(String[] args){
		L231 x = new L231();
		L231.Solution o = x.new Solution();

		// 输入：n = 1		输出：true
		assert(o.isPowerOfTwo(1));
		// 输入：n = 16		输出：true
		assert(o.isPowerOfTwo(16));
		// 输入：n = 3		输出：false
		assert(!o.isPowerOfTwo(3));
		// 输入：n = 4		输出：true
		assert(o.isPowerOfTwo(4));
		// 输入：n = 5		输出：false
		assert(!o.isPowerOfTwo(5));

		assert(!o.isPowerOfTwo(0));
		assert(!o.isPowerOfTwo(-1));
		assert(!o.isPowerOfTwo(-2));
	
	}
}
