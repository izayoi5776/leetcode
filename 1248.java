/******************************************************************************

1248. 统计「优美子数组」
https://leetcode-cn.com/problems/count-number-of-nice-subarrays/

*******************************************************************************/
import java.util.Arrays;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ret = 0;
        
        // 把奇数个数放在奇数位，偶数个数放在偶数位，没有放0，最初0是偶数
        int[] v = new int[nums.length+1];
        if(nums!=null){
            int cnt = 0;
            int pos = 0; // pos for v
            for(int i=0; i<nums.length; i++){
                if( pos % 2 == nums[i] % 2 ){
                    cnt++;
                    v[pos] = cnt;
                    //System.out.println("1 i=" + i + " pos=" + pos + " cnt=" + cnt + " v=" + Arrays.toString(v));
                }else{
                    v[pos] = cnt;
                    cnt = 1;
                    pos++;
                    //System.out.println("2 i=" + i + " pos=" + pos + " cnt=" + cnt + " v=" + Arrays.toString(v));
                }
            }
        }
        System.out.println("nums=" + Arrays.toString(nums) + " v=" + Arrays.toString(v));
        
        // 创建全部连续子数组，最低长度为 k
        for(int i=0; i<nums.length-k+1; i++){         // 开始位置
            for(int j=i+k-1; j<nums.length; j++){       // 结束位置
                if(chk(nums, v, i, j, k)){
                    ret++;
                }
            }
        }
        return ret;
    }
    // 抽出一个子串，看看是不是 k 个奇数
    boolean chk(int[] nums, int[] v, int start, int end, int k){
        int pos = 0;    // 在 nums 中的位置
        int vpos = 0;   // 在 v    中的位置
        
        while(pos<start){
            pos+=v[vpos++];
        }
        //System.out.println("1 vpos=" + vpos + " pos=" + pos + " start=" + start);
        int cnt = 0;    // 奇数个数
        // 加上已经扫过的
        if(pos>start){
            // vpos 走过1位，所以现在的偶数位置就是奇数位置
            if(vpos % 2 == 0){
                cnt = pos - start;
            }
        }
        //System.out.println("2 vpos=" + vpos + " pos=" + pos + " start=" + start + " cnt=" + cnt + " end=" + end);
        while(pos<=end && vpos<v.length){
            //System.out.println("5 vpos=" + vpos + " pos=" + pos + " start=" + start + " cnt=" + cnt + " end=" + end);
            pos+=v[vpos];
            if(vpos % 2 == 1){
                cnt += v[vpos];
            }
            vpos++;
        }
        //System.out.println("3 vpos=" + vpos + " pos=" + pos + " start=" + start + " cnt=" + cnt + " end=" + end);
        // 减去过多的
        if(pos>end){
            if(vpos % 2 == 0){
                cnt -= pos - end - 1;
            }
        }
        boolean ret = cnt == k;
        //System.out.println("4 vpos=" + vpos + " pos=" + pos + " start=" + start + " cnt=" + cnt + " end=" + end + " ret=" + ret);
        if(ret){
            //System.out.println("found " + Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
            System.out.println("found " + start + ", " + end);
        }else{
            //System.out.println("NOT   " + Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
            System.out.println("NOT   " + start + ", " + end);
        }
        
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		//t1();
		//t2();
		t3();
	}
    static void tbase(int[] nums, int k, int expect){
        System.out.println("------------------------");
	    Solution o = new Solution();
	    int ret = o.numberOfSubarrays(nums, k);
	    System.out.println("nums=" + Arrays.toString(nums) + " k=" + k + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static void t1(){
	    tbase(new int[]{1,1,2,1,1}, 3, 2);
	    tbase(new int[]{2,4,6}, 1, 0);
	    tbase(new int[]{2,2,2,1,2,2,1,2,2,2}, 2, 16);
	}
    // case 9/38
 	static void t2(){
	    tbase(new int[]{74362,63079,69994,31483,30472,55113,77914,45288,16687,50904,85312,24458,290,80248,93663,54872,11104,23719,89967,23113,58180,99203,45474,94080,89821,49115,61061,84170,40718,2201,49116}, 8, 39);
	}
	// case 13/38
	static void t3(){
	    tbase(new int[]{22184,93865,52312,32314,72830,10526,87606,65371,36971,42138,25240,88847,51949,46337,7665,76594,49365,9520,89735,7094,72002,52580,60934,64883,39157,20770,5918,16153,65938,16094,63591,77994,59283,61448,20385,20692,28395,28583,90602,16158,98475,33477,26861,44663,28704,65117,24870,32973,97993,79018,10934,89958,2003,37562,84260,29073,16181,97083,53745,32784,84716,6696,1101,15287,61634,54594,26735,19899,50828,47493,34518,68508,43212,9322,79651,21620,40632,91034,92623,31915,53479,19717,35751,91407,89266,2268,11158,10171,80869,37364,72079}, 27, 68);
	}
}

