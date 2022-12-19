package leetcode;

import java.util.HashSet;
import java.util.Set;

// 762. 二进制表示中质数个计算置位
public class L762 {
	public class Solution {
		// 质数
		Set<Integer> pset = new HashSet<>();
		// 检查过的最大数字
		int pchk = 32;
		public Solution(){
			// java整数只有32位，这算是作弊吗
			pset.add(2);
			pset.add(3);
			pset.add(5);
			pset.add(7);
			pset.add(11);
			pset.add(13);
			pset.add(17);
			pset.add(19);
			pset.add(23);
			pset.add(29);
			pset.add(31);
			pset.add(37);
		}
		public int countPrimeSetBits(int left, int right) {
			int cnt = 0;
			for(int i=left; i<=right; i++) {
				int n = Integer.bitCount(i);
				if(prime(n)) {
					cnt++;
				}
			}
			return cnt;
		}
		
		boolean prime(int n) {
			// 1不是质数
			if(n==1) {
				return false;
			}
			if(n==2 || n==3 || n==5) {
				return true;
			}
			// 从4开始，质数保存，和数只记录最大的一个
			if(pset.contains(n)) {
				return true;
			} else if(n<=pchk) {
				return false;
			}
			
			for(int i=1; i<=Math.sqrt(n); i++) {
				// 只需要看可否被质数整除
				if(prime(i)) {
					if(n%i==0) {
						// 能整除是和数
						pchk=n;
						return false;
					}
				}
			}
			// 走到这里说明n是质数
			pset.add(n);
			pchk=n;
			return true;
		}
	}
	public static void main(String[] args){
		L762 x = new L762();
		L762.Solution o = x.new Solution();
		
		// 输入：left = 6, right = 10		输出：4
		assert(o.countPrimeSetBits(6,10)==4);
		// 输入：left = 10, right = 15		输出：5
		assert(o.countPrimeSetBits(10,15)==5);
	}
}
