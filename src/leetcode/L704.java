package leetcode;

// 704. 二分查找
public class L704 {
	public class Solution {
		public int search(int[] nums, int target) {
			return search2(nums, target, 0, nums.length-1);
		}
		int search2(int[] nums, int target, int from, int to) {
			if(from>to) {
				return -1;
			}
			int c = from + (to - from)/2;
			int n = nums[c];
			if(n==target) {
				return c;
			}
			if(n<target) {
				return search2(nums, target, c+1, to);
			} else {
				return search2(nums, target, from, c-1);
			}
		}
	}


	public static void main(String[] args){
		L704 x = new L704();
		L704.Solution o = x.new Solution();
		
		// 输入: nums = [-1,0,3,5,9,12], target = 9		输出: 4
		assert(o.search(new int[] {-1,0,3,5,9,12},9)==4);
		// 输入: nums = [-1,0,3,5,9,12], target = 2		输出: -1
		assert(o.search(new int[] {-1,0,3,5,9,12},2)==-1);
		assert(o.search(new int[] {-1,0,3,5,9,12},13)==-1);

	}
}
