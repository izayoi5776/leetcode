package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// 888. 公平的糖果交换
public class L888 {
	public class Solution {
		public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
			int[] ret = new int[2];
			int s1 = Arrays.stream(aliceSizes).sum();
			int s2 = Arrays.stream(bobSizes).sum();
			int diff = (s1 - s2) / 2;
			Set<Integer> st1 = Arrays.stream(aliceSizes).boxed().collect(Collectors.toSet());
			//Set<Integer> st2 = Arrays.stream(bobSizes).boxed().collect(Collectors.toSet());
			for (int i = 0; i < bobSizes.length; i++) {
				int n = bobSizes[i];
				int exp = n + diff;
				if(st1.contains(exp)) {
					ret[1] = n;
					ret[0] = exp;
					break;
				}
			}
			return ret;
		}
	}
	public static void main(String[] args){
		L888 x = new L888();
		L888.Solution o = x.new Solution();
		
		// 输入：aliceSizes = [1,1], bobSizes = [2,2]		输出：[1,2]
		assert(Arrays.equals(o.fairCandySwap(new int[] {1,1}, new int[] {2,2}), new int[] {1,2}));
		
		// 输入：aliceSizes = [1,2], bobSizes = [2,3]		输出：[1,2]
		assert(Arrays.equals(o.fairCandySwap(new int[] {1,2}, new int[] {2,3}), new int[] {1,2}));

		// 输入：aliceSizes = [2], bobSizes = [1,3]		输出：[2,3]
		assert(Arrays.equals(o.fairCandySwap(new int[] {2}, new int[] {1,3}), new int[] {2,3}));
		
		// 输入：aliceSizes = [1,2,5], bobSizes = [2,4]		输出：[5,4]
		assert(Arrays.equals(o.fairCandySwap(new int[] {1,2,5}, new int[] {2,4}), new int[] {5,4}));
	}
}
