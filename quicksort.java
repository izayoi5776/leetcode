/******************************************************************************

quick sort

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] quicksort(int[] nums) {
        int ret[] = new int[0];
        if(nums!=null && nums.length>0){
            ret = Arrays.copyOfRange(nums, 0, nums.length);
            quicksort(ret, 0, ret.length);
        }
        return ret;
    }
    // from 含，to 不含
    void quicksort(int[] A, int lo, int hi){
        System.out.printf("quicksort(%s, %d, %d)\n", Arrays.toString(A), lo, hi);
        if(lo < hi-1){
            int p = partation(A, lo, hi);
            quicksort(A, lo, p);
            quicksort(A, p+1, hi);
        }
    }
    int partation(int[] A, int lo, int hi){
        int p = (lo + hi) / 2;
        int left = lo;
        int right = Math.max(0, hi-2);
        
        swap(A, p, hi-1);
        while(left < right){
            if(A[left] > A[hi-1]){
                if(A[right] < A[hi-1]){
                    System.out.printf("partation(%s, %d, %d) p=%d left=%d right=%d DEBUG %d\n", Arrays.toString(A), lo, hi, p, left, right, 1);
                    swap(A, left, right);
                    left++;
                    right--;
                }else{
                    System.out.printf("partation(%s, %d, %d) p=%d left=%d right=%d DEBUG %d\n", Arrays.toString(A), lo, hi, p, left, right, 2);
                    right--;
                }
            }else{
                System.out.printf("partation(%s, %d, %d) p=%d left=%d right=%d DEBUG %d\n", Arrays.toString(A), lo, hi, p, left, right, 3);
                left++;
            }
        }
        
        if(A[right]<A[hi-1]){
            swap(A, right+1, hi-1);
        }else{
            swap(A, right, hi-1);    
        }
        System.out.printf("partation(%s, %d, %d) p=%d left=%d right=%d DEBUG %d\n", Arrays.toString(A), lo, hi, p, left, right, 4);
        return right;
    }
    void swap(int[] A, int a, int b){
        System.out.printf("swap     (%s, %d, %d)\n", Arrays.toString(A), a, b);
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int[] nums, int[] expect){
	    Solution o = new Solution();
	    int ret[] = o.quicksort(nums);
	    System.out.println("nums=" + Arrays.toString(nums) + " ret=" + Arrays.toString(ret) + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
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

	static void t1(){
	    tbase(new int[]{1,3,5,7,9, 2,4,6,8,0}, new int[]{0,1,2,3,4,5,6,7,8,9});
	}
}
