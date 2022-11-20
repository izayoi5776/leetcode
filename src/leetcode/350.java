/******************************************************************************

两个数组的交集 II
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/submissions/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Integer> mp1 = new HashMap<>(); // nums1, count
    Map<Integer, Integer> mp2 = new HashMap<>(); // nums2, count
    List<Integer> ar = new ArrayList<>(); // nums2
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ret = new int[0];
        
        // arrary to map
        array2Map(nums1, mp1);
        array2Map(nums2, mp2);
        // small map in mp1
        Map<Integer, Integer> tmp = mp1;
        if(mp1.size() > mp2.size()){
            mp1 = mp2;
            mp2 = tmp;
        }
        
        // save to ArrayList
        for(Integer key : mp1.keySet()){
            if(mp2.containsKey(key)){
                int cnt1 = mp1.get(key);
                int cnt2 = mp2.get(key);
                for(int i=0; i<Math.min(cnt1, cnt2); i++){
                    ar.add(key);
                }
            }
        }
        //System.out.printf("intersect(%s, %s)=%s mp(%s, %s)\n", Arrays.toString(nums1), Arrays.toString(nums2), ar, mp1, mp2);
        return ar.stream().mapToInt(i->i).toArray();
    }
    void array2Map(int[] ar, Map<Integer, Integer> mp){
        if(ar!=null && mp!=null){
            for(int i=0; i<ar.length; i++){
                int key = ar[i];
                int cnt = 1;
                if(mp.containsKey(key)){
                    cnt = mp.get(key) + 1;
                }
                mp.put(key, cnt);
            }
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
	    tbase(new int[]{2,2}, new int[]{1,2,2,1}, new int[]{2,2});
	    tbase(new int[]{4,9}, new int[]{4,9,5}, new int[]{9,4,9,8,4});

	}
}
