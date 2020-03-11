/******************************************************************************

https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
1013. 将数组分成和相等的三个部分

*******************************************************************************/
import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length<3){
            return false;   // 項目数３つ以下
        }else{
            int sum = IntStream.of(A).sum();
            if(sum % 3 != 0){
                return false;   // 合計３で割れない
            }
            int target = sum / 3; // 部分合計
            
            // 位置１探す
            int p1 = A.length /3; // 位置１の開始は1/3地点
            int sum1 = IntStream.of(Arrays.copyOfRange(A, 0, p1)).sum(); // p1 まで合計
            if(sum1 > target){
                while(sum1 > target && p1 > 0 ){
                    int n = A[p1];
                    p1 -= 1;
                    sum1 -= n;
                }
                if(sum1 != target){
                    return false;
                }
            }else if(sum1 < target){
                while(sum1 < target && p1 < A.length -2 ){
                    int n = A[p1];
                    p1 += 1;
                    sum1 += n;
                }
                if(sum1 != target){
                    return false;
                }
            }
            
            // 位置２探す
            int p2 = (p1 + A.length) / 2; // 位置２の初期時点
            int sum2 = IntStream.of(Arrays.copyOfRange(A, p2, A.length)).sum(); // p2以降の合計
            if(sum2 > target){
                while(sum2 > target && p2 < A.length - 2 ){
                    int n = A[p2];
                    p2 += 1;
                    sum2 -= n;
                }
                if(sum2 != target){
                    return false;
                }
            }else if(sum2 < target){
                while(sum2 < target && p1 < A.length -2 ){
                    int n = A[p2];
                    p2 += 1;
                    sum1 += n;
                }
                if(sum1 != target){
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main
{
	public static void main(String[] args) {
		int[] a = {10,20,30,40,50}; // false
		int[] b = {0,2,1,-6,6,-7,9,1,2,0,1}; // true

        Solution o = new Solution();
        System.out.println(o.canThreePartsEqualSum(b));
	}
}
