package leetcode;

import java.util.Arrays;

// 492. 构造矩形
public class L492 {
	public class Solution {
		public int[] constructRectangle(int area) {
			int[] ret = new int[2];
			for(int i=(int) Math.ceil(Math.sqrt(area)); i<=area; i++) {
				if(area % i == 0) {
					ret[0] = i;
					ret[1] = area/i;
					return ret;
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L492 x = new L492();
		L492.Solution o = x.new Solution();
		
		// 输入: 4		输出: [2, 2]
		System.out.println(Arrays.toString(o.constructRectangle(4)));
		// 输入: area = 37		输出: [37,1]
		System.out.println(Arrays.toString(o.constructRectangle(37)));
		// 输入: area = 122122		输出: [427,286]
		System.out.println(Arrays.toString(o.constructRectangle(122122)));
		System.out.println(Arrays.toString(o.constructRectangle(2)));
	}
}
