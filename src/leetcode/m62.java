/******************************************************************************

面试题62. 圆圈中最后剩下的数字
https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            ls.add(i);
        }
        
        int pos = 0;
        while(ls.size()>1){
            int sz = ls.size();
            pos = (pos + m - 1) % sz;
            int mv = ls.get(pos);
            ls.remove(pos);
            //System.out.println("ls=" + ls + " sz=" + sz + " pos=" + pos + " remove=" + mv);
        }
        
        return ls.get(0);    
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int n, int m, int expect){
	    Solution o = new Solution();
	    System.out.println("n=" + n + " m=" + m + " ret=" + o.lastRemaining(n, m) + " expect=" + expect);
	}
	static void t1(){
	    tbase(5, 3, 3);
	}
	static void t2(){
	    tbase(10, 17, 2);
	}
}
