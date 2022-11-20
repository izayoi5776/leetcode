package leetcode;

// 441. 排列硬币
public class L441 {
	public class Solution {
		public int arrangeCoins(int n) {
			int k = (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
			//assert( n - (k+1)*k/2 < k+1 );
			return k;
		}
	}
	
	public static void main(String[] args){
		L441 x = new L441();
		L441.Solution o = x.new Solution();
		
		// 输入：n = 5		输出：2
		assert(o.arrangeCoins(5)==2);
		// 输入：n = 8		输出：3
		assert(o.arrangeCoins(8)==3);

		assert(o.arrangeCoins(1)==1);
		assert(o.arrangeCoins(2)==1);
		assert(o.arrangeCoins(3)==2);
		assert(o.arrangeCoins(4)==2);
		assert(o.arrangeCoins(5)==2);
		assert(o.arrangeCoins(6)==3);
		assert(o.arrangeCoins(7)==3);
		assert(o.arrangeCoins(8)==3);
		
		// n =	1804289383 预期结果	60070
		assert(o.arrangeCoins(1804289383)==60070);
	}
}
