/******************************************************************************

面试题 16.03. 交点
https://leetcode-cn.com/problems/intersection-lcci/

*******************************************************************************/
import java.util.Arrays;

class Point implements Comparable<Point>{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    Point(Point a){
        x = a.x;
        y = a.y;
    }
    @Override
    public int compareTo(Point b){
        int ret = 0;
        if(x < b.x){
            ret = -1;
        }else if(x == b.x){
            if(y < b.y){    
                ret = -1;
            }else if(y>b.y){
                ret = 1;
            }
        }else{
            ret = 1;
        }
        return ret;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] ret = new double[]{};
        // line1
        Point p1 = new Point(start1[0], start1[1]);
        Point p2 = new Point(end1[0], end1[1]);
        if(p1.compareTo(p2)>0){
            Point t = new Point(p1);
            p1 = p2;
            p2 = t;
        }
        // line2
        Point p3 = new Point(start2[0], start2[1]);
        Point p4 = new Point(end2[0], end2[1]);
        if(p3.compareTo(p4)>0){
            Point t = new Point(p3);
            p3 = p4;
            p4 = t;
        }
        //System.out.println("p1=" + p1 + " p2=" + p2 + " p3=" + p3 + " p4=" + p4);
        // y = ax + b
        // a = frac{y1-y2}{x1-x2}
        boolean line1y = false;     // line1 垂直
        boolean line2y = false;     // line2 垂直
        double a1 = 0;
        double b1 = 0;
        double a2 = 0;
        double b2 = 0;
        if(p1.x==p2.x){
            line1y = true;
        }else{
            a1 = ((double)p1.y - p2.y)/((double)p1.x - p2.x);
            b1 = p1.y - a1 * p1.x;
        }
        if(p3.x==p4.x){
            line2y = true;
        }else{
            a2 = ((double)p3.y - p4.y)/((double)p3.x - p4.x);
            b2 = p3.y - a2 * p3.x;
        }
        //System.out.println("a1=" + a1 + " b1=" + b1 + " a2=" + a2 + " b2=" + b2 + " line1y=" + line1y + " line2y=" + line2y);
        // intersection
        // x = frac{b2-b1}{a1-a2}
        // 双垂直
        if(line1y && line2y){
            // 共线
            if(p1.x == p3.x){
                if(p1.y > p4.y || p3.y > p2.y ){
                    // 没有共同区间，即没有交点
                }else{
                    ret = new double[2];
                    ret[0] = p1.x;
                    ret[1] = Math.max(p1.y, p3.y);
                }
            }
        // 只有线1垂直
        }else if(line1y){
            if(rangeCheckX(p3, p4, p1.x)){
                double rety = a2 * p1.x + b2;
                if(rangeCheckY(p1, p2, rety)){
                    ret = new double[2];
                    ret[0] = p1.x;
                    ret[1] = rety;
                }
            }
        // 只有线2垂直
        }else if(line2y){
            if(rangeCheckX(p1, p2, p3.x)){
                double rety = a1 * p3.x + b1;
                if(rangeCheckY(p3, p4, rety)){
                    ret = new double[2];
                    ret[0] = p3.x;
                    ret[1] = rety;
                }
            }
        }else{
            // 平行
            if(a1==a2){
                // 重叠
                if(b1==b2){
                    // 若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
                    if(p2.compareTo(p3) < 0 || p4.compareTo(p1) < 0){
                        // 没有共同区间，即没有交点
                        
                    }else{
                        ret = new double[2];
                        if(p1.compareTo(p3) < 0){
                            ret[0] = p3.x;
                            ret[1] = p3.y;    
                        }else{
                            ret[0] = p1.x;
                            ret[1] = p1.y;
                        }
                    }
                }else{
                    // return blank
                }
            // 不平行
            }else{
                double retx = 0;
                double rety = 0;
                retx = (b2 - b1)/(a1-a2);
                rety = a1*retx + b1;
                if(rangeCheckX(p1, p2, retx) && rangeCheckY(p1, p2, rety)
                    && rangeCheckX(p3, p4, retx) && rangeCheckY(p3, p4, rety)){
                    ret = new double[2];
                    ret[0] = retx;
                    ret[1] = rety;
                }
            }
        }
        return ret;
    }
    boolean rangeCheckX(Point from, Point to, double x){
        double smlx = from.x;
        double bigx = to.x;
        if(smlx > bigx){
            smlx = to.x;
            bigx = from.x;
        }
        boolean ret = x >= smlx && x <= bigx;
        //System.out.println("from=" + from + " to=" + to + " x=" + x + " retX=" + ret);
        return ret;
    }
    boolean rangeCheckY(Point from, Point to, double y){
        double smly = from.y;
        double bigy = to.y;
        if(smly > bigy){
            smly = to.y;
            bigy = from.y;
        }
        boolean ret = y >= smly && y <= bigy;
        //System.out.println("from=" + from + " to=" + to + " y=" + y + " retY=" + ret);
        return ret;
    }
}


