/******************************************************************************

862. 和至少为 K 的最短子数组
https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/

*******************************************************************************/
import java.util.Arrays;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;


class Solution {
    /**
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     * 子数组
     * 非空
     * 连续
     * 最短
     * 和至少为 K
     * 如果没有，返回 -1
     */
    public int shortestSubarray(int[] A, int K) {
        int ret = -1;
        int[] sm = new int[A.length];              // 连续非空子数组的和，最初
        System.arraycopy(A, 0, sm, 0, A.length);   // copy A -> sm

        // 子数组的长度loop
        for(int len=1; len<=sm.length; len++){
            // 从第 i 个开始的子数组
            for(int i=0; i < sm.length - len + 1; i++){
                //System.out.println("sm=" + Arrays.toString(sm) +" len=" + len + " i=" + i);
                // 如果找到 和至少为K 的，就返回
                if(sm[i]>=K){
                    ret = len;
                    break;
                }
                // 同时计算下一层，保存在扫描完的 sm 里
                int np = i + len; // next position
                if(np < sm.length){
                    sm[i] += A[np];
                }
            }
            if(ret != -1){
                break;
            }
        }
        return ret;
    }
}

public class Leet862
{
	public static void main(String[] args) {
	    //t1();
	    //t2();
	    //t3();
	    //t4();
	    t5();
		
	}
	private static void tbase(int[] A, int K){
	    Solution o = new Solution();
	    System.out.println("A=" + "Arrays.toString(A)" +" K=" + K + " ret=" + o.shortestSubarray(A, K));
	}
	private static void t1(){
	    int[] A = {1};
	    int K = 1;
	    tbase(A, K); // should be 1
	}
	private static void t2(){
	    int[] A = {1,2};
	    int K = 4;
	    tbase(A, K); // should be -1
	}
	private static void t3(){
	    int[] A = {2,-1,2};
	    int K = 3;
	    tbase(A, K); // should be 3
	}
	private static void t4(){
	    int[] A = {77,19,35,10,-14};
	    int K = 19;
	    tbase(A, K); // should be 1
	}
	private static void t5(){
		List<Integer> ls = new ArrayList<Integer>();
		Path file = Paths.get("leet862_t5.txt");
		try{
			Files.lines(file).forEach( line -> {
				for(String s:line.split(",", 0)){
					ls.add(Integer.valueOf(s));
				}
			});
		}catch(Exception ex){
			ex.printStackTrace();
		}
		int K = 5837033;
		tbase(ls.stream().mapToInt(i->i).toArray(), K); // should be 1
	}

}
