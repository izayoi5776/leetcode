package leetcode;

// 191. 位1的个数
public class L191 {
	class Solution {
		// you need treat n as an unsigned value
		public int hammingWeight(int n) {
	    	int r = Integer.bitCount(n);
			return r;
	    }
	}
	
	public static void main(String[] args){
		L191 x = new L191();
		L191.Solution o = x.new Solution();

		// 输入：00000000000000000000000000001011		输出：3
		assert(o.hammingWeight(11)==3);

		// 输入：00000000000000000000000010000000		输出：1
		assert(o.hammingWeight(128)==1);
	
		assert(o.hammingWeight(Integer.MIN_VALUE)==1);
	}
}
