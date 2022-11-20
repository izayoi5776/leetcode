/******************************************************************************

1095. 山脉数组中查找目标值
https://leetcode-cn.com/problems/find-in-mountain-array/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Integer> mp = new HashMap<>(); // 缓存山脉数组值减少get调用次数 index, val
    int peekLeft  = 0;                  // 真实peek的左侧，已知最右位置
    int peek      = -1;                 // 
    int peekRight = -1;                 // 同上
    MountainArray mountainArr = null;   // 山脉数组本人
    int length = -1;                    // 山脉数组的长度，虽然没有限制，也顺手存了。
    int limLeft  = -1;                  // get(0)
    int limRight = -1;                  // get(length-1)
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int ret = -1;
        
        this.mountainArr = mountainArr;
        this.length = mountainArr.length();
        this.peekRight = length-1;
        this.limLeft = get(0);
        this.limRight= get(length);

        // 找到peek位置        
        while(peekLeft!=peekRight){
            int posMid = (peekRight-peekLeft)/2 + peekLeft;

            int mid = get(posMid);
            int lft = get(posMid-1);
            int rit = get(posMid+1);

            if(lft<mid){
                peekLeft = posMid;
            }else{
                peekRight = posMid;
            }
            if(mid>rit){
                peekRight = posMid;
            }else{
                peekLeft = posMid;
            }
            //System.out.println(this);
        }
        if(peekLeft==peekRight){
            peek = peekLeft;
        }else{
            // ASSERT
        }
        
        ret = binSearch(target, 0, peek);
        if(ret==-1){
            ret = binSearch(target, Math.min(peek+1, length-1), length-1);
        }
        return ret;
    }
    public String toString(){
        return String.format("mp=%s peek(%d,%d)", mp, peekLeft, peekRight);
    }
    // 普通的二分搜索
    // from, to 含
    int binSearch(int target, int from, int to){
        //System.out.printf("binSearch(%d, %d, %d)\n", target, from, to);
        int ret = -1;
        int valL = get(from);
        int valR = get(to);
        
        if(target==valL){
            ret = from;
        }else if(target==valR){
            ret = to;
        }else if(from<to-1){
            int posMid = (to - from) / 2 + from;
            int valMid = get(posMid);
            if(inRange(target, valL, valMid)){
                ret = binSearch(target, from, posMid);
            }else{
                ret = binSearch(target, Math.min(posMid+1, to), to);
            }
        }
        //System.out.printf("binSearch(%d, %d, %d)=%d\n", target, from, to, ret);
        return ret;
    }
    boolean inRange(int target, int a, int b){
        return(target>=a && target <=b
            || target>=b && target <=a);
    }

    // 调用山脉数组的get，利用cache保证不重复调用
    int get(int pos){
        int ret = Integer.MIN_VALUE;
        if(pos>=0 && pos<length){
            if(mp.containsKey(pos)){
                ret = mp.get(pos);
            }else{
                ret = mountainArr.get(pos);
                mp.put(pos, ret);
            }
        }
        return ret;
    }
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface MountainArray {
 public int get(int index);
 public int length();
}
class MyMountainArray implements MountainArray{
    private int[] nums = null;
    public int get(int index) {
        return nums[index];
    }
    public int length() {
        return nums.length;
    }
    MyMountainArray(int[] nums){
        this.nums = nums;
    }
}
 

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
    static void tbase(int target, MountainArray mountainArr, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.findInMountainArray(target, mountainArr);
	    System.out.println("target=" + target + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
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
	    tbase(3, new MyMountainArray(new int[]{1,2,3,4,5,3,1}), 2);
	    tbase(3, new MyMountainArray(new int[]{0,1,2,4,2,1}), -1);
	}
	// caes 69/77
	static void t2(){
	    tbase(2, new MyMountainArray(new int[]{3,5,3,2,0}), 3);
	}
	// case 66/77
	static void t3(){
	    tbase(3, new MyMountainArray(new int[]{1,2,3,5,3}), 2);
	}
}
