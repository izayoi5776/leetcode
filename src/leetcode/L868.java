package leetcode;

// 868. 二进制间距
public class L868 {
	public class Solution {
		public int binaryGap(int n) {
			String s = Integer.toBinaryString(n);
			int start = -1;
			int max = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c=='0') {
					continue;
				}
				if(c=='1') {
					if(start==-1) {
						start=i;
						continue;
					} else {
						int cur = i-start;
						if(cur>max) {
							max=cur;
						}
						start=i;
					}
				}
			}
			return max;
		}
	}
	public static void main(String[] args){
		L868 x = new L868();
		L868.Solution o = x.new Solution();
		
		// 输入：n = 22		输出：2
		assert((o.binaryGap(22)==2));
		
		// 输入：n = 8		输出：0
		assert(o.binaryGap(8)==0);

		// 输入：n = 5		输出：2
		assert(o.binaryGap(5)==2);
		
		// 245/261
		assert(o.binaryGap(6)==1);
	}
}
