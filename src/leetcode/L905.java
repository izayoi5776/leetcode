package leetcode;

import java.util.Arrays;

// 905. 按奇偶排序数组
public class L905 {
	public class Solution {
		public int[] sortArrayByParity(int[] nums) {
			int start=0;
			int end=nums.length-1;
			while(start<end) {
				if(nums[start]%2==0) {
					start++;
					continue;
				}
				if(nums[end]%2==1) {
					end--;
					continue;
				}
				int t = nums[start];
				nums[start]=nums[end];
				nums[end]=t;
			}
			return nums;
		}
	}
	public static void main(String[] args){
		L905 x = new L905();
		L905.Solution o = x.new Solution();
		
		// 输入：nums = [3,1,2,4]		输出：[2,4,3,1]
		//assert(Arrays.equals(o.sortArrayByParity(new int[] {3,1,2,4}), new int[] {2,4,3,1}));
		assert(Arrays.equals(o.sortArrayByParity(new int[] {3,1,2,4}), new int[] {4,2,1,3}));
		
		// 输入：nums = [0]		输出：[0]
		assert(Arrays.equals(o.sortArrayByParity(new int[] {0}), new int[] {0}));

	}
}
