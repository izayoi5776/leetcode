package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// 884. 两句话中的不常见单词
public class L884 {
	public class Solution {
		public String[] uncommonFromSentences(String s1, String s2) {
			Map<String, Long> m1 = Arrays.stream(s1.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Map<String, Long> m2 = Arrays.stream(s2.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Set<String> st1 = m1.entrySet().stream()
					.filter(en->en.getValue()==1)
					.filter(en->!m2.containsKey(en.getKey()))
					.map(en->en.getKey())
					.collect(Collectors.toSet());
			Set<String> st2 = m2.entrySet().stream()
					.filter(en->en.getValue()==1)
					.filter(en->!m1.containsKey(en.getKey()))
					.map(en->en.getKey())
					.collect(Collectors.toSet());
			st1.addAll(st2);
			return st1.toArray(new String[0]);
		}
	}
	public static void main(String[] args){
		L884 x = new L884();
		L884.Solution o = x.new Solution();
		
		// 输入：s1 = "this apple is sweet", s2 = "this apple is sour"		输出：["sweet","sour"]
		assert(Arrays.equals(o.uncommonFromSentences("this apple is sweet", "this apple is sour"), new String[] {"sweet","sour"}));
		
		// 输入：s1 = "apple apple", s2 = "banana"		输出：["banana"]
		assert(Arrays.equals(o.uncommonFromSentences("apple apple", "banana"), new String[] {"banana"}));

		// 12/55
		assert(Arrays.equals(o.uncommonFromSentences("s z z z s", "s z ejt"), new String[] {"ejt"}));
	}
}
