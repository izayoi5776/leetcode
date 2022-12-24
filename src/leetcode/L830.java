package leetcode;

import java.util.ArrayList;
import java.util.List;

// 830. 较大分组的位置
public class L830 {
	public class Solution {
		public List<List<Integer>> largeGroupPositions(String s) {
			List<List<Integer>> ret = new ArrayList<>();
			char charStart = s.charAt(0);
			int posStart = 0;
			int posEnd = 0;
			for (int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c==charStart) {
					posEnd=i;
				} else {
					if(posEnd-posStart>1) {
						add(ret, posStart, posEnd);
					}
					charStart=c;
					posStart=i;
					posEnd=i;
				}
			}
			if(posEnd-posStart>1) {
				add(ret, posStart, posEnd);
			}
			return ret;
		}
		/**
		 * 把 [posStart, posEnd]的List 添加到 ret 中
		 */
		void add(List<List<Integer>> ret, int posStart, int posEnd){
			List<Integer> t = new ArrayList<>();
			t.add(posStart);
			t.add(posEnd);
			ret.add(t);
		}
	}
	public static void main(String[] args){
		L830 x = new L830();
		L830.Solution o = x.new Solution();
		
		// 输入：s = "abbxxxxzzy"		输出：[[3,6]]
		System.out.println(o.largeGroupPositions("abbxxxxzzy"));
		
		// 输入：s = "abc"		输出：[]
		System.out.println(o.largeGroupPositions("abc"));

		// 输入：s = "abcdddeeeeaabbbcd"		输出：[[3,5],[6,9],[12,14]]
		System.out.println(o.largeGroupPositions("abcdddeeeeaabbbcd"));
		// 输入：s = "aba"		输出：[]
		System.out.println(o.largeGroupPositions("aba"));
	}
}
