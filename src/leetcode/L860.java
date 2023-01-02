package leetcode;

// 860. 柠檬水找零
public class L860 {
	public class Solution {
		public boolean lemonadeChange(int[] bills) {
			// 手中的5，10，20块钱的张数
			int b5=0, b10=0, b20=0;
			for (int i = 0; i < bills.length; i++) {
				int n = bills[i];
				// 收到5块钱
				if(n==5) {
					b5++;
				// 收到10块钱
				} else if(n==10) {
					if(b5<1) {
						return false;
					}
					b10++;
					b5--;
				// 收到20块钱
				} else {
					// n == 20
					if(b10>0 && b5>0) {
						b20++;
						b10--;
						b5--;
					} else if(b10<=0 && b5>2) {
						b20++;
						b5-=3;
					} else {
						return false;
					}
				}
			}
			return true;
		}
	}
	public static void main(String[] args){
		L860 x = new L860();
		L860.Solution o = x.new Solution();
		
		// 输入：bills = [5,5,5,10,20]		输出：true
		assert(o.lemonadeChange(new int[] {5,5,5,10,20}));
		
		// 输入：bills = [5,5,10,10,20]		输出：false
		assert(!o.lemonadeChange(new int[] {5,5,10,10,20}));

	}
}
