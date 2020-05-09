/******************************************************************************

36. 有效的数独
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
https://leetcode-cn.com/problems/valid-sudoku/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    char[][] b = null;
    public boolean isValidSudoku(char[][] board) {
        b = board;
        boolean ret = true;
        for(int i=0; ret && i<b.length; i++){
            ret = chkRow(i);
        }
        for(int i=0; ret && i<b.length; i++){
            ret = chkCol(i);
        }
        for(int i=0; ret && i<b.length; i+=3){
            for(int j=0; ret && j<b.length; j+=3){
                ret = chkSquare(i, j);
            }
        }
        return ret;
    }
    // 测试一整行
    boolean chkRow(int x){
        char[] a = new char[b[0].length];
        for(int i=0; i<b[0].length; i++){
            a[i] = b[x][i];
        }
        return chk(a);
    }
    boolean chkCol(int y){
        char[] a = new char[b.length];
        for(int i=0; i<b.length; i++){
            a[i] = b[i][y];
        }
        return chk(a);
    }
    boolean chkSquare(int x, int y){
        char[] a = new char[9];
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                a[i%3*3+j%3] = b[i][j];
                //System.out.printf("chkSquare(%d, %d) (i,j)=(%d, %d) a=%s\n", x, y, i, j, Arrays.toString(a));
            }
        }
        return chk(a);
    }
    // 测试9个值，是1-9，或者点，没有重复
    boolean chk(char[] a){
        boolean ret = true;
        int[] buf = new int[10]; // set to 0 auto
        
        if(a!=null){
            for(int i=0; i<a.length; i++){
                int c = c2i(a[i]);
                if(c>0){
                    if(buf[c]>0){
                        ret=false;
                        break;
                    }else{
                        buf[c]=1;
                    }
                }
            }
        }
        //System.out.printf("chk(%s)=%b\n", Arrays.toString(a), ret);
        return ret;
    }
    int c2i(char c){
        return (int)c - 48; // .->-2, 0->0, 1->1... 9->9
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
		//t1();
		t2();
	}
	static void t1(){
	    tbase(true, (Object)new char[][]
	    {
          {'5','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        });
	    tbase(false, (Object)new char[][]
	    {
          {'8','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        });
	}
	// 483 of 504
	static void t2(){
	    tbase(false, (Object)new char[][]
	    {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}
	    });
	}
}

