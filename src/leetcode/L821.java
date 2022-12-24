package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// 821. 字符的最短距离
public class L821 {
	public class Solution {
		public int[] shortestToChar(String s, char c) {
			int[] ret = new int[s.length()];
			for (int i = 0; i < ret.length; i++) {
				ret[i] = Integer.MAX_VALUE;
			}
			// 扫描整个s寻找c
			for (int i = 0; i < s.length(); i++) {
				char t = s.charAt(i);
				if(t!=c) {
					continue;
				}
				// 题目数据保证 c 在 s 中至少出现一次
				// 从现在位置向两侧搜索到边界或者另一个c为止
				ret[i]=0;
				for (int j = i-1; j >=0; j--) {
					char tj = s.charAt(j);
					if(tj==c) {
						break;
					}
					int nj = i-j; // 到i的距离
					if(nj<ret[j]) {
						ret[j]=nj;
					} else {
						break;
					}
				}
				// 向前也同样
				for (int j = i+1; j<s.length(); j++) {
					char tj = s.charAt(j);
					if(tj==c) {
						break;
					}
					int nj = j-i; // 到i的距离
					if(nj<ret[j]) {
						ret[j]=nj;
					} else {
						break;
					}
				}
			}
			return ret;
		}
	}
	public static void main(String[] args){
		L821 x = new L821();
		L821.Solution o = x.new Solution();
		
		// 输入：s = "loveleetcode", c = "e"		输出：[3,2,1,0,1,0,0,1,2,2,1,0]
		assert(Arrays.equals(o.shortestToChar("loveleetcode", 'e'), new int[] {3,2,1,0,1,0,0,1,2,2,1,0}));
		
		// 输入：s = "aaab", c = "b"		输出：[3,2,1,0]
		assert(Arrays.equals(o.shortestToChar("aaab", 'b'), new int[] {3,2,1,0}));
	}
}
