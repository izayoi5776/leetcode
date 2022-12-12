package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

// 657. 机器人能否返回原点
public class L657 {
	public class Solution {
		public boolean judgeCircle(String moves) {
			// 问题等价于比较 LR 和 UD 的个数是否相等
			Map<Character, Long> m = moves.chars()
					.mapToObj(i->(char)i)
					.collect(Collectors.groupingBy(c->c, Collectors.counting()));
			long l = m.getOrDefault('L', 0L);
			long r = m.getOrDefault('R', 0L);
			long u = m.getOrDefault('U', 0L);
			long d = m.getOrDefault('D', 0L);
			if(l== r && u==d) {
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L657 x = new L657();
		L657.Solution o = x.new Solution();
		
		// 输入: moves = "UD"		输出: true
		assert(o.judgeCircle("UD"));
		// 输入: moves = "LL"		输出: false
		assert(!o.judgeCircle("LL"));
	}
}
