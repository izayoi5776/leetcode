/******************************************************************************

399. 除法求值
https://leetcode-cn.com/problems/evaluate-division/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // key1=较小的op, key2=另一个op，value2会按照 op1 / op2 = value2 调整
    Map<String, Map<String, Double>> mp = new HashMap<String, Map<String, Double>>();
    Map<String, Integer> zero = new HashMap<String, Integer>(); // key=op, value 0:op.isZero, 1:op not zero, -1 op contradiction
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size(); i++){
            // op1 / op2 = val
            String op1 = equations.get(i).get(0);
            String op2 = equations.get(i).get(1);
            double val = values[i];
            
            // 零检查用map构成
            opchk(op1, val==0?0:1, zero);   // 值不为零则分子非零
            opchk(op2, 1, zero);            // 分母必定非零

            // 整理后的式用map构成
            buildMap(op1, op2, val);
            
            // 构造完全的 Map
            while(buildMap2()){
                // loop
            }
        }
        //System.out.println("mp=" + mp + " zero=" + zero);
        
        // 解析问题
        double[] ret = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            ret[i] = solve(queries.get(i).get(0), queries.get(i).get(1));
        }
        return ret;
    }
    // 解析问题
    double solve(String op1, String op2){
        //System.out.println("solve() start op1=" + op1 + " op2=" + op2);
        double ret = -1.0;
        if(zero.containsKey(op1) && zero.containsKey(op2)){
            if(op1.equals(op2)){
                ret = 1.0;
            }else{
                Map<String, Double> mp2 = mp.get(op1);
                if(mp2.containsKey(op2)){
                    ret = mp2.get(op2);    
                }
            }
        }
        //System.out.println("solve() end   op1=" + op1 + " op2=" + op2 + " ret=" + ret);
        return ret;
    }

    // 保存表达式到map中, true表示发生修改
    private boolean buildMap0(String op1, String op2, double val){
        boolean ret = false;
        Map<String, Double> mp2 = null;
        if(mp.containsKey(op1)){
            mp2 = mp.get(op1);
        }else{
            mp2 = new HashMap<String, Double>();
            ret = true;
        }
        if(mp2.containsKey(op2)){
            // do nothing
        }else{
            mp2.put(op2, val);
            mp.put(op1, mp2);
            ret = true;
        }
        return ret;
    }
    // 正反两种都添加
    private boolean buildMap(String op1, String op2, double val){
        boolean ret1 = buildMap0(op1, op2, val);
        boolean ret2 = buildMap0(op2, op1, 1 / val);
        return ret1 || ret2;
    }
    private boolean buildMap2(){
        for(String op1:mp.keySet()){
            Map<String, Double> mp2 = mp.get(op1);
            String[] ls = mp2.keySet().toArray(new String[mp2.size()]);
            for(int i=0; i<ls.length-1;i++){
                for(int j=i+1;j<ls.length;j++){
                    String op2 = ls[i];
                    String op3 = ls[j];
                    double vl2 = mp2.get(op2);
                    double vl3 = mp2.get(op3);
                    boolean ret = buildMap(op2, op3, vl3 / vl2);
                    if(ret){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // 检查 op，结果加入 zero map中
    private void opchk(String op, int newflg, Map<String, Integer> zero){
        if(zero.containsKey(op)){
            if(zero.get(op) != newflg){
                zero.put(op, -1);  // 有矛盾
            }
        }else{
            zero.put(op, newflg);
        }
    }
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
		t3();
		t4();
	}
    static void tbase(List<List<String>> equations, double[] values, List<List<String>> queries, double[] expect){
	    Solution o = new Solution();
	    System.out.println("equations=" + equations + " values=" + Arrays.toString(values) + " queries=" + queries 
	        + " ret=" + Arrays.toString(o.calcEquation(equations, values, queries)) + " expect=" + Arrays.toString(expect));
	}
	static void t1(){
	    // queries(问题方程式) = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} }. 
	    tbase(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
	        new double[]{2.0, 3.0},
	        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a") , Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")),
	        new double[]{6.0, 0.5, -1.0, 1.0, -1.0}
	    );
	}
	static void t2(){
	    tbase(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")),
	        new double[]{1.5, 2.5, 5.0},
	        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b") , Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc")),
	        new double[]{3.75, 0.4, 5.0, 0.2}
	    );
	}
	static void t3(){
	    tbase(Arrays.asList(Arrays.asList("x1", "x2"), Arrays.asList("x2", "x3"), Arrays.asList("x1", "x4"), Arrays.asList("x2", "x5")),
	        new double[]{3.0, 0.5, 3.4, 5.6},
	        Arrays.asList(Arrays.asList("x2", "x4"), Arrays.asList("x1", "x5") , Arrays.asList("x1", "x3"), Arrays.asList("x5", "x5"), Arrays.asList("x5", "x1")
	            , Arrays.asList("x3", "x4"), Arrays.asList("x4", "x3"), Arrays.asList("x6", "x6"), Arrays.asList("x0", "x0")
	        ),
	        new double[]{1.13333,16.8,1.5,1.0,0.05952,2.26667,0.44118,-1.0,-1.0}
	    );
	}
	static void t4(){
	    tbase(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d")),
	        new double[]{1.0, 1.0},
	        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "d") , Arrays.asList("b", "a"), Arrays.asList("d", "c")),
	        new double[]{0, 0, 0, 0}
	    );
	}
}




