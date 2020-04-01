/******************************************************************************

1111. 有效括号的嵌套深度
https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ret  = new int[seq.length()];
        int[] deep = new int[seq.length()]; // 同位置文字的右边的括号深度

        int maxdeep = 0; // 最大深度值
        int curdeep = 0; // 现在深度

        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i) =='('){
                curdeep++;
            }else{
                curdeep--;
            }
            deep[i] = curdeep;
            if(curdeep > maxdeep){
                maxdeep = curdeep;
            }else if(curdeep == maxdeep){
                //ls2.add(i);
            }else{
                // continue;
            }
            //System.out.println("i=" + i + " maxdeep=" + maxdeep + " curdeep=" + curdeep + " deep=" + Arrays.toString(deep) +  " ls2=" + ls2);
        }
        // ls2记载了最大值
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='(' && deep[i]> maxdeep / 2){
                int pos = i;
                
                int deepL = maxdeep / 2 + 1;    // 向左找目标深度的一半+1，就是对应的开括号
                int deepR = maxdeep / 2;        // 向右找到目标深度的一半，就是对应的闭括号
    
                ret[pos]=1;
                // 向左找
                for(int j=pos-1; j>0 && deep[j]>=deepL; j--){
                    if(ret[j]==1){
                        break; // 已经有人找过了
                    }
                    ret[j] = 1;
                }
                // 向右找
                for(int j=pos+1; j<seq.length() && deep[j]>=deepR; j++){
                    //System.out.println("i=" + i + " pos=" + pos + " j=" + j + " deep[j]=" + deep[j]);
                    if(ret[j]==1){
                        break; // 已经有人找过了
                    }
                    ret[j] = 1;
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
		t2();
		t3();
		t4();
		t5();
	}
    static void tbase(String seq, int[] expect){
	    Solution o = new Solution();
	    System.out.println("seq=" + seq + " ret=" + Arrays.toString(o.maxDepthAfterSplit(seq)) + " expect=" + Arrays.toString(expect));
	}
	static void t1(){
	    tbase("(()())", new int[]{0,1,1,1,1,0});
	}
	static void t2(){
	    tbase("()(())()", new int[]{0,0,0,1,1,0,1,1});
	}
	static void t3(){
	    tbase("(((()))((())))", new int[]{0,0,1,1,0,0,1,0,0,1,0,0,1,1});
	}
	static void t4(){
	    tbase("()", new int[]{0,0});
	}	
	static void t5(){
	    //                                                  ( ) ( ) ( ) ( ( ) ) ( ( ( ( ) ) ) ) ( ) ( ( ( ) ( ) ) ) ( ( ) )             
	    //                                                                          ( (     ) )         (         )
	    tbase("()()()(())(((())))()((()()))(())", new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0});
	}	

    
    
}
