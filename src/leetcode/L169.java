package leetcode;

import java.util.HashMap;
import java.util.Map;

// 169. 多数元素
public class L169 {
	class Solution {
		public int majorityElement(int[] nums) {
			// n, count
			Map<Integer, Integer> m = new HashMap<>();
			int n = nums.length;
			int n2 = n / 2;
			for(int i=0; i<n; i++) {
				int k = nums[i];
				int c = 0;
				if(m.containsKey(k)) {
					c = m.get(k) + 1;
				}else {
					c = 1;
				}
				m.put(k, c);
				if(c>n2) {
					return k;
				}
			}
			// 题目保证不会到达这里
			return 0;
	    }
	}
	
	public static void main(String[] args){
		L169 x = new L169();
		L169.Solution o = x.new Solution();

		// 输入：nums = [3,2,3]		输出：3
		assert(o.majorityElement(new int[]{3,2,3}))==3;

		// 输入：nums = [2,2,1,1,1,2,2]		输出：2
		assert(o.majorityElement(new int[] {2,2,1,1,1,2,2})==2);
	
	}
}
