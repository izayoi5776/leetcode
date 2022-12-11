package leetcode;

import java.util.Arrays;

// 645. 错误的集合
public class L645 {
	public class Solution {
		public int[] findErrorNums(int[] nums) {
			// 排序
			int[] n2 = Arrays.stream(nums).sorted().toArray();
			int fix = 1;
			int ret[] = new int[2];
			for(int i=0; i<n2.length; i++) {
				// 排序后，位置 i 的值应该是 i+1
				if(n2[i]==i+fix) {
					continue;
				}
				// 这里找到的可能是重复，也可能是跳跃
				if(n2[i]<i+fix) {
					// 重复
					ret[0] = n2[i];
					fix--;
				} else {
					// 跳跃
					ret[1] = n2[i]-1;
					fix++;
					i--;
				}
			}
			if(ret[1]==0) {
				ret[1] = n2.length;
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L645 x = new L645();
		L645.Solution o = x.new Solution();
		
		// 输入：nums = [1,2,2,4]		输出：[2,3]
		assert(Arrays.equals(o.findErrorNums(new int[] {1,2,2,4}), new int[] {2,3}));
		assert(Arrays.equals(o.findErrorNums(new int[] {1,2,2,3}), new int[] {2,4}));
		assert(Arrays.equals(o.findErrorNums(new int[] {1,2,2,3,4}), new int[] {2,5}));
		assert(Arrays.equals(o.findErrorNums(new int[] {1,3,3,4}), new int[] {3,2}));
		assert(Arrays.equals(o.findErrorNums(new int[] {1,3,3,4,5}), new int[] {3,2}));
		// 输入：nums = [1,1]		输出：[1,2]
		assert(Arrays.equals(o.findErrorNums(new int[] {1,1}),new int[] {1,2}));
	}
}
