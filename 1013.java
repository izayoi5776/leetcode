/******************************************************************************

https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
1013. 将数组分成和相等的三个部分

*******************************************************************************/
import java.util.stream.*;

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
            int p1 = 1; // 位置１
            int sum1 = A[0]; // p1 まで合計
            while(sum1 != target && p1 < A.length -2 ){
                sum1 += A[p1];;
                p1 += 1;
            }
            if(sum1 != target){
                return false;
            }
            
            // 位置２探す
            int p2 = p1 + 1; // 位置２の初期時点
            int sum2 = A[p1]; // p2以降の合計
            while(sum2 != target && p2 < A.length -1 ){
                sum2 += A[p2];
                p2 += 1;
            }
            if(sum2 != target){
                return false;
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
        System.out.println(o.canThreePartsEqualSum(a));
	}
}
