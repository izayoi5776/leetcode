/******************************************************************************

面试题 01.07. 旋转矩阵
https://leetcode-cn.com/problems/rotate-matrix-lcci/

*******************************************************************************/
import java.util.Arrays;
import java.util.Objects;

class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length-1;
        for(int j=0; j<N/2+1; j++){
            //System.out.println(" j=" + j);
            for(int i=j; i<N-j; i++){
                //System.out.println("i=" + i + " j=" + j);
                int t = matrix[j][i];
                chk(matrix, j, i, 3);
                //System.out.println("mat=" + Arrays.deepToString(matrix) + " i=" + i + " j=" + j);
                matrix[i][N-j] = t;
            }
        }
    }
    /**
     * 计算一组数字，其中(x,y)是被保护的，可以覆盖
     * 
     * 循环的特征是
     * x(n-1) = N - y(n)
     * y(n-1) = x(n)
     */
    void chk(int[][]mat, int x, int y, int n){
        //System.out.println("mat=" + Arrays.deepToString(mat) + " x=" + x + " y=" + y + " n=" + n);
        int N = mat.length-1;
        if(n >= 0){
            int xn1 = N - y;
            int yn1 = x;
            mat[x][y] = mat[xn1][yn1];
            chk(mat, xn1, yn1, n-1);
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
    static void tbase(int[][] matrix, int[][] expect){
	    Solution o = new Solution();
	    o.rotate(matrix);
	    System.out.println(" ret=" + Arrays.deepToString(matrix) + " expect=" + Arrays.deepToString(expect) + (Objects.deepEquals(matrix, expect)?" OK":" NG"));
	}
	static void t1(){
	    tbase(new int[][]{
          {1,2,3},
          {4,5,6},
          {7,8,9}
        }, 
        new int[][]{
          {7,4,1},
          {8,5,2},
          {9,6,3}
        }
        );
	}
	static void t2(){
	    tbase(new int[][]{
          { 5, 1, 9,11},
          { 2, 4, 8,10},
          {13, 3, 6, 7},
          {15,14,12,16}
        }, 
        new int[][]{
          {15,13, 2, 5},
          {14, 3, 4, 1},
          {12, 6, 8, 9},
          {16, 7,10,11}
        }
        );
	}
	static void t3(){
	    tbase(new int[][]{
          {1,2},
          {3,4}
        }, 
        new int[][]{
          {3,1},
          {4,2}
        }
        );
	}
}

