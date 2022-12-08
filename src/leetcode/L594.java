package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 594. 最长和谐子序列
public class L594 {
	public class Solution {
		public int findLHS(int[] nums) {
			// 题目等价于 求合计重复次数最多的两个相邻数字，的合计重复次数
			// key=num, val=count
			Map<Integer, Long> m = Arrays
					.stream(nums)
					.boxed()
					.collect(Collectors.groupingBy(i->i, Collectors.counting()));
			
			long max = 0;
			for(Map.Entry<Integer, Long> entry : m.entrySet()) {
				int key = entry.getKey();
				long cnt = entry.getValue();
				long cm1 = m.getOrDefault(key-1, 0L);
				long cp1 = m.getOrDefault(key+1, 0L);
				if(cm1==0 && cp1==0) {
					continue;
				}
				long max2 = cnt + Math.max(cm1, cp1);
				if(max2 > max) {
					max = max2;
					System.out.println("key=" + key + " cnt=" + cnt + " cm1=" + cm1 + " cp1=" + cp1 + " max=" + max);
				}
			}
			return (int)max;
		}
	}
	
	public static void main(String[] args){
		L594 x = new L594();
		L594.Solution o = x.new Solution();
		
		// 输入：nums = [1,3,2,2,5,2,3,7]		输出：5
		assert(o.findLHS(new int[] {1,3,2,2,5,2,3,7})==5);
		// 输入：nums = [1,2,3,4]		输出：2
		assert(o.findLHS(new int[] {1,2,3,4})==2);
		// 输入：nums = [1,1,1,1]		输出：0
		assert(o.findLHS(new int[] {1,1,1,1})==0);
	}
}
