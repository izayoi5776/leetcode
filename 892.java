/******************************************************************************

892. 三维形体的表面积
https://leetcode-cn.com/problems/surface-area-of-3d-shapes/

*******************************************************************************/

import java.util.Arrays;

class Solution {
    public int surfaceArea(int[][] grid) {
        int ret = 0;
        if(grid == null){
            // ret = 0;
        }else{
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    int v = grid[i][j]; // 处理中位置的值
                    ret += 6 * v - 2*(Math.max(0,v - 1)); // 每个立方体6个面，互相重叠的面 2 * (v - 1) 个
                    ret += chk(grid, i, j-1, v); // 减去和上方格子内立方体重叠的侧面
                    ret += chk(grid, i, j+1, v); // 减去和下方格子内立方体重叠的侧面
                    ret += chk(grid, i-1, j, v); // 减去和左方格子内立方体重叠的侧面
                    ret += chk(grid, i+1, j, v); // 减去和右方格子内立方体重叠的侧面
                    //System.out.println("grid=" + Arrays.deepToString(grid) + " i=" + i + " j=" + j + " v=" + v + " ret=" + ret);
                }
            }
        }
        return ret;
    }
    /**
     * 检查附近位置
     * @param grid 地图
     * @param x，y 要检查位置
     * @param v 检查对象的立方体个数 
     * 
     **/
    int chk(int[][] grid, int x, int y, int v){
        int ret = 0;
        int vc = 0;
        if(grid==null){
            //ret = 0;
        }else{
            if(x<0 || x >=grid.length || y<0 || y>=grid[0].length){
                // ret = 0;
            }else{
                vc = grid[x][y]; // 检查位置的值
                ret = -1 * Math.min(v, vc); // 相邻的侧面被遮住的量
            }
        }
        //System.out.println("grid=" + Arrays.deepToString(grid) + " x=" + x + " y=" + y + " v=" + v + " vc=" + vc + " ret=" + ret);
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
		t4();
		t5();
		t6();
	}
	static void tbase(int [][] grid, int exp){
	    Solution o = new Solution();
	    System.out.println("grid=" + Arrays.deepToString(grid) + " ret=" + o.surfaceArea(grid) + " expect=" + exp);
	}
	static void t1(){
	    int[][] grid ={{2}};
	    tbase(grid, 10);
	}
	static void t2(){
	    int[][] grid ={{2}};
	    tbase(null, 0);
	}
	static void t3(){
	    int[][] grid ={{1,2},{3,4}};
	    tbase(grid, 34);
	}
	static void t4(){
	    int[][] grid ={{1,0},{0,2}};
	    tbase(grid, 16);
	}
	static void t5(){
	    int[][] grid ={{1,1,1},{1,0,1},{1,1,1}};
	    tbase(grid, 32);
	}
	static void t6(){
	    int[][] grid ={{2,2,2},{2,1,2},{2,2,2}};
	    tbase(grid, 46);
	}

}
