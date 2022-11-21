package leetcode;

// 461. 汉明距离
public class L461 {
	public class Solution {
		public int hammingDistance(int x, int y) {
			return Integer.bitCount(x^y);
		}
	}
	
	public static void main(String[] args){
		L461 x = new L461();
		L461.Solution o = x.new Solution();
		
		// 输入：x = 1, y = 4		输出：2
		assert(o.hammingDistance(1,4)==2);
		// 输入：x = 3, y = 1		输出：1
		assert(o.hammingDistance(3,1)==1);
	}
}
