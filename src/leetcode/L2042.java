package leetcode;

import java.util.Arrays;

// 2042. 检查句子中的数字是否递增
public class L2042 {
	public class Solution {
		public boolean areNumbersAscending(String s) {
			int[] sa = Arrays.stream(s.split(" "))
					.filter(f->f.matches("[0-9]+"))
					.mapToInt(f->Integer.valueOf(f))
					.toArray();
			for (int i = 1; i < sa.length; i++) {
				if(sa[i]<=sa[i-1]) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args){
		L2042 x = new L2042();
		L2042.Solution o = x.new Solution();
		
		// 输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"		输出：true
		assert(o.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
		
		// 输入：s = "hello world 5 x 5"		输出：false
		assert(!o.areNumbersAscending("hello world 5 x 5"));

		// 输入：s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"		输出：false
		assert(!o.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
		
		// 输入：s = "4 5 11 26"		输出：true
		assert(o.areNumbersAscending("4 5 11 26"));
	}
}
