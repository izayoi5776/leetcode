package leetcode;

import java.util.Arrays;

// 628. 三个数的最大乘积
public class L628 {
	public class Solution {
		public int maximumProduct(int[] nums) {
			// 等价于求 nums 中3个最大数（全大于0）
			// 有负数，也看最小两个负数的乘积
			int[] st = Arrays.stream(nums).sorted().toArray();
			int n = st.length;
			int m1 = st[n-1] * st[n-2] * st[n-3];
			int m2 = st[n-1] * st[0] * st[1];
			return Math.max(m1, m2);
		}
	}
	
	public static void main(String[] args){
		L628 x = new L628();
		L628.Solution o = x.new Solution();
		
		// 输入：nums = [1,2,3]		输出：6
		assert(o.maximumProduct(new int[] {1,2,3})==6);
		// 输入：nums = [1,2,3,4]		输出：24
		assert(o.maximumProduct(new int[] {1,2,3,4})==24);
		// 输入：nums = [-1,-2,-3]		输出：-6
		assert(o.maximumProduct(new int[] {-1,-2,-3})==-6);
		assert(o.maximumProduct(new int[] {-1,-2,-3, 0 ,1, 2})==12);
		assert(o.maximumProduct(new int[] {0 ,1, 2})==0);
		assert(o.maximumProduct(new int[] {-1,-2,-3,0})==0);
		assert(o.maximumProduct(new int[] {-1,-1,-1})==-1);
	}
}
