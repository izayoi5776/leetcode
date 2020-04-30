/******************************************************************************

对角线遍历
https://leetcode-cn.com/explore/featured/card/array-and-string/199/introduction-to-2d-array/774/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int[] ret = new int[0];
        if(matrix!=null && matrix.length>0 && matrix[0].length>0){
            int M = matrix.length;
            int N = matrix[0].length;
            ret = new int[M * N];
            
            int x=0;
            int y=0;
            boolean xp = true;
            int pos = 0;
            for(int i=0; i<=M+N; i++){
                //System.out.printf("OUT i=%d x=%d y=%d xp=%b pos=%d ret=%s\n", i, x, y, xp, pos, Arrays.toString(ret));
                if(xp){
                    y = 0;
                    x = i - y;
                }else{
                    x = 0;
                    y = i - x;
                }
                do{
                    //System.out.printf("IN1 i=%d x=%d y=%d xp=%b pos=%d ret=%s\n", i, x, y, xp, pos, Arrays.toString(ret));
                    if(x>=0 && x<M && y>=0 && y<N){
                        ret[pos++] = matrix[x][y];    
                    }
                    if(xp){x--;}else{x++;}
                    y = i - x;
                }while(x>=0 && y>=0);
                //System.out.printf("IN2 i=%d x=%d y=%d xp=%b pos=%d ret=%s\n", i, x, y, xp, pos, Arrays.toString(ret));
                xp = !xp;
            }

        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[][] n, int[] expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret[] = o.findDiagonalOrder(n);
	    System.out.println("n=" + Arrays.deepToString(n) + " ret=" + Arrays.toString(ret) + " expect=" + Arrays.toString(expect) + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static void t1(){
	    tbase(new int[][]
	        {
             { 1, 2, 3 },
             { 4, 5, 6 },
             { 7, 8, 9 }
            }
	    , new int[]{1,2,4,7,5,3,6,8,9});
	}
}

