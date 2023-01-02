package leetcode;

import java.util.Arrays;

// 867. 转置矩阵
public class L867 {
	public class Solution {
		public int[][] transpose(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			int[][] ret = new int[n][m];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					ret[j][i] = matrix[i][j];
				}
			}
			return ret;
		}
	}
	public static void main(String[] args){
		L867 x = new L867();
		L867.Solution o = x.new Solution();
		
		// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]		输出：[[1,4,7],[2,5,8],[3,6,9]]
		assert(Arrays.deepEquals(o.transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}}), new int[][] {{1,4,7},{2,5,8},{3,6,9}}));
		
		// 输入：matrix = [[1,2,3],[4,5,6]]		输出：[[1,4],[2,5],[3,6]]
		assert(Arrays.deepEquals(o.transpose(new int[][] {{1,2,3},{4,5,6}}), new int[][] {{1,4},{2,5},{3,6}}));

	}
}
