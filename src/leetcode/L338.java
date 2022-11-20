package leetcode;

import java.util.Arrays;

// 338. 比特位计数
public class L338 {
	
	class Solution {
		public int[] countBits(int n) {
			int[] ret = new int[n+1];
			for(int i=0; i<=n; i++) {
				ret[i] = Integer.bitCount(i);
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L338 x = new L338();
		L338.Solution o = x.new Solution();
		
		// 输入：n = 2		输出：[0,1,1] 
		System.out.println(Arrays.toString(o.countBits(2)));
		// 输入：n = 5		输出：[0,1,1,2,1,2]
		System.out.println(Arrays.toString(o.countBits(5)));
		
	}
}
