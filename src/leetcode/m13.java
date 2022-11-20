/******************************************************************************

面试题13. 机器人的运动范围
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

excel用式，贴在B2
=MOD($A2,10)+INT(MOD($A2,100)/10)+MOD(B$1,10)+INT(MOD(B$1,100)/10)<=$A$1

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

class Rec{
    int x;
    int y;
    Rec(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "" + x + "_" + y;
    }
}
class Solution {
    Map<String, Integer> mp = new HashMap<String, Integer>(); // 保存数字的和
    Deque<Rec> todo = new ArrayDeque<Rec>(); // 保存要检测的对象
    public int movingCount(int m, int n, int k) {
        int ret = 0;

        todo.add(new Rec(0,0));
        while(todo.size()>0){
            Rec c = todo.remove();
            ret += chk(m, n, k, c.x, c.y);
            //System.out.println("c=" + c + " ret=" + ret);
        }

        return ret;
    }
    /**
     * 检测一个位置
     * 返回是否可以到达，且没有到达过
     * 可以到达且新 则 投入到 todo 队列
     */ 
    int chk(int m, int n, int k, int x, int y){
        int ret = 0;
        String key = "" + x + "_" + y;
        if(x<0 || y<0 || x>=m || y>=n){
            //ret = 0;
        }else if(mp.containsKey(key)){
            // ret = 0; // 查过的不再查
            //System.out.println("chk() " + key + " found in mp");
        }else{
            int value = sum(x) + sum(y);
            mp.put(key, value);
            //System.out.println("chk() value=" + value + " k=" + k);
            if(value <= k){
                ret = 1;
                todo.add(new Rec(x-1,y));
                todo.add(new Rec(x+1,y));
                todo.add(new Rec(x,y-1));
                todo.add(new Rec(x,y+1));
            }
        }
        //System.out.println("chk() " + "m=" + m + " n=" + n + " k=" + k + " x=" + x + " y=" + y + " ret=" + ret);
        return ret;
    }
    // 计算各位数的和
    int sum(int n){
        int ret = 0;
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); i++){
            ret += Integer.valueOf(String.valueOf(s.charAt(i)));
        }
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
	}
    static void tbase(int m, int n, int k, int expect){
	    Solution o = new Solution();
	    int ret = o.movingCount(m, n, k);
	    System.out.println("m=" + m + " n=" + n + " k=" + k + " ret=" + ret + " expect=" + expect + (ret==expect?" OK":" NG"));
	}
	static void t1(){
	    tbase(2, 3, 1, 3);
	}
}

