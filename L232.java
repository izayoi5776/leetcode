package leetcode;

import java.util.Stack;

// 232. 用栈实现队列
public class L232 {
	class MyQueue {
		// push用
		Stack<Integer> stPush = new Stack<>();
		// pop用
		Stack<Integer> stPop = new Stack<>();
		
		// 你只能使用标准的栈操作 —— 也就是只有 push to top, 
		// peek/pop from top, size, 和 is empty 操作是合法的。
	    public MyQueue() {

	    }
	    
	    public void push(int x) {
	    	// 移动 stPop 到 stPush，自动反向
	    	while(!stPop.isEmpty()) {
	    		int t = stPop.pop();
	    		stPush.push(t);
	    	}
	    	stPush.push(x);
	    }
	    
	    public int pop() {
	    	while(!stPush.isEmpty()) {
	    		int t = stPush.pop();
	    		stPop.push(t);
	    	}
	    	return stPop.pop();
	    }
	    
	    public int peek() {
	    	while(!stPush.isEmpty()) {
	    		int t = stPush.pop();
	    		stPop.push(t);
	    	}
	    	return stPop.peek();
	    }

	    public boolean empty() {
	    	return stPush.empty() && stPop.empty();
	    }
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */

	public static void main(String[] args){
		L232 x = new L232();
		L232.MyQueue o = x.new MyQueue();

		// 输入：		["MyQueue", "push", "push", "peek", "pop", "empty"]
		//			[[], [1], [2], [], [], []]
		// 输出：		[null, null, null, 1, 1, false]
		o.push(1);
		o.push(2);
		assert(o.peek()==1);
		assert(o.pop()==1);
		assert(!o.empty());
	}
}
