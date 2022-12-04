package leetcode;

// 507. 完美数
public class L507 {
	public class Solution {
		public boolean checkPerfectNumber(int num) {
			// 奇数一定不是完美数
			if(num%2==1) {
				return false;
			}
			int s = 1;
			for(int i=2; i<Math.sqrt(num); i++) {
				if(num%i==0) {
					s += i;
					s += num/i;
				}
			}
			return s==num;
		}
	}
	
	public static void main(String[] args){
		L507 x = new L507();
		L507.Solution o = x.new Solution();
		
		// 输入：num = 28		输出：true
		assert(o.checkPerfectNumber(28));
		// 输入：num = 7		输出：false
		assert(!o.checkPerfectNumber(7));
	}
}
