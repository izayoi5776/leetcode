package leetcode;

import java.util.Arrays;

// 1805. 字符串中不同整数的数目
public class L1805 {
	public class Solution {
		public int numDifferentIntegers(String word) {
			String[] sa = word.split("[a-z]+");
			long cnt = Arrays.stream(sa)
					.filter(i->!i.equals(""))
					// .mapToInt(i->Integer.of(i))
					.map(s->s.replaceFirst("^0+(?!$)", ""))
					.distinct()
					.count();
			return (int)cnt;
		}
	}
	
	public static void main(String[] args){
		L1805 x = new L1805();
		L1805.Solution o = x.new Solution();
		
		// 输入：word = "a123bc34d8ef34"		输出：3
		assert(o.numDifferentIntegers("a123bc34d8ef34")==3);
		// 输入：word = "leet1234code234"		输出：2
		assert(o.numDifferentIntegers("leet1234code234")==2);
		// 输入：word = "a1b01c001"		输出：1
		assert(o.numDifferentIntegers("a1b01c001")==1);
		// 11/85
		assert(o.numDifferentIntegers("167278959591294")==1);
	}
}
