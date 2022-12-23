package leetcode;

// 812. 最大三角形面积
public class L812 {
	public class Solution {
		public double largestTriangleArea(int[][] points) {
			int [][] p = points;
			double max = 0;
			for (int i = 0; i < points.length-2; i++) {
				for (int j = 1; j < points.length-1; j++) {
					for (int k = 2; k < points.length; k++) {
						double c = tsize(p[i][0], p[i][1], p[j][0], p[j][1], p[k][0], p[k][1]);
						if(c>max) {
							max = c;
						}
					}
				}
			}
			return max;
		}
		/**
		 * 从3点坐标算三角形面积
		 * S = 1/2 * |(x2-x1)(y3-y1)-(x3-x1)(y2-y1)|
		 */
		double tsize(int x1, int y1, int x2, int y2, int x3, int y3) {
			double s = 0.5 * Math.abs((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
			return s;
		}
	}
	public static void main(String[] args){
		L812 x = new L812();
		L812.Solution o = x.new Solution();
		
		// 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]		输出: 2
		assert(o.largestTriangleArea(new int[][] {{0,0},{0,1},{1,0},{0,2},{2,0}})==2.0);
	}
}
