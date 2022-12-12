package leetcode;

import java.util.Arrays;

// 661. 图片平滑器
public class L661 {
	public class Solution {
		public int[][] imageSmoother(int[][] img) {
			int[][] ret = new int[img.length][img[0].length];
			for(int i=0; i<img.length; i++) {
				for(int j=0; j<img[0].length; j++) {
					ret[i][j] = avg(img, i, j);
				}
			}
			return ret;
		}
		/**
		 * 求一个平均数 
		 */
		int avg(int[][] img, int m, int n){
			int sum = 0;
			int cnt = 0;
			for(int i=m-1; i<=m+1; i++) {
				for(int j=n-1; j<=n+1; j++) {
					Integer t = get(img, i, j);
					if(t==null) {
						continue;
					}
					sum += t;
					cnt++;
				}
			}
			int avg = sum / cnt;
			return avg;
		}
		/**
		 * 从数组指定位置取值，取不到返回null
		 */
		Integer get(int[][] img, int i, int j){
			try{
				return img[i][j];
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	public static void main(String[] args){
		L661 x = new L661();
		L661.Solution o = x.new Solution();
		
		// 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
		// 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
		assert(Arrays.deepEquals(o.imageSmoother(new int[][] {{1,1,1},{1,0,1},{1,1,1}}),
				new int[][] {{0, 0, 0},{0, 0, 0}, {0, 0, 0}}));
		// 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
		// 输出: [[137,141,137],[141,138,141],[137,141,137]]
		assert(Arrays.deepEquals(o.imageSmoother(new int[][] {{100,200,100},{200,50,200},{100,200,100}}),
				new int[][] {{137,141,137},{141,138,141},{137,141,137}}));
	}
}