public class Main
{
	public static void main(String[] args) {
		/*
	    */
		t1();
		t2();
		t3();
		t4();
		t5();
		t6();
	    t7();
	    t8();
	    t9();
	    t10();
	    t11();
	}
    static void tbase(int[] start1, int[] end1, int[] start2, int[] end2, double[] expect){
	    Solution o = new Solution();
	    double[] ret = o.intersection(start1, end1, start2, end2);
	    System.out.println("start1=" + Arrays.toString(start1) + " end1=" + Arrays.toString(end1) 
	        + " start2=" + Arrays.toString(start2) + " end2=" + Arrays.toString(end2)
	        + " ret=" + Arrays.toString(ret) + " expect=" + Arrays.toString(expect) + (chk(ret,expect)?" OK":" NG"));
	}
	static void tbase5(int[] start1, int[] end1, int[] start2, int[] end2, double[] expect){
	    System.out.println("--------------------");
	    tbase(start1, end1, start2, end2, expect);
	    tbase(end1, start1, start2, end2, expect);
	    tbase(start1, end1, end2, start2, expect);
	    tbase(end1, start1, end2, start2, expect);
	    tbase(start2, end2, start1, end1, expect);
	}
	static void tbase10(int[] start1, int[] end1, int[] start2, int[] end2, double[] expect){
	    tbase5(start1, end1, start2, end2, expect);
	    tbase5(reverse(start1), reverse(end1), reverse(start2), reverse(end2), reverse(expect));
	    
	}
	static int[] reverse(int[] v){
	    int[] ret = new int[v.length];
	    for(int i=0; i<v.length; i++){
	        ret[i] = v[v.length - 1 -i];
	    }
	    return ret;
	}
	static double[] reverse(double[] v){
	    double[] ret = new double[v.length];
	    for(int i=0; i<v.length; i++){
	        ret[i] = v[v.length - 1 -i];
	    }
	    return ret;
	}
	static boolean chk(double[] youret, double[] expect){
	    return Arrays.equals(youret, expect);
	}
	// 例1
	static void t1(){
	    tbase10(
	        new int[]{0, 0}, new int[]{1, 0},
	        new int[]{1, 1}, new int[]{0, -1},
	        new double[]{0.5, 0}
	        );
	}
	// 例2 完全包含
	static void t2(){
	    tbase10(
	        new int[]{0, 0}, new int[]{3, 3},
	        new int[]{1, 1}, new int[]{2, 2},
	        new double[]{1, 1}
	        );
	}
	// 例3 平行
	static void t3(){
	    tbase10(
	        new int[]{0, 0}, new int[]{1, 1},
	        new int[]{1, 0}, new int[]{2, 1},
	        new double[]{}
	        );
	}
	// 共线无交点
	static void t4(){
	    tbase10(
	        new int[]{0, 0}, new int[]{1, 1},
	        new int[]{2, 2}, new int[]{3, 3},
	        new double[]{}
	        );
	}
	// 垂直
	static void t5(){
	    tbase10(
	        new int[]{0, 0}, new int[]{0, 1},
	        new int[]{-1, 0}, new int[]{1, 1},
	        new double[]{0, 0.5}
	        );
	}
	// 垂直, 无交点
	static void t6(){
	    tbase10(
	        new int[]{0, 1}, new int[]{0, 2},
	        new int[]{-1, -1}, new int[]{1, 1},
	        new double[]{}
	        );
	}
	// 双垂直, 无交点
	static void t7(){
	    tbase10(
	        new int[]{0, 1}, new int[]{0, 2},
	        new int[]{-1, -1}, new int[]{-1, 1},
	        new double[]{}
	        );
	}
	// 双垂直, 共线，无交点
	static void t8(){
	    tbase10(
	        new int[]{-1, 1}, new int[]{-1, 2},
	        new int[]{-1, -1}, new int[]{-1, 0},
	        new double[]{}
	        );
	}
	// 双垂直, 共线，交叉
	static void t9(){
	    tbase10(
	        new int[]{-1, 0}, new int[]{-1, 2},
	        new int[]{-1, -1}, new int[]{-1, 1},
	        new double[]{-1, 0}
	        );
	}
	// 双垂直, 共线，包含
	static void t10(){
	    tbase10(
	        new int[]{-1, -1}, new int[]{-1, 2},
	        new int[]{-1, 0}, new int[]{-1, 1},
	        new double[]{-1, 0}
	        );
	}
	// 测试漏洞
	static void t11(){
	    tbase10(
	        new int[]{1, 1}, new int[]{-1, 1},
	        new int[]{1, 0}, new int[]{-3, 2},
	        new double[]{-1, 1}
	        );
	}
	
}


