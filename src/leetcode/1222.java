/******************************************************************************

1222. 可以攻击国王的皇后
https://leetcode-cn.com/problems/queens-that-can-attack-the-king/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int [][] bd = new int[8][8]; // checkerboard 棋盘
        for(int i=0;i<queens.length;i++){
            bd[queens[i][0]][queens[i][1]] = 1;
        }
        System.out.println("bd=" + Arrays.deepToString(bd));
        
        chk(bd, king, -1, 0, ret); // left
        chk(bd, king,  1, 0, ret); // right
        chk(bd, king,  0,-1, ret); // down
        chk(bd, king,  0, 1, ret); // up
        chk(bd, king, -1,-1, ret); // left-up
        chk(bd, king, -1, 1, ret); // left-down
        chk(bd, king,  1,-1, ret); // right-down
        chk(bd, king,  1, 1, ret); // right-up

        return ret;
    }
    /**
     * 指定的 king 位置开始，指定的 x y 方向查询 Q 的存在
     * x  x方向增量，取值 -1，0，1
     * y  y方向增量，取值 -1，0，1
     */
    void chk(int[][] bd, int[] king, int x, int y, List<List<Integer>> out){
        List<Integer> ret = new ArrayList<Integer>();
        int i=0;
        int j=0;
        for(i=king[0]+x, j=king[1]+y; i<8 && i>=0 && j<8 && j>=0; i=i+x, j=j+y){
            //System.out.println("x=" + x + " y=" + y + " i=" + i + " j=" + j + " bd[i][j]=" + bd[i][j] + " ret=" + ret);
            if(bd[i][j]>=1){
                ret.add(i);
                ret.add(j);
                break;
            }
        }
        
        if(ret.size()>0){
            out.add(ret);
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
    static void tbase(int[][] queens, int[] king, int[][] expect){
	    Solution o = new Solution();
	    System.out.println("queens=" + Arrays.deepToString(queens) + " king=" + Arrays.toString(king) +" ret=" + o.queensAttacktheKing(queens, king) + " expect=" + Arrays.deepToString(expect));
	}
	static void t1(){
	    tbase(new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[]{0,0}, new int[][]{{0,1},{1,0},{3,3}});
	}
	static void t2(){
	    tbase(new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}}, new int[]{3,3}, new int[][]{{2,2},{3,4},{4,4}});
	}
	static void t3(){
	    tbase(new int[][]{{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}},
	        new int[]{3,4},
	        new int[][]{{2,3},{1,4},{1,6},{3,7},{4,3},{5,4},{4,5}});
	}
}
