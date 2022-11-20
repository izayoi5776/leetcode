/******************************************************************************

210. 课程表 II
https://leetcode-cn.com/problems/course-schedule-ii/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

class Solution {
    Set<Integer> chk = new HashSet<>(); // 正在检查的课程
    Set<Integer> done= new LinkedHashSet<>(); // 可以学习的课程，包括所有前导在内都没有问题的
    Map<Integer, List<Integer>> mp = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // convert prerequisites to map
        if(prerequisites!=null && prerequisites.length>0){
            for(int i=0; i<prerequisites.length; i++){
                int key = prerequisites[i][0];
                int val = prerequisites[i][1];
                List<Integer> ls = null;
                if(mp.containsKey(key)){
                    ls = mp.get(key);
                }else{
                    ls = new ArrayList<>();
                }
                ls.add(val);
                mp.put(key, ls);
            }
        }
        //System.out.printf("findOrder() mp=%s\n", mp);
        
        Deque<Integer> todo = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            todo.add(i);
        }
        //System.out.printf("1 mp=%s todo=%s done=%s\n", mp, todo, done);
        int noActionCnt = 0;
        while(todo.size()>0 && noActionCnt<todo.size()){
            int i = todo.remove();
            if(mp.containsKey(i)){
                todo.add(i);
                noActionCnt++;
            }else{
                done.add(i);
                noActionCnt = 0;
                for(Iterator<Integer> it = mp.keySet().iterator(); it.hasNext();){
                    int key = it.next();
                    List<Integer> ls = mp.get(key);
                    if(ls.contains(i)){
                        ls.remove((Integer)i);
                        if(ls.size()<=0){
                            it.remove();
                        }
                    }
                }
            }
            //System.out.printf("3 mp=%s todo=%s done=%s noActionCnt=%d i=%d\n", mp, todo, done, noActionCnt, i);
        }
        //System.out.printf("2 mp=%s todo=%s done=%s noActionCnt=%d\n", mp, todo, done, noActionCnt);
        
        int[] ret = new int[0];
        if(todo.size()<=0){
            ret = new int[done.size()];
            int pos = 0;
            for(Integer val : done){
                ret[pos++] = val;
            }
        }
        
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
		t2();
	}
	static void t1(){
		tbase(new int[]{0,1}, 2, new int[][]{{1,0}});
		tbase(new int[]{}, 2, new int[][]{{1,0},{0,1}});
		tbase(new int[]{0,1,2,3}, 4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
		tbase(new int[]{}, 4, new int[][]{{1,0},{2,0},{3,1},{3,2},{0,3}});
		tbase(new int[]{}, 4, new int[][]{{0,3},{1,0},{2,0},{3,1},{3,2}});
	}
	// 35 of 44
	static void t2(){
		tbase(new int[]{1,0}, 2, new int[][]{{0,1}});
	}

}
