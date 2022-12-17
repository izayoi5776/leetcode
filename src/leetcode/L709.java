package leetcode;

// 709. 转换成小写字母
public class L709 {
	public class Solution {
		public String toLowerCase(String s) {
			return s.toLowerCase();
		}
	}



	public static void main(String[] args){
		L709 x = new L709();
		L709.Solution o = x.new Solution();
		
		// 输入：s = "Hello"		输出："hello"
		assert(o.toLowerCase("Hello").equals("hello"));
		// 输入：s = "here"		输出："here"
		assert(o.toLowerCase("here").equals("here"));
	
	}
}
