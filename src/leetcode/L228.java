package leetcode;

import java.util.ArrayList;
import java.util.List;

// 228. 汇总区间
public class L228 {
	class Solution {
		public List<String> summaryRanges(int[] nums) {
			List<String> ret = new ArrayList<>();
			if(nums==null || nums.length==0) {
				return ret;
			}
			int start = 0;
			int end = 0;
			for(int i=1; i<nums.length; i++) {
				int n = nums[i];
				if(n==nums[i-1]+1) {
					end = i;
					continue;
				}else {
					add(ret, nums, start, end);
					start = i;
					end = i;
				}
			}
			add(ret, nums, start, end);
			return ret;
	    }
		/**
		 * 输出范围字符串
		 * @param a      OUT 输出字符串保存用Array
		 * @param nums   IN  输入
		 * @param start  IN  开始位置
		 * @param end    IN  结束位置
		 */
		void add(List<String> a, int[] nums, int start, int end){
			if(start==end) {
				a.add(String.valueOf(nums[start]));
			}else {
				a.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
			}
		}
	}
	
	public static void main(String[] args){
		L228 x = new L228();
		L228.Solution o = x.new Solution();

		// 输入：nums = [0,1,2,4,5,7]		输出：["0->2","4->5","7"]
		// 解释：区间范围是：		[0,2] --> "0->2"		[4,5] --> "4->5"		[7,7] --> "7"
		o.summaryRanges(new int[] {0,1,2,4,5,7});

		// 输入：nums = [0,2,3,4,6,8,9]		输出：["0","2->4","6","8->9"]
		// 解释：区间范围是：	[0,0] --> "0"	[2,4] --> "2->4"	[6,6] --> "6"	[8,9] --> "8->9"
		o.summaryRanges(new int[] {0,2,3,4,6,8,9});
	
		o.summaryRanges(null);
		o.summaryRanges(new int[] {});
		o.summaryRanges(new int[] {9});
		o.summaryRanges(new int[] {99, 100});
	}
}
