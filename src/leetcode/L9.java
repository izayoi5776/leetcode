package leetcode;


public class L9 {
	class Solution {
	    public boolean isPalindrome(int x) {
	    	if(x<0){
	    		return false;
	    	}else if(x<10) {
	    		return true;
	    	}else {
	    		String s = Integer.toString(x);
	    		for(int i=0, j=s.length()-1; i<j; i++,j--) {
	    			if(s.charAt(i) != s.charAt(j)) {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    }
	}
	public static void main(String[] args){
		L9 x = new L9();
		L9.Solution o = x.new Solution();
		assert(o.isPalindrome(121));
		assert(!o.isPalindrome(123));
		assert(!o.isPalindrome(-123));
		assert(o.isPalindrome(1234554321));
	}
}
