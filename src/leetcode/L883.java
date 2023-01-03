package leetcode;

// 883. 三维形体投影面积
public class L883 {
	public class Solution {
		public int projectionArea(int[][] grid) {
			int xy = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					int n = grid[i][j];
					if(n>0) {
						xy+=1;
					}
				}
			}
			int zx = 0;
			for (int i = 0; i < grid.length; i++) {
				int max = 0;
				for (int j = 0; j < grid[0].length; j++) {
					int n = grid[i][j];
					if(max<n) {
						max=n;
					}
				}
				zx+=max;
			}
			int zy = 0;
			for (int i = 0; i < grid[0].length; i++) {
				int max = 0;
				for (int j = 0; j < grid.length; j++) {
					int n = grid[j][i];
					if(max<n) {
						max=n;
					}
				}
				zy+=max;
			}
									
			return xy + zx + zy;
		}
	}
	public static void main(String[] args){
		L883 x = new L883();
		L883.Solution o = x.new Solution();
		
		// 输入：[[1,2],[3,4]]		输出：17
		assert(o.projectionArea(new int[][] {{1,2},{3,4}})==17);
		
		// 输入：grid = [[2]]		输出：5
		assert(o.projectionArea(new int[][] {{2}})==5);

		// 输入：[[1,0],[0,2]]		输出：8
		assert(o.projectionArea(new int[][] {{1,0},{0,2}})==8);
		
	}
}
