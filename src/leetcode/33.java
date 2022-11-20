/******************************************************************************

33. 搜索旋转排序数组
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int search(int[] nums, int target) {
        int ret = -1;
        int pos = 0;  // 变换位置，第一组之后，第二组的第一个
        if(nums!=null && nums.length>0){
            if(nums.length==1){
                if(target==nums[0]){
                    ret = 0;
                }
            }else{
                // 至少有2项
                // 不一定有从大变小的地方
                boolean found = false;
                while(pos<nums.length-1){
                     if(nums[pos]<=nums[++pos]){
                         continue;
                     }
                    found = true;
                    break;
                }
                //System.out.printf("search(%s, %d) found=%b pos=%d\n", Arrays.toString(nums), target, found, pos);
                if(!found){
                    // 没找到变小的地方，就普通二分查找
                    ret = search(nums, target, 0, nums.length);
                }else{
                    if(target>=nums[0] && target<=nums[pos-1]){
                        ret = search(nums, target, 0, pos);
                    }else if(target>=nums[pos] && target<=nums[nums.length-1]){
                        ret = search(nums, target, pos, nums.length);
                    }
                }
            }
        }
        return ret;
    }
    // 二分法，找一半。from包括，to不包括
    int search(int[] nums, int target, int from, int to){
        //System.out.printf("search(%s, %d, %d, %d)\n", Arrays.toString(nums), target, from, to);
        int ret = -1;
        if(target==nums[from]){
            ret = from;
        }else if(target==nums[to-1]){
            ret = to-1;
        }else if(from<to-1){
            int pos = (to - from) / 2 + from;
            if(target<nums[pos]){
                ret = search(nums, target, from, pos);
            }else{
                ret = search(nums, target, pos, to);
            }
        }
        //System.out.printf("search(%s, %d, %d, %d)=%d\n", Arrays.toString(nums), target, from, to, ret);
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
    static void tbase(int[] n, int target, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.search(n, target);
	    System.out.println("n=" + Arrays.toString(n) + " target=" + target + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
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
	    tbase(new int[]{4,5,6,7,0,1,2}, 4, 0);
	    tbase(new int[]{4,5,6,7,0,1,2}, 5, 1);
	    tbase(new int[]{4,5,6,7,0,1,2}, 6, 2);
	    tbase(new int[]{4,5,6,7,0,1,2}, 7, 3);
	    tbase(new int[]{4,5,6,7,0,1,2}, 0, 4);
	    tbase(new int[]{4,5,6,7,0,1,2}, 1, 5);
	    tbase(new int[]{4,5,6,7,0,1,2}, 2, 6);
	    tbase(new int[]{4,5,6,7,0,1,2}, 3, -1);
	}
	// 3/196
	static void t2(){
	    tbase(new int[]{1}, 0, -1);
	}
    // 6/196
	static void t3(){
	    tbase(new int[]{1,3}, 0, -1);
	}
}
