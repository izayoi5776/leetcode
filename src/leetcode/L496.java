package leetcode;

import java.util.Arrays;

// 496. 下一个更大元素 I
public class L496 {
	public class Solution {
		public int[] nextGreaterElement(int[] nums1, int[] nums2) {
			int[] rets = new int[nums1.length];
			for(int i=0; i<nums1.length; i++) {
				int l = nums1[i];
				int ret = -1;
				int j = 0;
				for(; j<nums2.length; j++) {
					if(nums2[j]==l) {
						break;
					}
				}
				for(j++; j<nums2.length; j++) {
					int r = nums2[j]; 
					if(r>l) {
						ret = r;
						break;
					}
				}
				rets[i]=ret;
			}
			return rets;
		}
	}
	
	public static void main(String[] args){
		L496 x = new L496();
		L496.Solution o = x.new Solution();
		
		// 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].		输出：[-1,3,-1]
		assert(Arrays.equals(o.nextGreaterElement(new int[] {4,1,2},new int[] {1,3,4,2}),new int[] {-1,3,-1}));
		// 输入：nums1 = [2,4], nums2 = [1,2,3,4].		输出：[3,-1]
		assert(Arrays.equals(o.nextGreaterElement(new int[] {2,4},new int[] {1,2,3,4}),new int[] {3,-1}));
	}
}
