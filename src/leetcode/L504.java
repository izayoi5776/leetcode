package leetcode;

// 504. 七进制数
public class L504 {
	public class Solution {
		public String convertToBase7(int num) {
			return Integer.toString(num, 7);
		}
	}
	
	public static void main(String[] args){
		L504 x = new L504();
		L504.Solution o = x.new Solution();
		
		// 输入: num = 100		输出: "202"
		assert(o.convertToBase7(100).equals("202"));
		// 输入: num = -7		输出: "-10"
		assert(o.convertToBase7(-7).equals("-10"));
	}
}
