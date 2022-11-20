/******************************************************************************

1162. 地图分析
https://leetcode-cn.com/problems/as-far-from-land-as-possible/

*******************************************************************************/

import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;

class Rec{
    int x;
    int y;
    Rec(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int ret = -1;

        Queue<Rec> todo = new ArrayDeque<Rec>();
        if(grid == null){
            // ret = -1;
        }else{
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    todo.add(new Rec(i, j));
                }
            }
        }
        
        while(todo.size()>0){
            Rec cr = todo.remove(); // current record
            int val = grid[cr.x][cr.y];
            if(val==0){
                // 这一点是海洋，不管
            }else{
                chk(grid, cr.x -1, cr.y, val, todo);
                chk(grid, cr.x +1, cr.y, val, todo);
                chk(grid, cr.x, cr.y -1, val, todo);
                chk(grid, cr.x, cr.y +1, val, todo);
            }
            //System.out.println("x=" + cr.x + " y=" + cr.y + " todo=" + todo + " grid=" + Arrays.deepToString(grid) + " ret=" + ret);
        }

        // 找出最大值
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                ret = Math.max(ret, grid[i][j]);
            }
        }
        if(ret<=1){
            ret = -1;   // 没找到
        }else{
            ret -= 1;    // 因为是从1开始算的，所以减去1
        }   
        return ret;
    }
    /**
     * check point x,y in grid
     * x,y 被测试点
     * val 原始点的值，表示1=大陆，>1到大陆的距离
     */
    void chk(int[][] grid, int x, int y, int val, Queue<Rec> todo){
        if(grid != null && todo != null 
            && x>=0 && y >=0 
            && x<grid.length && y<grid[0].length){
            int cv = grid[x][y];
            if(cv==0){
                // 0 是未计算的海洋, 最先发现的一定是最小距离
                grid[x][y] = val + 1;
                todo.add(new Rec(x,y));
            }else{
                // 测试点不是海洋
                if(cv > val + 1){
                    grid[x][y] = val + 1;
                    todo.add(new Rec(x,y));
                }
            }
        }
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
    static void tbase(int[][] grid, int expect) {
	    Solution o = new Solution();
	    System.out.println("grid=" + Arrays.deepToString(grid) + " ret=" + o.maxDistance(grid) + " expect=" + expect);
	}
	static void t1(){
	    tbase(new int [][]{{1,0,1},{0,0,0},{1,0,1}}, 2);
	}
	static void t2(){
	    tbase(new int [][]{{1,0,0},{0,0,0},{0,0,0}}, 4);
	}
	static void t3(){
	    tbase(new int [][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, -1);
	}
	static void t4(){
	    tbase(new int [][]{{1}}, -1);
	}
	static void t5(){
	    tbase(new int [][]{{0}}, -1);
	}
	static void t6(){
	    tbase(new int [][]{{}}, -1);
	}
}
