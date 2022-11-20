package leetcode;

// L401.java
public class L405 {
	
	public class Solution {
		public String toHex(int num) {
			String s = "";
			if(num==0) {
				return "0";
			}
			while(num!=0) {
				int t = num & 0b1111;
				s = String.valueOf(int2hex(t)) + s;
				num >>>= 4;
			}
			return s;
		}
		char int2hex(int n){
			String s = "0123456789abcdef";
			return s.charAt(n);
		}
	}
	
	public static void main(String[] args){
		L405 x = new L405();
		L405.Solution o = x.new Solution();
		
		// 输入:		26		输出:		"1a"
		assert(o.toHex(26).equals("1a"));
		// 输入:		-1		输出:		"ffffffff"
		assert(o.toHex(-1).equals("ffffffff"));
		assert(o.toHex(0).equals("0"));
		

	}
}
