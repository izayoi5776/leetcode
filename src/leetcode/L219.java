package leetcode;

import java.util.HashMap;
import java.util.Map;

// L205.java
public class L219 {
	class Solution {
		public boolean containsNearbyDuplicate(int[] nums, int k) {
			if(k<=0) {
				return false;
			}
			// key=num[i], value=i
			Map<Integer, Integer> m = new HashMap<>();
			for(int i=0; i<nums.length; i++) {
				int c = nums[i];
				if(m.containsKey(c)) {
					int p = m.get(c);	// 开始位置
					if(i-p <= k) {
						return true;
					}
				}
				m.put(c, i);
			}
			return false;
	    }
	}
	
	public static void main(String[] args){
		L219 x = new L219();
		L219.Solution o = x.new Solution();

		// 输入：nums = [1,2,3,1], k = 3		输出：true
		assert(o.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));

		// 输入：nums = [1,0,1,1], k = 1		输出：true
		assert(o.containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
	
		// 输入：nums = [1,2,3,1,2,3], k = 2		输出：false
		assert(!o.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
		
	}
}
