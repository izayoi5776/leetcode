package leetcode;

// 258. 各位相加
public class L258 {
	class Solution {
		public int addDigits(int num) {
			if(num<10) {
				return num;
			}
			String s = String.valueOf(num);
			int n = 0;
			for(int i=0; i<s.length(); i++) {
				n += Integer.valueOf(String.valueOf(s.charAt(i))); 
			}
			return addDigits(n);
	    }
	}
	
	public static void main(String[] args){
		L258 x = new L258();
		L258.Solution o = x.new Solution();
		
		// 输入: num = 38		输出: 2 
		assert(o.addDigits(38)==2);
		
		// 输入: num = 0		输出: 0
		assert(o.addDigits(0)==0);
		

	}
}
