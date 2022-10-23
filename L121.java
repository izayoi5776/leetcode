package leetcode;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
public class L121 {
	class Solution {
		public int maxProfit(int[] prices) {
			if(prices==null || prices.length<2) {
				return 0;
			}
			/**
			 * 最小买入价格。比这个价格高，还比这个价格发生日晚的交易不可能更有利润
			 */
			int bmin = Integer.MAX_VALUE;
			int pmax = 0;
			// i买入日
			for(int i=0; i<prices.length-1; i++) {
				if(prices[i]>=bmin) {
					continue;
				}else {
					bmin = prices[i];
				}
				// j卖出日
				for(int j=i+1; j<prices.length; j++) {
					int pnew = prices[j] - prices[i];
					if(pnew>pmax) {
						pmax = pnew;
					}
				}
			}
			return pmax;
		}
	}
	public static void main(String[] args){
		L121 x = new L121();
		L121.Solution o = x.new Solution();
		
		// 输入：[7,1,5,3,6,4] 输出：5
		assert(o.maxProfit(new int[] {7, 1, 5, 3, 6, 4})==5);
		
		// 输入：prices = [7,6,4,3,1]	输出：0
		assert(o.maxProfit(new int[] {7, 6, 4, 3, 1})==0);
	}
}
