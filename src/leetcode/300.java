/******************************************************************************

300. 最长上升子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<String, Integer> cache = new HashMap<String, Integer>();
    public int lengthOfLIS(int[] nums) {
        List<Integer> nu = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            nu.add(nums[i]);
        }
        return chk(false, 0, nu);
    }
    /** 可以指定开始值的搜寻函数
     * flg true=要检查最小值
     * min 最小值。下一个数字必须大于min
     * nums 数列
     */
    private int chk(boolean flg, int min, List<Integer> nums){
        //System.out.println("START min=" + min + " nums=" + nums);
        List<Integer> nums2 = new ArrayList();
        int ret = 0;
        int n = nums.size();
        int n1 = 0;
        int n2 = 0;
        if(n==0){
            ret = 0;
        }else{
            // 先看以前算过没有
            String key = "" + flg + "_" + min + "_" + nums;
            if(cache.containsKey(key)){
                ret = cache.get(key);
                //System.out.println("END   key=" + key + " ret=" + ret);
            }else{
                if(flg){
                    // 用min过滤数组
                    for(int i=0; i<n; i++){
                        if(nums.get(i) > min){
                            nums2.add(nums.get(i));
                        }
                    }
                    n = nums2.size();
                }else{
                    nums2 = nums;
                }
                
                if(n>0){
                    // 求自己的子序列
                    List<Integer> sub = nums2.subList(1, n);
                    n1 = 1 + chk(true , nums2.get(0), sub); // 包含自己的子序列的长度
                    n2 =     chk(false, 0,            sub); // 不包含自己的子序列的长度
                    ret = Math.max(n1, n2); // 包含，不包含中更长的作为自己的返回值
                }
                cache.put(key, ret); 
                //System.out.println("END   flg=" + flg + " min=" + min + " nums=" + nums + " nums2=" + nums2 + " n1=" + n1 + " n2=" + n2 + " ret=" + ret);
            }
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
	    Solution o = new Solution();
	    //int[] nums = {10,9,2,5,3,7,101,18};   // should be 4
	    //int[] nums = {0};   // should be 1
	    //int[] nums = {-2,-1};   // should be 2
	    //int[] nums = {4,10,4,3,8,9};   // should be 3
		//System.out.println("" + o.lengthOfLIS(nums)); 
		t4();
	}
	private static void t4(){
	    int[] nums = new int[2500];
	    for(int i=0;i<2500;i++){
	        nums[i] = i;
	    }
	    Solution o = new Solution();
		System.out.println("" + o.lengthOfLIS(nums)); 
	}
}
