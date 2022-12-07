package leetcode;

import java.util.Arrays;

// 575. 分糖果
public class L575 {
	public class Solution {
		public int distributeCandies(int[] candyType) {
			long cnt = Arrays.stream(candyType).distinct().count();
			
			return (int) Math.min(cnt, candyType.length/2);
		}
	}
	
	public static void main(String[] args){
		L575 x = new L575();
		L575.Solution o = x.new Solution();
		
		// 输入：candyType = [1,1,2,2,3,3]		输出：3
		assert(o.distributeCandies(new int[] {1,1,2,2,3,3})==3);
		// 输入：candyType = [1,1,2,3]		输出：2
		assert(o.distributeCandies(new int[] {1,1,2,3})==2);
		// 输入：candyType = [6,6,6,6]		输出：1
		assert(o.distributeCandies(new int[] {6,6,6,6})==1);
	}
}
