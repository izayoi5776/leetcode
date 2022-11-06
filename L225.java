package leetcode;

import java.util.LinkedList;
import java.util.Queue;

// 225. 用队列实现栈
public class L225 {
	class MyStack {
		// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
		Queue<Integer> st = new LinkedList<>();
		int top;
		
	    public MyStack() {

	    }
	    
	    public void push(int x) {
	    	st.add(x);
	    	top = x;
	    }
	    
	    public int pop() {
	    	for(int i=0; i<st.size()-1; i++) {
	    		top = st.remove();
		    	st.add(top);
	    	}
	    	return st.remove();
	    }

	    public int top() {
	    	return top;
	    }
	    
	    public boolean empty() {
	    	return st.isEmpty();
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	
	public static void main(String[] args){
		L225 x = new L225();
		L225.MyStack o = x.new MyStack();

		/*
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // 返回 2
		myStack.pop(); // 返回 2
		myStack.empty(); // 返回 False
		*/
		o.push(1);
		o.push(2);
		o.push(3);
		o.push(4);
		o.top();
		o.pop();
		o.empty();
		o.pop();
		o.pop();
		o.pop();
		o.empty();
	}
}
