package leetcode;

// 746. 使用最小花费爬楼梯
public class L746 {
	public class Solution {
		public int minCostClimbingStairs(int[] cost) {
			/**
			 * 到达该位置的时候最小合计 cost
			 * sum[0]=0 选择位置0开始时
			 * sum[1]=0 选择位置1开始时
			 */
			int[] sum = new int[cost.length+1]; // 多一个位置时最后的TOP
			for(int i=2; i<sum.length; i++) {
				// 要到达位置 i，只有两种方法
				// 从 i-2 跳2格
				int sm2 = sum[i-2] + cost[i-2]; 
				// 或者 从 i-1 跳1格
				int sm1 = sum[i-1] + cost[i-1];
				// 选择较小的一个
				sum[i] = Math.min(sm2, sm1);
			}
			return sum[sum.length-1];
		}
	}
	public static void main(String[] args){
		L746 x = new L746();
		L746.Solution o = x.new Solution();
		
		// 输入：cost = [10,15,20]		输出：15
		assert(o.minCostClimbingStairs(new int[] {10,15,20})==15);
		// 输入：cost = [1,100,1,1,1,100,1,1,100,1]		输出：6
		assert(o.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1})==6);
		assert(o.minCostClimbingStairs(new int[] {10,15})==10);
		assert(o.minCostClimbingStairs(new int[] {10})==0);
		assert(o.minCostClimbingStairs(new int[] {})==0);
	}
}
