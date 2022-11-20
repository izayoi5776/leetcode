/******************************************************************************

56. 合并区间
https://leetcode-cn.com/problems/merge-intervals/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Rec{
    int start;
    int end;
    Rec(int start, int end){
        this.start = Math.min(start, end);
        this.end = Math.max(start, end);
    }
    public String toString(){
        return "" + start + "," + end;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        List<Rec> ls = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            ls.add(new Rec(intervals[i][0], intervals[i][1]));
        }
        boolean flg = false; // 发生变化则true
        do{
            flg = false;
            // 1段以上才需要循环
            if(ls.size()>1){
                mid:for(int i=0; i<ls.size()-1; i++){
                    Rec r1 = ls.get(i);
                    for(int j=i+1; j<ls.size(); j++){
                        Rec r2 = ls.get(j);
                        Rec rMerged = chk(r1, r2);
                        if(rMerged==null){
                            // null表示不需要合并
                        }else{
                            // 不是null，表示需要合并
                            ls.remove(r2);
                            ls.remove(r1);
                            ls.add(rMerged);
                            flg=true;
                            break mid;
                        }
                    }
                }
            }
        }while(flg);
        
        int[][] ret = new int[ls.size()][2];
        for(int i=0; i<ls.size(); i++){
            ret[i][0] = ls.get(i).start;
            ret[i][1] = ls.get(i).end;
        }
        return ret;
    }
    // 判断2段是否重叠
    // 不需要合并返回 null，需要返回合并后的 Rec
    Rec chk(Rec a, Rec b){
        // a, b not null
        Rec ret = null;
        // 相连,交错,包含的两段
        if(a.end>=b.start && a.end<=b.end
        || b.end>=a.start && b.end<=a.end){
            //System.out.println("a=" + a + " b=" + b + " ret=" + ret + " A");
            ret = new Rec(Math.min(a.start, b.start), Math.max(a.end,b.end));
        }
        //System.out.println("a=" + a + " b=" + b + " ret=" + ret);
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int[][] intervals, int[][] expect){
	    Solution o = new Solution();
	    int[][] ret = o.merge(intervals);
	    System.out.println("intervals=" + Arrays.deepToString(intervals) + " ret=" + Arrays.deepToString(ret) + " expect=" + Arrays.deepToString(expect) + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(int[][] youret, int[][] expect){
	    boolean ret = false;
	    if(youret.length==expect.length){
	        ret = true;
    	    for(int i=0; i<youret.length; i++){
    	        int[] a = youret[i];
    	        boolean found = false;
    	        for(int j=0; j<expect.length; j++){
    	            found = false;
    	            int[] b = expect[j];
    	            if(a[0]==b[0] && a[1]==b[1]){
    	                found = true;
    	                //System.out.println("FOUND a=" +  Arrays.toString(a) + " b=" +  Arrays.toString(b));
    	                break;
    	            }
    	        }
    	        if(!found){
    	            //System.out.println("NOT FOUND a=" + Arrays.toString(a));
    	            ret = false;
    	            break;
    	        }
    	    }
	    }
	    return ret;
	}
	static void t1(){
	    tbase(new int[][]{{1,3},{2,6},{8,10},{15,18}}, new int[][]{{1,6},{8,10},{15,18}});
	}
	static void t2(){
	    tbase(new int[][]{{1,4},{0,4}}, new int[][]{{0,4}});
	}
}
