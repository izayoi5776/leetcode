/******************************************************************************

912. 排序数组
https://leetcode-cn.com/problems/sort-an-array/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int[] nums, int[] expect){
	    Solution o = new Solution();
	    System.out.println("nums=" + Arrays.toString(nums) + " ret=" + Arrays.toString(o.sortArray(nums)) + " expect=" + Arrays.toString(expect));
	}
	static void t1(){
	    tbase(new int[]{5,2,3,1}, new int[]{1,2,3,5});
	}
	static void t2(){
	    tbase(new int[]{5,1,1,2,0,0}, new int[]{0,0,1,1,2,5});
	}
}
