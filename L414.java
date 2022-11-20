package leetcode;

import java.util.NavigableSet;
import java.util.TreeSet;

// 414. 第三大的数
public class L414 {
	
	public class Solution {
		public int thirdMax(int[] nums) {
			NavigableSet<Integer> st = new TreeSet<>();
			for(int i=0; i<nums.length; i++) {
				st.add(nums[i]);
				if(st.size()>3) {
					st.pollFirst();
				}
			}
			int ret;
			if(st.size()==3) {
				ret = st.first();
			}else {
				ret = st.last();
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L414 x = new L414();
		L414.Solution o = x.new Solution();
		
		// 输入：[3, 2, 1]		输出：1
		assert(o.thirdMax(new int[] {3,2,1})==1);
		// 输入：[1, 2]		输出：2
		assert(o.thirdMax(new int[] {1,2})==2);
		// 输入：[2, 2, 3, 1]		输出：1
		assert(o.thirdMax(new int[] {2,2,3,1})==1);
		assert(o.thirdMax(new int[] {2,4,3,1})==2);
		assert(o.thirdMax(new int[] {9})==9);
		assert(o.thirdMax(new int[] {Integer.MAX_VALUE})==Integer.MAX_VALUE);
		assert(o.thirdMax(new int[] {Integer.MIN_VALUE})==Integer.MIN_VALUE);

	}
}
