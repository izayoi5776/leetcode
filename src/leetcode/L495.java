package leetcode;

import java.util.Arrays;

// 495. van提莫攻击
public class L495 {
	public class Solution {
		public int findPoisonedDuration(int[] timeSeries, int duration) {
			int sum = 0;
			for(int i=0; i<timeSeries.length; i++) {
				int d = 0;
				if(i==timeSeries.length-1) {
					d = duration;
				} else {
					d = Math.min(duration, timeSeries[i+1]-timeSeries[i]);
				}
				
				sum += d;
			}
			return sum;
		}
	}
	
	public static void main(String[] args){
		L495 x = new L495();
		L495.Solution o = x.new Solution();
		
		// 输入：timeSeries = [1,4], duration = 2		输出：4
		assert(o.findPoisonedDuration(new int[] {1,4},2)==4);
		// 输入：timeSeries = [1,2], duration = 2		输出：3
		assert(o.findPoisonedDuration(new int[] {1,2},2)==3);
	}
}
