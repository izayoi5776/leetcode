/******************************************************************************

983. 最低票价
https://leetcode-cn.com/problems/minimum-cost-for-tickets/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    int[] days = null;
    int[] costs = null;
    Map<Integer, Integer> mp = new HashMap<>(); // pos, ret
    public int mincostTickets(int[] days, int[] costs) {
        int ret = 0;
        this.days = days;
        this.costs = costs;
        ret = chk2(0);
        return ret;
    }
    // 算每日平均成本的贪婪算法，但是结束点不一样的7天，30天均价是不能比较的。
    int chk2(int pos){
        int ret = 0;
        //System.out.printf("I N chk(%s, %s, %d)\n", Arrays.toString(days), Arrays.toString(costs), pos);
        if(days!=null && costs!=null){
            if(mp.containsKey(pos)){
                ret = mp.get(pos);
            }else{
                if(pos<days.length){
                    double cost1 = costs[0];
                    
                    int pos7 = pos;
                    while(pos7<days.length && days[pos7]<(days[pos]+7)){
                        pos7++;
                    }
                    double cost7 = costs[1] * 1.0 / (pos7 - pos);
                    
                    int pos30 = pos;
                    while(pos30<days.length && days[pos30]<(days[pos]+30)){
                        pos30++;
                    }
                    double cost30 = costs[2] * 1.0 / (pos30 - pos);
    
                    if(cost1<=cost7 && cost1<=cost30){
                        ret = costs[0] + chk2(pos+1);
                    }else if(cost1<cost7 && cost1>cost30){
                        int ret1  = costs[0] + chk2(pos+1);
                        int ret30 = costs[2] + chk2(pos30);
                        ret = Math.min(ret1, ret30);
                    }else if(cost1>cost7 && cost1<cost30){
                        int ret1  = costs[0] + chk2(pos+1);
                        int ret7 =  costs[1] + chk2(pos7);
                        ret = Math.min(ret1, ret7);
                    }else{
                        int ret1  = costs[0] + chk2(pos+1);
                        int ret7 =  costs[1] + chk2(pos7);
                        int ret30 = costs[2] + chk2(pos30);
                        ret = Math.min(Math.min(ret1, ret7), ret30);
                    }
                    mp.put(pos, ret);
                    //System.out.printf("chk2(%s, %s, %d)=%d cost(%.2f %.2f %.2f) pos(%d %d %d) \n"
                    //    , Arrays.toString(days), Arrays.toString(costs), pos, ret, cost1, cost7, cost30, pos+1, pos7, pos30);
                }
            }
        }
        return ret;        
    }
    // 递归搜索，缺点是太慢
    int chk(int pos){
        int ret = 0;
        //System.out.printf("I N chk(%s, %s, %d)\n", Arrays.toString(days), Arrays.toString(costs), pos);
        if(days!=null && costs!=null){
            if(pos<days.length){
                int ret1 = costs[0] + chk(pos+1);
                
                int ret7 = costs[1];
                int pos7 = pos;
                while(pos7<days.length && days[pos7]<(days[pos]+7)){
                    pos7++;
                }
                ret7 += chk(pos7);
                
                int ret30 = costs[2];
                int pos30 = pos;
                while(pos30<days.length && days[pos30]<(days[pos]+30)){
                    pos30++;
                }
                ret30 += chk(pos30);
                
                ret = Math.min(ret1, Math.min(ret7, ret30));
            }
        }
        //System.out.printf("OUT chk(%s, %s, %d)=%d\n", Arrays.toString(days), Arrays.toString(costs), pos, ret);
        return ret;
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
                    ret = me.invoke(o, args);
                    System.out.printf("tbase(%s", s(expect));
                    for(Object ag : args){
                        System.out.printf(", %s", s(ag));
                    }
                    System.out.printf(")=%s %s\n", s(ret), chk(ret, expect)?"OK":"NG");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
	}
	static     boolean chk(String youret, String expect){	    return youret.equals(expect);	}
	static     boolean chk(int    youret, int    expect){	    return youret==expect;	}
	static     boolean chk(int[]  youret, int[]  expect){	    return Arrays.equals(youret, expect);	}
	static <T> boolean chk(T      youret, T      expect){
	    boolean ret = false;
	    if(youret!=null){
	        ret = youret.equals(expect);
	    }else if(youret==expect){
	        ret = true;
	    }
	    return ret;
	}
	static <T> String  s(T n)    {
	    if(n instanceof int[]){
	        return Arrays.toString((int[])n);
	    }else{
    	    return "" + n;	
	    }
	}

// -----------------------------------------------------------
	public static void main(String[] args) {
		t1();
		t2();
		t3();
	}
	static void t1(){
	    tbase(11, new int[]{1,4,6,7,8,20}, new int[]{2,7,15});
	    tbase(17, new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15});
	    tbase(2, new int[]{1}, new int[]{2,7,15});
	    tbase(2, new int[]{1}, new int[]{7,15,2});
	    tbase(2, new int[]{1}, new int[]{15,2,7});
	    tbase(4, new int[]{1, 365}, new int[]{2,7,15});
	}
	// 37 of 66 timeout
	static void t2(){
	    tbase(170, new int[]{
	        3,5,6,8,9,10,11,12,13,14,15,16,20,21,23,25,26,27,29,30,33,34,35,36,38,39,40,42,45,
	        46,47,48,49,51,53,54,56,57,58,59,60,61,63,64,67,68,69,70,72,74,77,78,79,80,81,82,
	        83,84,85,88,91,92,93,96
	    }, new int[]{3,17,57});
	}
	// 47 of 66 timeout
	static void t3(){
		    tbase(7938, new int[]{
                1,2,4,5,6,7,9,10,12,15,17,19,20,21,22,24,25,27,29,30,32,34,35,36,37,39,40,41,42,
                43,44,45,46,47,48,49,50,53,54,55,57,58,59,60,61,62,64,67,68,69,70,71,72,73,74,76,
                77,78,79,81,84,85,86,87,89,90,92,93,95,96,99,101,102,103,104,105,106,107,108,110,
                113,114,116,118,119,120,121,122,123,126,128,131,132,133,135,136,137,138,139,140,
                143,144,145,146,147,150,151,152,153,154,155,156,158,159,160,162,164,169,171,172,
                173,175,176,177,178,180,181,183,184,186,188,190,191,192,194,195,197,198,199,200,
                201,202,203,204,210,211,213,216,217,219,220,222,225,227,228,231,232,235,236,240,
                241,242,244,245,246,248,249,250,251,252,254,255,257,259,261,265,267,271,273,274,
                276,277,278,279,280,281,283,284,285,286,287,288,289,290,293,295,296,297,299,300,
                302,303,304,306,307,308,309,310,311,314,319,321,322,323,325,326,330,332,334,335,
                337,339,340,341,342,343,344,345,346,347,348,350,351,353,354,356,358,360,361
	    }, new int[]{38,206,728});
	}

}
