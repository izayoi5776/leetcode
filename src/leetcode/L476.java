package leetcode;

// 476. 数字的补数
public class L476 {
	public class Solution {
		public int findComplement(int num) {
			int mask = Integer.highestOneBit(num) - 1;
			int not = ~num;
			int ret = not & mask;
			return ret;
		}
	}
	
	public static void main(String[] args){
		L476 x = new L476();
		L476.Solution o = x.new Solution();
		
		// 输入：num = 5		输出：2
		assert(o.findComplement(5)==2);
		// 输入：num = 1		输出：0
		assert(o.findComplement(1)==0);
	}
}
