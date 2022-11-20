package leetcode;

import java.util.Stack;


class Solution {
    public boolean isValid(String s) {
    	Stack<String> k = new Stack<>();
    	try {
	    	for(int i=0; i<s.length(); i++) {
	        	char c = s.charAt(i);
	        	switch(c) {
	        		case '(', '{', '[':
	        			k.push(String.valueOf(c));
	        			break;
	        		case ')':
	        			if(k.peek().equals("(")) {
	        				k.pop();
	        			}else {
	        				return false;
	        			}
	        			break;
	        		case '}':
	        			if(k.peek().equals("{")) {
	        				k.pop();
	        			}else {
	        				return false;
	        			}
	        			break;
	        		case ']':
	        			if(k.peek().equals("[")) {
	        				k.pop();
	        			}else {
	        				return false;
	        			}
	        			break;
	        		default:
	        			return false;
	        	}
	    	}
    	}catch(Exception e) {
    		return false;
    	}
    	if(k.size()!=0) {
    		return false;
    	}
		return true;
    }
}

public class L20 {
	public static void main(String[] args){
		Solution o = new Solution();
		assert(o.isValid("{}"));
		assert(o.isValid("()[]{}"));
		assert(!o.isValid("(]"));

	}
}
