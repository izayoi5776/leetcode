package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 349. 两个数组的交集
public class L349 {
	
	class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Set<Integer> st = new HashSet<>();
			Arrays.stream(nums1).forEach(x -> st.add(x));
			return Arrays.stream(nums2).filter(x -> st.contains(x)).distinct().toArray();
		}
	}
	
	public static void main(String[] args){
		L349 x = new L349();
		L349.Solution o = x.new Solution();
		
		// 输入：nums1 = [1,2,2,1], nums2 = [2,2]		输出：[2] 
		System.out.println(Arrays.toString(o.intersection(new int[] {1,2,2,1}, new int[] {2,2})));
		// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]		输出：[9,4]
		System.out.println(Arrays.toString(o.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
		
	}
}
