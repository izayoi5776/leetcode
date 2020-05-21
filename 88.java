/******************************************************************************

合并两个有序数组
https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
https://leetcode-cn.com/problems/merge-sorted-array/submissions/
*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1!=null && nums2!=null){
            // 从尾部排放可以避免移动
            int pos1 = m-1;
            int pos2 = n-1;
            int p = nums1.length-1; // m+n-1
            
            while(p>=0){
                int val = 0;
                if(pos1>=0 && pos2>=0){
                    if(nums1[pos1]>nums2[pos2]){
                        val = nums1[pos1--];
                    }else{
                        val = nums2[pos2--];
                    }
                }else if(pos1>=0){
                    val = nums1[pos1--];
                }else if(pos2>=0){
                    val = nums2[pos2--];
                }else{
                    break;
                }
                nums1[p--]=val;
            }
        }
    }
}
// -------------------------------------------------------
public class Main
{
	// 用反射调用就不需要每次改代码了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
		Solution o = new Solution();
		Class cls = Solution.class;
		Object ret = null;
		for(Method me : cls.getMethods()){
			// 只要Solution中的方法，应该只有一个
			if(me.getDeclaringClass()==cls){
				try{
					long tm1 = System.nanoTime();
					ret = me.invoke(o, args);
					long tm2 = System.nanoTime();
					System.out.printf("tbase(%s", s(expect));
					for(Object ag : args){
						System.out.printf(", %s", s(ag));
					}
					System.out.printf(")=%s time:%,d ns %s\n", s(ret), tm2-tm1, chk(ret, expect)?"OK":"NG");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	static	 boolean chk(String youret, String expect){		return youret.equals(expect);	}
	static	 boolean chk(int	youret, int	expect){		return youret==expect;	}
	static <T> boolean chk(T	  youret, T	  expect){
		boolean ret = false;
		if(youret!=null){
			if(youret instanceof int[]){
				ret = Arrays.equals((int[])youret, (int[])expect);
			}else{
				ret = youret.equals(expect);	
			}
		}else if(youret==expect){
			ret = true;
		}
		return ret;
	}
	static <T> String  s(T n)	{
		if(n instanceof int[]){
			return Arrays.toString((int[])n);
		}else if(n instanceof int[][]){
			return Arrays.deepToString((int[][])n);
		}else{
			return "" + n;	
		}
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
	}
	static void t1(){
		tbase(null, new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);    // new int[]{1,2,2,3,5,6}
		tbase(null, new int[]{}, 0, new int[]{}, 0);    // {}
        tbase(null, new int[]{1,2,3,4,5,0,0,0,0}, 5, new int[]{0,7,8,9}, 4);    // 0-9
	}
}






