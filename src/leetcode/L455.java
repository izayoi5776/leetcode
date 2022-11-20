package leetcode;

import java.util.Arrays;
import java.util.List;

// 455. 分发饼干
public class L455 {
	public class Solution {
		public int findContentChildren(int[] g, int[] s) {
			List<Integer> gg = Arrays.stream(g).sorted().boxed().toList();
			List<Integer> ss = Arrays.stream(s).sorted().boxed().toList();
			
			int ret = 0;
			int j=0;
			for(int i=0; i<gg.size(); i++) {
				int gn = gg.get(i);	// 胃口
				for(; j<ss.size(); j++) {
					int sn = ss.get(j); // 饼干尺寸
					if(sn>=gn) {
						ret++;
						j++;
						break;
					}
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L455 x = new L455();
		L455.Solution o = x.new Solution();
		
		// 输入: g = [1,2,3], s = [1,1]		输出: 1
		assert(o.findContentChildren(new int[] {1,2,3}, new int[] {1,1})==1);
		// 输入: g = [1,2], s = [1,2,3]		输出: 2
		assert(o.findContentChildren(new int[] {1,2}, new int[] {1,2,3})==2);
		assert(o.findContentChildren(new int[] {2,1}, new int[] {3,2,1,1})==2);
		assert(o.findContentChildren(new int[] {2,1,4}, new int[] {3,2,1,1})==2);

	}
}
