package leetcode;

import java.util.Arrays;

public class L35 {
	class Solution {
		public int searchInsert(int[] nums, int target) {
			System.out.println(nums);
			int ret = Arrays.binarySearch(nums, target);
			if(ret<0) {
				ret = -1 * (ret + 1);
			}
	    	return ret;
	    }

	}
	public static void main(String[] args){
		L35 x = new L35();
		L35.Solution o = x.new Solution();
		assert(o.searchInsert(new int[]{1,3,5,6}, 5)==2);
		assert(o.searchInsert(new int[]{1,3,5,6}, 2)==1);
		assert(o.searchInsert(new int[]{1,3,5,6}, 7)==4);
	}
}
