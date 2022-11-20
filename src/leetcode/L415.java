package leetcode;

// 415. 字符串相加
public class L415 {
	
	public class Solution {
		public String addStrings(String num1, String num2) {
			StringBuilder sb = new StringBuilder();
			int c = 0;	// 进位
			int i = num1.length()-1;
			int j = num2.length()-1;
			while(i>=0 || j>=0) {
				int a = i>=0 ? Integer.valueOf(num1.substring(i, i+1)) : 0;
				int b = j>=0 ? Integer.valueOf(num2.substring(j, j+1)) : 0;
				int sum = a + b + c;
				c = 0;
				if(sum>=10) {
					sum -= 10;
					c = 1;
				}
				sb.insert(0, sum);
				i--;
				j--;
			}
			if(c!=0) {
				sb.insert(0,1);
				c=0;
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args){
		L415 x = new L415();
		L415.Solution o = x.new Solution();
		
		// 输入：num1 = "11", num2 = "123"		输出："134"
		assert(o.addStrings("11", "123").equals("134"));
		// 输入：num1 = "456", num2 = "77"		输出："533"
		assert(o.addStrings("456", "77").equals("533"));
		// 输入：num1 = "0", num2 = "0"		输出："0"
		assert(o.addStrings("0", "0").equals("0"));

	}
}
