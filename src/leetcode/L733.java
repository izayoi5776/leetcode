package leetcode;

import java.util.Arrays;
import java.util.BitSet;

// 733. 图像渲染
public class L733 {
	public class Solution {
		public int[][] floodFill(int[][] image, int sr, int sc, int color) {
			BitSet bs = new BitSet(image.length * image[0].length);
			// 搜索地图，结果放在 bs 里
			chk(image, bs, image[sr][sc], sr, sc);
			
			int pos = bs.nextSetBit(0);
			while(pos!=-1) {
				int m = pos/image[0].length;
				int n = pos%image[0].length;
				image[m][n] = color;
				pos = bs.nextSetBit(pos+1);
			}
			return image;
		}
		void chk(int[][] image, BitSet bs, int val, int m, int n){
			// 越界的不看
			if(m<0 || n<0 || m>=image.length || n>=image[0].length) {
				return;
			}
			int c = m * image[0].length + n;
			// 查过的不看
			if(bs.get(c)) {
				return;
			}
			// 值不对的不看
			if(image[m][n]!=val) {
				return;
			}
			// 加上自己
			bs.set(c);
			// 要相连才行
			// 上
			if(m>0) {
				if(image[m-1][n]==val) {
					chk(image, bs, val, m-1, n);		
					chk(image, bs, val, m-1, n-1);
					chk(image, bs, val, m-1, n+1);
				}
			}
			// 下
			if(m<image.length-1) {
				if(image[m+1][n]==val) {
					chk(image, bs, val, m+1, n);
					chk(image, bs, val, m+1, n-1);
					chk(image, bs, val, m+1, n+1);
				}
			}
			// 左
			if(n>0) {
				if(image[m][n-1]==val) {
					chk(image, bs, val, m, n-1);
					chk(image, bs, val, m-1, n-1);
					chk(image, bs, val, m+1, n-1);
				}
			}
			// 右
			if(n<image[0].length-1) {
				if(image[m][n+1]==val) {
					chk(image, bs, val, m, n+1);	
					chk(image, bs, val, m-1, n+1);
					chk(image, bs, val, m+1, n+1);
				}
			}
		}
	}
	public static void main(String[] args){
		L733 x = new L733();
		L733.Solution o = x.new Solution();
		
		// 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
		// 输出: [[2,2,2],[2,2,0],[2,0,1]]
		assert(Arrays.deepEquals(o.floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}},1,1,2),
				new int[][] {{2,2,2},{2,2,0},{2,0,1}}));
		// 输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
		// 输出: [[2,2,2],[2,2,2]]
		assert(Arrays.deepEquals(o.floodFill(new int[][] {{0,0,0},{0,0,0}},0,0,2),
				new int[][] {{2,2,2},{2,2,2}}));
	
	}
}
