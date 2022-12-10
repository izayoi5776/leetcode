package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

// 643. 子数组最大平均数 I
public class L643 {
	public class Solution {
		public double findMaxAverage(int[] nums, int k) {
			int sum = 0;
			for(int i=0; i<k; i++) {
				sum += nums[i];
			}
			double ret = sum / 1.0 / k;
			for(int i=1; i<nums.length-k+1; i++) {
				sum -= nums[i-1];
				sum += nums[i+k-1];
				double avg = sum / 1.0 / k;
				if(avg>ret) {
					ret = avg;
				}
			}
			return ret;			
		}
		// run timeout
		public double findMaxAverage1(int[] nums, int k) {
			double ret = IntStream.range(0, nums.length-k+1)
				.mapToDouble(i-> Arrays.stream(Arrays.copyOfRange(nums, i, i+k)).average().orElse(Double.MIN_VALUE))
				.max()
				.orElse(Double.MIN_VALUE);
			return ret;
		}
	}
	
	public static void main(String[] args){
		L643 x = new L643();
		L643.Solution o = x.new Solution();
		
		// 输入：nums = [1,12,-5,-6,50,3], k = 4		输出：12.75
		assert(o.findMaxAverage(new int[] {1,12,-5,-6,50,3},4)==12.75);
		// 输入：nums = [5], k = 1		输出：5.00000
		assert(o.findMaxAverage(new int[] {5},1)==5.0);
	}
}
