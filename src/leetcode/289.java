/******************************************************************************

289. 生命游戏
https://leetcode-cn.com/problems/game-of-life/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null){
            // do nothing
        }else{
            // backup
            int[][] bk = new int[board.length][board[0].length];
            for(int i=0;i<board.length;i++){
                System.arraycopy(board[i], 0, bk[i], 0, board[i].length);    
            }
            
            // run world
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    chk(bk, i, j, board);
                }
            }
        }
    }
    /**
     * 计算，x,y 位置
     * bk 是变更前棋盘
     * board 是要变更的棋盘
     * 
     */
    void chk(int[][] bk, int x, int y, int[][] board){
        // 计算周围的 1 的个数
        int sum = 0;
        for(int i=Math.max(0, x-1); i<=x+1 && i<board.length; i++){
            for(int j=Math.max(0, y-1); j<=y+1 && j<board[0].length; j++){
                sum += bk[i][j];
                //System.out.println("x=" + x + " y=" + y + " i=" + i + " j=" + j + " sum=" + sum);
            }
        }
        sum -= bk[x][y];
        //System.out.println("x=" + x + " y=" + y + " sum=" + sum + " board=" + Arrays.deepToString(board));

        int next = 0;
        if(bk[x][y]==1){
            if(sum < 2 || sum > 3){
                // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                // next = 0;
            }else{
                // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                next = 1;
            }
        }else{
            // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
            if(sum == 3){
                next = 1;
            }
        }
        board[x][y] = next;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[][] board, int[][] expect){
	    Solution o = new Solution();
	    System.out.println("board=" + Arrays.deepToString(board));
	    o.gameOfLife(board);
	    System.out.println("ret=" + Arrays.deepToString(board) + " expect=" + Arrays.deepToString(expect));
	}
	static void t1(){
	    tbase(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}}, 
	        new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,1,0}});
	}
}
