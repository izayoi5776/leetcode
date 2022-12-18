package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 748. 最短补全词
public class L748 {
	public class Solution {
		public String shortestCompletingWord(String licensePlate, String[] words) {
			// 按长度排序
			Arrays.sort(words, Comparator.comparing(String::length));;
			// 解析每个字符串，顺序由List保证，内容由Map保证
			List<Map<Character, Long>> ls = Arrays.stream(words).map(w->wordMap(w)).toList();
			// licensePlate删除数字空格，解析成Map
			String s = licensePlate.toLowerCase().replaceAll("[0-9]", "").replaceAll(" ", "");
			Map<Character, Long> ms = wordMap(s);
			
			OUT:
			for(int i=0; i<ls.size(); i++) {
				Map<Character, Long> c = ls.get(i);
				for(Map.Entry<Character, Long> en:ms.entrySet()) {
					Character k = en.getKey();
					Long v = en.getValue();
					if(!c.containsKey(k)) {
						continue OUT;
					}
					if(c.get(k)<v) {
						continue OUT;
					}
				}
				return words[i];
			}
			// 题目数据保证一定存在一个最短补全词, 所以不会到这里
			return null;
		}
		/**
		 * 解析字符串s，得到字符和出现次数的Map
		 */
		Map<Character, Long> wordMap(String s){
			return s.chars().mapToObj(i->(Character)((char)i))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		}
	}
	public static void main(String[] args){
		L748 x = new L748();
		L748.Solution o = x.new Solution();
		
		// 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]		输出："steps"
		assert(o.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}).equals("steps"));
		// 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]		输出："pest"
		assert(o.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}).equals("pest"));
	}
}
