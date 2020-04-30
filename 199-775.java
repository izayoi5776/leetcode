/******************************************************************************

螺旋矩阵
https://leetcode-cn.com/explore/featured/card/array-and-string/199/introduction-to-2d-array/775/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix!=null && matrix.length>0 && matrix[0].length>0){
            int M = matrix.length;
            int N = matrix[0].length;
            int dir = 0; // 右转的次数
            
            int x = 0;
            int y = 0;
            while(ret.size()<M*N){
                System.out.printf("x=%d y=%d dir=%d ret=%s\n", x, y, dir, ret);
                ret.add(matrix[x][y]);
                switch(dir % 4){
                    case 0:     // 向右
                        if(y < N - dir / 4 - 1){
                            y++;
                        }else{
                            x++;
                            dir++;
                        }
                        break;
                    case 1:     // 向下
                        if(x < M - dir / 4 -1 ){
                            x++;
                        }else{
                            y--;
                            dir++;
                        }
                        break;
                    case 2:     // 向左
                        if(y > 0 + dir / 4){
                            y--;
                        }else{
                            x--;
                            dir++;
                        }
                        break;
                    case 3:     // 向上
                        if(x > 0 + dir / 4 + 1){
                            x--;
                        }else{
                            y++;
                            dir++;
                        }
                        break;
                }
            }
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int[][] n, int[] expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    List<Integer> ret = o.spiralOrder(n);
	    System.out.println("n=" + Arrays.deepToString(n) + " ret=" + (ret) + " expect=" + Arrays.toString(expect) + (chk(ret,expect)?" OK":" NG"));
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
	    , new int[]{1,2,3,6,9,8,7,4,5});
	}
	static void t2(){
	    tbase(new int[][]
            {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9,10,11,12}
            }
	    , new int[]{1,2,3,4,8,12,11,10,9,5,6,7});
	}
}

