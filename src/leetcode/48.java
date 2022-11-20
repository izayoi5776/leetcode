/******************************************************************************

48. 旋转图像
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
https://leetcode-cn.com/problems/rotate-image/
面试题 01.07. 旋转矩阵
https://leetcode-cn.com/problems/rotate-matrix-lcci/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
     public void rotate(int[][] matrix) {
        int N = matrix.length-1;
        for(int j=0; j<N/2+1; j++){
            //System.out.println(" j=" + j);
            for(int i=j; i<N-j; i++){
                //System.out.println("i=" + i + " j=" + j);
                int t = matrix[j][i];
                chk(matrix, j, i, 3);
                //System.out.println("mat=" + Arrays.deepToString(matrix) + " i=" + i + " j=" + j);
                matrix[i][N-j] = t;
            }
        }
    }
    /**
     * 计算一组数字，其中(x,y)是被保护的，可以覆盖
     * 
     * 循环的特征是
     * x(n-1) = N - y(n)
     * y(n-1) = x(n)
     */
    void chk(int[][]mat, int x, int y, int n){
        //System.out.println("mat=" + Arrays.deepToString(mat) + " x=" + x + " y=" + y + " n=" + n);
        int N = mat.length-1;
        if(n >= 0){
            int xn1 = N - y;
            int yn1 = x;
            mat[x][y] = mat[xn1][yn1];
            chk(mat, xn1, yn1, n-1);
        }
    }
}

// -------------------------------------------------------
public class Main
{
	// 用反射调用就不需要每次改代码了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    Class cls = Solution.class;
	    Object ret = null;
        for(Method me : cls.getMethods()){
            // 只要Solution中的方法，应该只有一个
            if(me.getDeclaringClass()==cls){
                try{
                    long tm1 = System.nanoTime();
                    ret = me.invoke(o, args);
                    long tm2 = System.nanoTime();
                    System.out.printf("tbase(%s", s(expect));
                    for(Object ag : args){
                        System.out.printf(", %s", s(ag));
                    }
                    System.out.printf(")=%s time:%,d ns %s\n", s(ret), tm2-tm1, chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static <T> boolean chk(T      youret, T      expect){
	    boolean ret = false;
	    if(youret!=null){
	        if(youret instanceof int[]){
	            ret = Arrays.equals((int[])youret, (int[])expect);
	        }else{
	            ret = youret.equals(expect);    
	        }
	    }else if(youret==expect){
	        ret = true;
	    }
	    return ret;
	}
	static <T> String  s(T n)    {
	    if(n instanceof int[]){
	        return Arrays.toString((int[])n);
	    }else if(n instanceof int[][]){
	        return Arrays.deepToString((int[][])n);
	    }else{
    	    return "" + n;	
	    }
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}
	static void t1(){
	    tbase(null, (Object)new int[][]{
	        {1,2,3},
            {4,5,6},
            {7,8,9}
  	    });
	    tbase(null, (Object)new int[][]{
          { 5, 1, 9,11},
          { 2, 4, 8,10},
          {13, 3, 6, 7},
          {15,14,12,16}
	    });

	}
}
