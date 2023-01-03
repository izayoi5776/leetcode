package leetcode;

// 896. 单调数列
public class L896 {
	public class Solution {
		public boolean isMonotonic(int[] nums) {
			if(nums.length<=1) {
				return true;
			}
			Boolean inc = null;
			for (int i = 1; i < nums.length; i++) {
				if(nums[i]==nums[i-1]) {
					continue;
				}
				if(nums[i]>nums[i-1]) {
					if(inc==null) {
						inc=true;
					} else if(!inc){
						return false;
					}
				} else {
					if(inc==null) {
						inc=false;
					} else if(inc) {
						return false;
					}
				}
			}
			return true;
		}
	}
	public static void main(String[] args){
		L896 x = new L896();
		L896.Solution o = x.new Solution();
		
		// 输入：nums = [1,2,2,3]		输出：true
		assert(o.isMonotonic(new int[] {1,2,2,3}));
		
		// 输入：nums = [6,5,4,4]		输出：true
		assert(o.isMonotonic(new int[] {6,5,4,4}));

		// 输入：nums = [1,3,2]		输出：false
		assert(!o.isMonotonic(new int[] {1,3,2}));
	}
}
