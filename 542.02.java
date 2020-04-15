/******************************************************************************

542. 01 矩阵
https://leetcode-cn.com/problems/01-matrix/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        // 初始化，所有0都设置0，其他都设置-1
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    ret[i][j]=0;
                }else{
                    ret[i][j]=-1;
                }
            }
        }
        int lvl = 0;
        while(chk(ret, lvl)){
            lvl++;
        }
        return ret;
    }
    // vec 中未处理（=-1）的，周围有层级lvl的话，加一级
    // vec 检查对象，lvl 检查层级
    boolean chk(int[][]vec, int lvl){
        boolean ret = false;
        for(int i=0; i<vec.length; i++){
            for(int j=0; j<vec[0].length; j++){
                if(vec[i][j]==-1){
                    // 未处理的cell
                    // 如果周围有n，自己就是n+1
                    if(    chkN(vec, i-1,j, lvl)
                        || chkN(vec, i+1,j, lvl) 
                        || chkN(vec, i,j-1, lvl) 
                        || chkN(vec, i,j+1, lvl) ){
                        vec[i][j] = lvl+1;
                    }
                    ret = true;
                }
            }
        }
        return ret;
    }
    // 检查指定位置是否为n，非法位置false
    boolean chkN(int[][] vec, int x, int y, int n){
        boolean ret = false;
        if(chkRange(vec, x, y)){
            ret = vec[x][y] == n;
        }
        return ret;
    }
    // 检查位置 x,y 是否合法，非法返回false
    boolean chkRange(int[][] matrix, int x, int y){
        boolean ret = false;
        if(matrix!=null && x>=0 && y>=0 && x<matrix.length && y<matrix[0].length){
            ret = true;
        }
        return ret;
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
	    int[][] ret = o.updateMatrix(matrix);
	    System.out.println("matrix" + Arrays.deepToString(matrix) + " ret=" + Arrays.deepToString(ret) + " expect=" + Arrays.deepToString(expect) + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int[][] youret, int[][] expect){
	    return Arrays.deepEquals(youret, expect);
	}
	static void t1(){
	    tbase(
	        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
	        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
	   );
	}
	static void t2(){
	    tbase(
	        new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
	        new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}
	   );
	}
	static void t3(){
	    tbase(
	        new int[][]{{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}},
	        new int[][]{{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,2,1,1,0,1},{2,1,1,1,1,2,1,0,1,0},{3,2,2,1,0,1,0,0,1,1}}
	   );
	}
}







