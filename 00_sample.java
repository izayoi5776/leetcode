import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;


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
	    tbase(null, new int[]{1,2,3,4,5,6,7}, 3);
	    tbase(null, new int[]{1,2}, 2);

	}
}
