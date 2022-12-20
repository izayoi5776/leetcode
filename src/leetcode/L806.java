package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 806. 写字符串需要的行数
public class L806 {
	public class Solution {
		public int[] numberOfLines(int[] widths, String s) {
			int sum = 0;
			int line = 1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int n = c - 'a';
				int sz = widths[n];
				if(sum+sz>100) {
					line++;
					sum=0;
				}
				sum += sz;
			}
			int[] ret = new int[2];
			ret[0] = line;
			ret[1] = sum;
			return ret;
		}
	}
	public static void main(String[] args){
		L806 x = new L806();
		L806.Solution o = x.new Solution();
		
		// 输入: widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
		//	S = "abcdefghijklmnopqrstuvwxyz"				输出: [3, 60]
		assert(Arrays.equals(o.numberOfLines(new int[] {10,10,10,10,10,10,10,10,10,10,10,10,
				10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz")
				,new int[]{3,60}));
		// 输入: widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
		// S = "bbbcccdddaaa"			输出: [2, 4]
		assert(Arrays.equals(o.numberOfLines(new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,
				10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa")
				,new int[] {2,4}));
	}
}
