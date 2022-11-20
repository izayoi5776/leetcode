/******************************************************************************

155. 最小栈
https://leetcode-cn.com/problems/min-stack/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Deque;
import java.util.ArrayDeque;

class MinStack {
    Deque<Integer> de = new ArrayDeque<>();
    Deque<Integer> mi = new ArrayDeque<>();
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        int min = x;
        if(de.size()>0){
            min = mi.peekFirst();
            if(x<min){
                min = x;
            }
        }
        de.addFirst(x);
        mi.addFirst(min);
    }
    
    public void pop() {
        de.removeFirst();
        mi.removeFirst();

    }
    
    public int top() {
        return de.peekFirst();
    }
    
    public int getMin() {
        return mi.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// -------------------------------------------------------
public class Main
{
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
		//tbase(null, new int[]{1,2,3,4,5,6,7}, 3);
		//tbase(null, new int[]{1,2}, 2);
		
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.printf("m.getMin()=%d\n", m.getMin());
        m.pop();
        System.out.printf("m.top()=%d\n", m.top());
        System.out.printf("m.getMin()=%d\n", m.getMin());
	}
}
