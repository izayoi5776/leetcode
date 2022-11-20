package leetcode;

import java.util.ArrayList;
import java.util.List;

// 412. Fizz Buzz
public class L412 {
	
	public class Solution {
		public List<String> fizzBuzz(int n) {
			List<String> ret = new ArrayList<>();
			for(int i=1; i<=n; i++) {
				String s = "";
				if(i%3==0) {
					s += "Fizz";
				}
				if(i%5==0) {
					s += "Buzz";
				}
				if(s.isBlank()) {
					s = String.valueOf(i);
				}
				ret.add(s);
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L412 x = new L412();
		L412.Solution o = x.new Solution();
		
		// 输入：n = 3		输出：["1","2","Fizz"]
		System.out.println(o.fizzBuzz(3));
		// 输入：n = 5		输出：["1","2","Fizz","4","Buzz"]
		System.out.println(o.fizzBuzz(5));
		// 输入：n = 15		输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
		System.out.println(o.fizzBuzz(15));
		

	}
}
