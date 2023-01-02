package leetcode;

import java.util.Arrays;

// 832. 翻转图像
public class L832 {
	public class Solution {
		public int[][] flipAndInvertImage(int[][] image) {
			int m = image.length;
			int n = image[0].length;
			int[][] ret = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					ret[i][j] = image[i][n-j-1]==0 ? 1 : 0;
				}
			}
			return ret;
		}
	}
	public static void main(String[] args){
		L832 x = new L832();
		L832.Solution o = x.new Solution();
		
		// 输入：image = [[1,1,0],[1,0,1],[0,0,0]]		输出：[[1,0,0],[0,1,0],[1,1,1]]
		assert(Arrays.deepEquals(o.flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}}),
				new int[][] {{1,0,0},{0,1,0},{1,1,1}}));
		
		// 输入：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
		// 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
		assert(Arrays.deepEquals(o.flipAndInvertImage(new int[][] {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}),
				new int[][] {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}}));

	}
}
