/******************************************************************************

221. 最大正方形
https://leetcode-cn.com/problems/maximal-square/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    char[][] m = null;
    public int maximalSquare(char[][] matrix) {
        m = matrix;
        int ret = 0;
        
        if(m!=null){
            for(int i=0; i<m.length-ret; i++){
                for(int j=0; j<m[0].length-ret; j++){
                    if(m[i][j]=='1'){
                        int maxrow = chkrow(i, j);
                        int maxcol = chkcol(i, j);
                        int max = Math.min(maxrow, maxcol);
                        if(max > ret){
                            while(max>ret){
                                if(chkSquare(i, j, max)){
                                    ret = max;
                                }
                                max--;
                            }
                        }
                    }
                }
            }
        }
        return ret*ret;
    }
    // 最长行
    int chkrow(int x, int y){
        int ret = x;
        while(ret>=0 && y>=0 && ret<m.length && y<m[0].length && m[ret][y]=='1'){
            ret++;
        }
        ret -= x;
        //System.out.printf("chkrow(%d, %d)=%d\n", x, y, ret);
        return ret;
    }
    // 最长列
    int chkcol(int x, int y){
        int ret = y;
        while(x>=0 && ret>=0 && x<m.length && ret<m[0].length && m[x][ret]=='1'){
            ret++;
        }
        ret -= y;
        //System.out.printf("chkcol(%d, %d)=%d\n", x, y, ret);
        return ret;
    }
    // 检查正方形。m,x,y,n都不会越界
    boolean chkSquare(int x, int y, int n){
        //System.out.printf("chkSquare(%d, %d, %d)\n", x, y, n);
        boolean ret = true;
        out:for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(m[i][j]!='1'){
                    //ret = Math.min(i-x, j-y);
                    ret = false;
                    break;
                }
            }
        }
        //System.out.printf("chkSquare(%d, %d, %d)=%b\n", x, y, n, ret);
        return ret;
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
	    }else{
    	    return "" + n;	
	    }
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
		t2();
	}
	static void t1(){
	    tbase(4, (Object)new char[][]{
	        {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
	    });
	    tbase(0, (Object)new char[][]{
	        {}
	    });
	    tbase(1, (Object)new char[][]{
	        {'1'}
	    });
	    tbase(0, (Object)new char[][]{
	        {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'}
	    });
	    tbase(16, (Object)new char[][]{
	        {'1','1','1','1','1'},
            {'1','1','1','1','1'},
            {'1','1','1','1','1'},
            {'1','1','1','1','1'}
	    });
	    tbase(4, (Object)new char[][]{
	        {'1','1'},
            {'1','1'}
	    });
	}
	// 65 of 69
	static void t2(){
	    tbase(9, (Object)new char[][]{
            {'0','0','1','0'},
            {'1','1','1','1'},
            {'1','1','1','1'},
            {'1','1','1','0'},
            {'1','1','0','0'},
            {'1','1','1','1'},
            {'1','1','1','0'}
        });
	}
}
