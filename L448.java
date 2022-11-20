package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 448. 找到所有数组中消失的数字
public class L448 {
	public class Solution {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			Set<Integer> st = new HashSet<>();
			for(int i=1; i<=nums.length; i++) {
				st.add(i);
			}
			for(int i=0; i<nums.length; i++) {
				st.remove(nums[i]);
			}
			
			List<Integer> ret = new ArrayList<>();
			ret.addAll(st);
			return ret;
		}
	}
	
	public static void main(String[] args){
		L448 x = new L448();
		L448.Solution o = x.new Solution();
		
		// 输入：nums = [4,3,2,7,8,2,3,1]		输出：[5,6]
		System.out.println(o.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
		// 输入：nums = [1,1]		输出：[2]
		System.out.println(o.findDisappearedNumbers(new int[] {1,1}));

	}
}
