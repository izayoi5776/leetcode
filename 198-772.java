/******************************************************************************

加一
https://leetcode-cn.com/explore/featured/card/array-and-string/198/introduction-to-array/772/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length-1);
    }
    int[] plusOne(int[] digits, int pos){
        int[] ret = digits;
        if(digits!=null && pos>=0 && pos<digits.length){
            if(pos==0){
                if(digits[pos]==9){
                    digits[pos] = 0;
                    ret = new int[digits.length+1];
                    System.arraycopy(digits, 0, ret, 1, digits.length);
                    ret[0]=1;
                }else{
                    digits[pos]++;
                }
            }else{
                if(digits[pos]==9){
                    digits[pos]=0;
                    ret = plusOne(digits, pos-1);
                }else{
                    digits[pos]++;
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
    static void tbase(int[] n, int[] expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int[] ret = o.plusOne(n);
	    System.out.println("n=" + Arrays.toString(n) + " ret=" + Arrays.toString(ret) + " expect=" + Arrays.toString(expect) + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}

	static void t1(){
	    tbase(new int[]{1,2,3}, new int[]{1,2,4});
	    tbase(new int[]{}, new int[]{});
	    tbase(new int[]{0}, new int[]{1});
	    tbase(new int[]{-1}, new int[]{0});
	    tbase(new int[]{9}, new int[]{1,0});
	    tbase(new int[]{9,9,9}, new int[]{1,0,0,0});
	}
}

