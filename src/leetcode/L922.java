package leetcode;

import java.util.Arrays;

// 922. 按奇偶排序数组 II
public class L922 {
	public class Solution {
		public int[] sortArrayByParityII(int[] nums) {
			int even=0;
			int odd=1;
			while(even<nums.length-1 && odd<nums.length) {
				int ne = nums[even];
				if(ne%2==0) {
					even+=2;
					continue;
				}
				int no = nums[odd];
				if(no%2==1) {
					odd+=2;
					continue;
				}
				// swap
				nums[even]=no;
				nums[odd]=ne;
				even+=2;
				odd+=2;
			}
			
			return nums;
		}
	}
	public static void main(String[] args){
		L922 x = new L922();
		L922.Solution o = x.new Solution();
		
		// 输入：nums = [4,2,5,7]		输出：[4,5,2,7]
		assert(Arrays.equals(o.sortArrayByParityII(new int[] {4,2,5,7}), new int[] {4,5,2,7}));
		
		// 输入：nums = [2,3]		输出：[2,3]
		assert(Arrays.equals(o.sortArrayByParityII(new int[] {2,3}), new int[] {2,3}));
		assert(Arrays.equals(o.sortArrayByParityII(new int[] {3,2}), new int[] {2,3}));

	}
}
