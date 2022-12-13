package leetcode;

import java.util.ArrayList;
import java.util.List;

// 682. 棒球比赛
public class L682 {
	public class Solution {
		public int calPoints(String[] operations) {
			List<Integer> ret = new ArrayList<>();
			for(int i=0; i<operations.length; i++) {
				String s = operations[i];
				if(s.equals("D")) {
					ret.add(ret.get(ret.size()-1) * 2);
				} else if(s.equals("C")) {
					ret.remove(ret.size()-1);
				} else if(s.equals("+")) {
					int a = ret.get(ret.size()-1);
					int b = ret.get(ret.size()-2);
					ret.add(a+b);
				} else {
					ret.add(Integer.valueOf(s));
				}
			}
			int sum = ret.stream().mapToInt(Integer::intValue).sum();
			return sum;
		}
	}
	
	public static void main(String[] args){
		L682 x = new L682();
		L682.Solution o = x.new Solution();
		
		// 输入：ops = ["5","2","C","D","+"]		输出：30
		assert(o.calPoints(new String[] {"5","2","C","D","+"})==30);
		// 输入：ops = ["5","-2","4","C","D","9","+","+"]		输出：27
		assert(o.calPoints(new String[] {"5","-2","4","C","D","9","+","+"})==27);
		// 输入：ops = ["1"]		输出：1
		assert(o.calPoints(new String[] {"1"})==1);

	}
}
