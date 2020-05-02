/******************************************************************************

移除元素
https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/787/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        if(nums!=null && nums.length>0){
            for(int i=0; i<nums.length; i++){
                if(nums[i]!=val){
                    if(pos==i){
                        pos++;
                    }else{
                        nums[pos++] = nums[i];
                    }
                }
            }
        }
        return pos;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[] p1, int p2, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.removeElement(p1, p2);
	    System.out.printf("tbase(%s, %s, %s)=%s %s\n", s(p1), s(p2), s(expect), s(ret), (chk(ret,expect)?" OK":" NG"));
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
	static String s(int n){
	    return "" + n;
	}
	static String s(int[] n){
	    return "" + Arrays.toString(n);
	}
	static void t1(){
	    tbase(new int[]{1,2,3,4}, 3, 3);
	    tbase(new int[]{}, 3, 0);
	    tbase(new int[]{1,2}, 3, 2);
	    tbase(new int[]{3,2,2,3}, 3, 2);
	    
	}
}
