package leetcode;

import java.util.Arrays;

// 566. 重塑矩阵
public class L566 {
	public class Solution {
		public int[][] matrixReshape(int[][] mat, int r, int c) {
			if(mat==null) {
				return null;
			}
			int m = mat.length;
			int n = mat[0].length;
			if(m * n != r * c) {
				return mat;
			}
			
			int[][] ret = new int[r][c];
			int rx = 0;
			int cx = 0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					ret[rx][cx]= mat[i][j];
					cx++;
					if(cx>=c) {
						rx++;
						cx=0;
					}
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L566 x = new L566();
		L566.Solution o = x.new Solution();
		
		// 输入：mat = [[1,2],[3,4]], r = 1, c = 4		输出：[[1,2,3,4]]
		assert(Arrays.deepEquals(o.matrixReshape(new int[][] {{1,2},{3,4}}, 1, 4), new int[][] {{1,2,3,4}}));
		// 输入：mat = [[1,2],[3,4]], r = 2, c = 4		输出：[[1,2],[3,4]]
		assert(Arrays.deepEquals(o.matrixReshape(new int[][] {{1,2},{3,4}}, 2 ,4), new int[][] {{1,2},{3,4}}));
	}
}
