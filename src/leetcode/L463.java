package leetcode;

// 463. 岛屿的周长
public class L463 {
	public class Solution {
		public int islandPerimeter(int[][] grid) {
			int ret = 0;
			int a = grid.length;
			int b = grid[0].length;
			for(int i=0; i<a; i++) {
				for(int j=0; j<b; j++) {
					if(grid[i][j]==1) {
						int l = i<=0   ? 1 : grid[i-1][j]==0 ? 1 : 0;
						int r = i>=a-1 ? 1 : grid[i+1][j]==0 ? 1 : 0;
						int t = j<=0   ? 1 : grid[i][j-1]==0 ? 1 : 0;
						int m = j>=b-1 ? 1 : grid[i][j+1]==0 ? 1 : 0;
						ret += l + r + t + m;
					}
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L463 x = new L463();
		L463.Solution o = x.new Solution();
		
		// 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]		输出：16
		assert(o.islandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}})==16);
		// 输入：grid = [[1]]		输出：4
		assert(o.islandPerimeter(new int[][] {{1}})==4);
		// 输入：grid = [[1,0]]		输出：4
		assert(o.islandPerimeter(new int[][] {{1,0}})==4);
	}
}
