package leetcode;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

// 908. 最小差值 I
public class L908 {
	public class Solution {
		public int smallestRangeI(int[] nums, int k) {
			IntSummaryStatistics st = Arrays.stream(nums).summaryStatistics();
			int mid = (st.getMax() - st.getMin()) /2 + st.getMin();
			
			for (int i = 0; i < nums.length; i++) {
				int n = nums[i];
				if(Math.abs(n - mid)<=k) {
					nums[i]=mid;
				} else if(n>mid){
					nums[i]-=k;
				} else {
					nums[i]+=k;
				}
			}
			
			st = Arrays.stream(nums).summaryStatistics();
			
			return st.getMax() - st.getMin();
		}
	}
	public static void main(String[] args){
		L908 x = new L908();
		L908.Solution o = x.new Solution();
		
		// 输入：nums = [1], k = 0		输出：0
		assert(o.smallestRangeI(new int[] {1},0)==0);
		
		// 输入：nums = [0,10], k = 2		输出：6
		assert(o.smallestRangeI(new int[] {0,10},2)==6);

		// 输入：nums = [1,3,6], k = 3		输出：0
		assert(o.smallestRangeI(new int[] {1,3,6},3)==0);
	}
}
