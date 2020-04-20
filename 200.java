/******************************************************************************

200. 岛屿数量
https://leetcode-cn.com/problems/number-of-islands/

*******************************************************************************/
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;


class Solution {
    int cnt2 = 2;   // 从2开始算，实际的大陆数要减1
    public int numIslands(char[][] grid) {
        int ret = 0;

        if(grid==null || grid.length==0){
            //
        }else{
            // 先变成 int 便于计算，也免得覆盖原始 grid
            int[][] cont = new int[grid.length][grid[0].length];
            for(int i=0; i<cont.length; i++){
                for(int j=0; j<cont[0].length; j++){
                    cont[i][j] = Integer.valueOf(String.valueOf(grid[i][j]));
                }
            }
            
            // 用大陆号码填充整个大陆
            for(int i=0; i<cont.length; i++){
                for(int j=0; j<cont[0].length; j++){
                    // 只处理等于1的，因为每次chk()都会把连接在一起的一块大陆填满数字
                    if(cont[i][j]==1){
                        chk(i, j, cont, cnt2++);
                    }
                }
            }
        }
        //System.out.println("cont=" + Arrays.deepToString(cont) + " cnt2=" + cnt2);
        return cnt2-2;
    }
    // 给定未处理的一点，发现并填满整块大陆。
    void chk(int x, int y, int[][]cont, int n){
        if(chkRange(x, y, cont)){
            if(cont[x][y]==1){
                cont[x][y]=n;
                chk(x-1, y, cont, n);
                chk(x+1, y, cont, n);
                chk(x, y-1, cont, n);
                chk(x, y+1, cont, n);
            }
        }
    }
    boolean chkRange(int x, int y, int[][] grid){
        boolean ret = false;
        if(x>=0 && y>=0 && x<grid.length && y<grid[0].length){
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
    static void tbase(char[][] grid, int expect){
	    Solution o = new Solution();
	    int ret = o.numIslands(grid);
	    System.out.println("grid=" + Arrays.deepToString(grid) + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static void t1(){
	    tbase(
	        new char[][]{ 
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            },
            1
	        );
	}
	static void t2(){
	    tbase(
	        new char[][]{ 
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
            },
            3
	        );
	}
	// 不要忘记空值 2/47
	static void t3(){
	    tbase(new char[][]{},0);
	}
}

