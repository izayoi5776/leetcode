/******************************************************************************

两数之和 II - 输入有序数组
https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/785/


*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        
        if(numbers!=null && numbers.length>0){
            out:for(int i=0; i<numbers.length-1; i++){
                for(int j=i+1; j<numbers.length; j++){
                    if(numbers[i] + numbers[j] == target){
                        ret[0] = i+1;
                        ret[1] = j+1;
                        break out;
                    }
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
	}
    static void tbase(int[] p1, int p2, int[] expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int[] ret = o.twoSum(p1, p2);
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
	    tbase(new int[]{2, 7, 11, 15}, 9, new int[]{1,2});
	    
	}
}
