package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 728. 自除数
public class L728 {
	public class Solution {
		public List<Integer> selfDividingNumbers(int left, int right) {
			List<Integer> ls = new ArrayList<>();
			for(int i=left; i<=right; i++) {
				if(chk(i)) {
					ls.add(i);	
				}
			}
			return ls;
		}
		/**
		 * 判断是否是自除数
		 */
		boolean chk(int n){
			String s = String.valueOf(n);
			for(int i=0; i<s.length(); i++) {
				if(s.contains("0")) {
					return false;
				}
				if(s.length()==1) {
					return true;
				}
				int c = Integer.valueOf(s.substring(i, i+1));
				if(c==1) {
					continue;
				}
				if(n%c!=0) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args){
		L728 x = new L728();
		L728.Solution o = x.new Solution();
		
		// 输入：left = 1, right = 22		输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
		assert(Arrays.equals(o.selfDividingNumbers(1,22).toArray(new Integer[0]),
				new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22}));
		// 输入：left = 47, right = 85		输出：[48,55,66,77]
		assert(Arrays.equals(o.selfDividingNumbers(47,85).toArray(new Integer[0]),
				new Integer[] {48,55,66,77}));
	
	}
}
