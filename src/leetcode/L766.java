package leetcode;

// 766. 托普利茨矩阵
public class L766 {
	public class Solution {
		public boolean isToeplitzMatrix(int[][] matrix) {
			// 列
			for(int i=1-matrix.length; i<matrix[0].length; i++) {
				Integer chk = null;
				// 行
				for(int j=0; j<matrix.length; j++) {
					if(i+j<0 || i+j>=matrix[0].length) {
						continue;
					}
					int v = matrix[j][i+j];
					if(chk==null) {
						chk = v;
					} else {
						if(v!=chk) {
							return false;
						}
					}
				}
			}
			
			return true;
		}
	}
	public static void main(String[] args){
		L766 x = new L766();
		L766.Solution o = x.new Solution();
		
		// 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]		输出：true
		assert(o.isToeplitzMatrix(new int[][] {{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
		// 输入：matrix = [[1,2],[2,2]]		输出：false
		assert(!o.isToeplitzMatrix(new int[][] {{1,2},{2,2}}));
	}
}
