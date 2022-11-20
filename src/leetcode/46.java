/******************************************************************************

46. 全排列
https://leetcode-cn.com/problems/permutations/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    //List<List<Integer>> lsls = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        return chk(nums);
    }
    List<List<Integer>> chk(int[] nums){
        List<List<Integer>> lsls = new ArrayList<>();
        //System.out.println("I-N chk(" + Arrays.toString(nums) +")=" + lsls);
        if(nums==null || nums.length<=0){
            // ret blank
        }else if(nums.length==1){
            lsls.add(new ArrayList<Integer>(){
                {
                    add(nums[0]);
                }
            });
        }else{
            for(int i=0; i<nums.length; i++){
                int cur = nums[i];
                List<List<Integer>> subRet = chk(copyWithout(nums, cur));
                for(List<Integer> ls:subRet){
                    ls.add(cur);
                    lsls.add(ls);
                    //System.out.println("-1- chk(" + Arrays.toString(nums) +") ls=" + ls + " lsls=" + lsls);
                }
            }
        }
        //System.out.println("OUT chk(" + Arrays.toString(nums) +")=" + lsls);
        return lsls;
    }
    // 复制一个数组，不包括except
    int[] copyWithout(int[] nums, int except){
        int[] ret = new int[0];
        if(nums!=null && nums.length>0){
            ret = new int[nums.length-1];
            int pos = 0; // ret[pos]
            for(int i=0; i<nums.length && pos<ret.length; i++){
                if(nums[i]!=except){
                    ret[pos++] = nums[i];
                }
            }
        }
        //System.out.println("copyWithout(" + Arrays.toString(nums) + "," + except + ")=" + Arrays.toString(ret));
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[] nums, List<List<Integer>> expect){
	    Solution o = new Solution();
	    List<List<Integer>> ret = o.permute(nums);
	    // TODO NG here...
	    System.out.println("nums=" + Arrays.toString(nums) + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	//static boolean chk(List<List<Integer>> youret, List<List<Integer>> expect){
	//    return ArraysdeepEquals(youret, expect);
	//}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static void t1(){
	    tbase(new int[]{1,2,3}, 
	        new ArrayList<List<Integer>>(){
                {
    	            add(Arrays.asList(new Integer[]{1,2,3}));
    	            add(Arrays.asList(new Integer[]{1,2,2}));
    	            add(Arrays.asList(new Integer[]{2,1,3}));
    	            add(Arrays.asList(new Integer[]{2,3,1}));
    	            add(Arrays.asList(new Integer[]{3,1,2}));
    	            add(Arrays.asList(new Integer[]{3,2,1}));
    	        }
	        }
	    );
	}
}
