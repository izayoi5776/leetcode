package leetcode;

import java.util.Arrays;

// 598. 范围求和 II
public class L598 {
	public class Solution {
		public int maxCount(int m, int n, int[][] ops) {
			// 问题等价于 求 min(ai) * min(bi)
			int ai = Arrays.stream(ops).mapToInt(x -> x[0]).min().orElse(m);
			int bi = Arrays.stream(ops).mapToInt(x -> x[1]).min().orElse(n);
			return ai*bi;
		}
	}
	
	public static void main(String[] args){
		L598 x = new L598();
		L598.Solution o = x.new Solution();
		
		// 输入: m = 3, n = 3，ops = [[2,2],[3,3]]		输出: 4
		assert(o.maxCount(3, 3, new int[][] {{2,2},{3,3}})==4);
		// 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],
		//                            [3,3],[3,3],[3,3],[2,2],[3,3],
		//                            [3,3],[3,3]]		输出: 4
		assert(o.maxCount(3,3,new int[][] {{2,2},{3,3},{3,3},{3,3},{2,2},
			{3,3},{3,3},{3,3},{2,2},{3,3},
			{3,3},{3,3},})==4);
		// 输入: m = 3, n = 3, ops = []		输出: 9
		assert(o.maxCount(3,3,new int[][] {})==9);
	}
}
