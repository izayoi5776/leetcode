package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 697. 数组的度
public class L697 {
	public class Solution {
		public int findShortestSubArray(int[] nums) {
			// 制作 Map<数字，出现次数>
			Map<Integer, Long> m = Arrays.stream(nums)
					.boxed()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			// 出现次数最大的就是 度
			Long d = m.values().stream().max(Long::compare).orElse(0L);
			// 取得出现次数等于 度 的所有数字
			List<Integer> ls = m.entrySet().stream()
					.filter(e->e.getValue()==d)
					.map(e->e.getKey())
					.toList();
			// m 不需要了
			m=null;
			//
			int ret = ls.stream().map(n->len(nums, n)).min(Integer::compare).orElse(0);
			
			return ret;
		}
		/**
		 * 求数字 n 的子串长度
		 * 就是求最左边的 n 和最右边的 n 之间的长度
		 */
		int len(int[] nums, int n){
			int l = 0; 
			int r = nums.length-1;
			while(l<=r) {
				if(nums[l]==n) {
					break;
				}
				l++;
			}
			while(l<=r) {
				if(nums[r]==n) {
					break;
				}
				r--;
			}
			return r - l + 1;
		}
	}
	
	public static void main(String[] args){
		L697 x = new L697();
		L697.Solution o = x.new Solution();
		
		// 输入：nums = [1,2,2,3,1]		输出：2
		assert(o.findShortestSubArray(new int[] {1,2,2,3,1})==2);
		// 输入：nums = [1,2,2,3,1,4,2]		输出：6
		assert(o.findShortestSubArray(new int[] {1,2,2,3,1,4,2})==6);

	}
}
