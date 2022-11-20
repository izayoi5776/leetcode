package leetcode;

// 268. 丢失的数字
public class L268 {
	class Solution {
		public int missingNumber(int[] nums) {
			int[] a = new int[nums.length+1];
			for(int i=0; i<nums.length; i++) {
				int n = nums[i];
				a[n] = n;
			}
			for(int i=1; i<a.length; i++) {
				if(a[i]==0) {
					return i;
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args){
		L268 x = new L268();
		L268.Solution o = x.new Solution();
		
		// 输入：nums = [3,0,1]		输出：2 
		assert(o.missingNumber(new int[] {3,0,1})==2);
		
		// 输入：nums = [0,1]		输出：2
		assert(o.missingNumber(new int[] {0,1})==2);
		
		// 输入：nums = [9,6,4,2,3,5,7,0,1]		输出：8
		assert(o.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})==8);

		// 输入：nums = [0]		输出：1
		assert(o.missingNumber(new int[] {0})==1);
	}
}
