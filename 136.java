/******************************************************************************

只出现一次的数字
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
https://leetcode-cn.com/problems/single-number/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        
        if(nums!=null && nums.length>0){
            int head = 0;
            int tail = nums.length -1;
            while(head<=tail){
                int cur = head;
                boolean found = false;
                while(++cur<=tail){
                    //System.out.printf("4 singleNumber(%s) head=%d tail=%d cur=%d found=%b\n", Arrays.toString(nums), head, tail, cur, found);
                    if(nums[head]==nums[cur]){
                        head++;
                        if(cur!=tail){
                            nums[cur]=nums[tail];
                        }
                        tail--;
                        found = true;
                        //System.out.printf("1 singleNumber(%s) head=%d tail=%d cur=%d found=%b\n", Arrays.toString(nums), head, tail, cur, found);
                        break;
                    }
                    //System.out.printf("2 singleNumber(%s) head=%d tail=%d cur=%d found=%b\n", Arrays.toString(nums), head, tail, cur, found);
                }
                if(!found){
                    //System.out.printf("3 singleNumber(%s) head=%d tail=%d cur=%d found=%b\n", Arrays.toString(nums), head, tail, cur, found);
                    ret = nums[head];
                    break;
                }
            }
        }
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
                    ret = me.invoke(o, args);
                    System.out.printf("tbase(%s", s(expect));
                    for(Object ag : args){
                        System.out.printf(", %s", s(ag));
                    }
                    System.out.printf(")=%s %s\n", s(ret), chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static     boolean chk(int[]  youret, int[]  expect){	    return Arrays.equals(youret, expect);	}
	static <T> boolean chk(T      youret, T      expect){
	    boolean ret = false;
	    if(youret!=null){
	        ret = youret.equals(expect);
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
	}
	static void t1(){
	    tbase(1, new int[]{2,2,1});
	    tbase(4, new int[]{4,1,2,1,2});
	    tbase(5, new int[]{3,1,2,1,2,3,5});

	}
}





