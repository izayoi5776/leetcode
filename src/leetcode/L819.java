package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// 819. 最常见的单词
public class L819 {
	public class Solution {
		public String mostCommonWord(String paragraph, String[] banned) {
			// 小写
			String s = paragraph.toLowerCase();
			// 删除符号
			s = s.replaceAll("[!?',;.]", " ");
			// 分割单词
			String[] sa = s.split(" +");
			// 禁用词查找用字典
			Set<String> b = Arrays.stream(banned).collect(Collectors.toSet());
			// 统计单词出现次数，不包含禁用词
			Map<String, Long> m = Arrays.stream(sa)
					.filter(i->!b.contains(i))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			// 最多出现的次数
			Long max = m.entrySet().stream().mapToLong(e->e.getValue()).max().orElse(0);
			// 找出对于词
			Map.Entry<String, Long> ret = m.entrySet().stream()
				.filter(e->e.getValue()==max)
				.findAny().orElse(null);
			if(ret==null) {
				return null;
			}
			return ret.getKey();
		}
	}
	public static void main(String[] args){
		L819 x = new L819();
		L819.Solution o = x.new Solution();
		
		// 输入: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."	banned = ["hit"]	输出: "ball"
		assert(o.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}).equals("ball"));
	}
}
