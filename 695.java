/******************************************************************************

695. 岛屿的最大面积
https://leetcode-cn.com/problems/max-area-of-island/

*******************************************************************************/

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null     ){ return 0; }
        if(grid.length<=0   ){ return 0; }
        if(grid[0].length<=0){ return 0; }
        Map<Integer, Map<Integer, Integer> > mp = new HashMap<Integer, Map<Integer, Integer> >();
        for(int i=0; i<grid.length; i++){
            Map<Integer, Integer> m1row = new HashMap<Integer, Integer>();
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    m1row.put(j, 1);
                }
            }
            mp.put(i, m1row);
        }
        return chk(mp);
    }
    /**
     * 特定地点的
     * a  IN  开始位置x
     * b  IN  开始位置y
     * mp I/O 剩余地图
     * @ret   x,y这一点的岛屿面积
     */
    private int chkone(int x, int y, Map<Integer, Map<Integer, Integer> > mp){
        if(!mp.containsKey(x)){
            return 0;
        }else if(!mp.get(x).containsKey(y)){
            return 0;
        }else{
            mp.get(x).remove(y);
            int cup   = chkone(x, y-1, mp);
            int cleft = chkone(x-1, y, mp);
            int cright= chkone(x+1, y, mp);
            int cdown = chkone(x, y+1, mp);
            return 1 + cup + cleft + cright + cdown;
        }
    }
    /**
     * mp 地图
     */
    private int chk(Map<Integer, Map<Integer, Integer> > mp){
        int ret = 0;
        while(true){
            // 全部处理完为止
            if(mp.isEmpty()){
                break;
            }
            // 行为空则删除
            Integer x = mp.keySet().iterator().next();
            if(mp.get(x).isEmpty()){
                mp.remove(x);
                continue;
            }
            Integer y = mp.get(x).keySet().iterator().next();
            ret = Math.max(ret, chkone(x, y, mp));
        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t3();
	}
	private static void t1(){
	    int[][] grid ={
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
	    };
        Solution o = new Solution();
        System.out.println("" + o.maxAreaOfIsland(grid)); // should be 6
	}
	private static void t2(){
	    int[][] grid = {{0,0,0,0,0,0,0,0}}; // should be 0
	    tbase(grid);
	}
	private static void t3(){
	    int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}; // should be 4
	    tbase(grid);
	}
	
	private static void tbase(int[][] grid){
        Solution o = new Solution();
        System.out.println("" + o.maxAreaOfIsland(grid)); // should be 6
	}
}
