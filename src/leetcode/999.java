/******************************************************************************

999. 车的可用捕获量
https://leetcode-cn.com/problems/available-captures-for-rook/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int numRookCaptures(char[][] board) {
        int ret = 0;
        if(board==null || board.length<=0 || board[0].length<=0 ){
            // ret = 0;
        }else{
            // search "R"
            int x=0;
            int y=0;
            outside:for(x=0; x<board.length; x++){
                for(y=0; y<board[0].length; y++){
                    if(board[x][y]=='R'){
                        break outside;
                    }
                }
            }
            //System.out.println("x=" + x + " y=" + y + " c=" + board[x][y]);
            // only if found
            if(x<board.length && y<board[0].length){
                ret = loop(board, x, y);
            }
        }
        return ret;
    }
    private int loop(char[][] board, int x, int y){
        int ret = 0;
        // left
        for(int i=x-1; i>=0; i--){
            int rt = chk(board[i][y]);
            if(rt>=0){
                ret += rt;
                break;
            }
        }
        // right
        for(int i=x+1; i<board.length; i++){
            int rt = chk(board[i][y]);
            if(rt>=0){
                ret += rt;
                break;
            }
        }
        // up
        for(int i=y-1; i>=0; i--){
            int rt = chk(board[x][i]);
            if(rt>=0){
                ret += rt;
                break;
            }
        }
        // down
        for(int i=y+1; i<board[0].length; i++){
            int rt = chk(board[x][i]);
            if(rt>=0){
                ret += rt;
                break;
            }
        }
        return ret;
    }
    /**
     * 检查一个位置
     * @return -1 是空位继续找
     *          0 停止，不是黑兵
     *          1 停止，是黑兵
     */
    int chk(char c){
        int ret = -1;
        switch(c){
            case '.':
                break;
            case 'p':
                ret = 1;
                break;
            default:
                ret = 0;
                break;
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
	/**
	 *  8 x 8 的棋盘上，
	 * 有一个白色车（rook） => “R”
	 * 空方块               => “.”
	 * 白色的象（bishop）   => “B”
	 * 黑色的卒（pawn）     => “p”
	 * 大写字符表示白棋，小写字符表示黑棋
	 */
	static void tbase(char[][] board, int exp){
	    Solution o = new Solution();
	    System.out.println(Arrays.deepToString(board));
	    System.out.println("ret=" + o.numRookCaptures(board) + " expect=" + exp);
	}
	static void t1(){
	    tbase(new char[][]{
    	        {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
            }
        ,3);
	}
	static void t2(){
	    tbase(new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','B','R','B','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
            }
        ,0);
	}
	static void t3(){
	    tbase(new char[][]{
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'p','p','.','R','.','p','B','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
            }
        ,3);
	}

}

