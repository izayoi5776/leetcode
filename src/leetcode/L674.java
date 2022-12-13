package leetcode;

// 674. 最长连续递增序列
public class L674 {
	public class Solution {
		public int findLengthOfLCIS(int[] nums) {
			if(nums.length<2) {
				return nums.length;
			}
			int ret = 0;
			int c = 1;
			for(int i=1; i<nums.length; i++) {
				if(nums[i]>nums[i-1]) {
					c++;
				} else {
					c=1;
				}
				if(c>ret) {
					ret = c;
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L674 x = new L674();
		L674.Solution o = x.new Solution();
		
		// 输入：nums = [1,3,5,4,7]		输出：3
		assert(o.findLengthOfLCIS(new int[] {1,3,5,4,7})==3);
		// 输入：nums = [2,2,2,2,2]		输出：1
		assert(o.findLengthOfLCIS(new int[] {2,2,2,2,2})==1);
		// 33/35
		assert(o.findLengthOfLCIS(new int[] {1})==1);
		assert(o.findLengthOfLCIS(new int[] {})==0);
	}
}
