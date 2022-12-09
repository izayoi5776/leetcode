package leetcode;

// 605. 种花问题
public class L605 {
	public class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			if(n<=0) {
				return true;
			}
			for(int i=0; i<flowerbed.length; i++) {
				if(flowerbed[i]==1) {
					continue;
				}
				boolean left = false;
				boolean right = false;
				if(i==0) {
					left=true;
				}
				if(i==flowerbed.length-1) {
					right=true;
				}
				if(!left && flowerbed[i-1]==0) {
					left=true;
				}
				if(!right && flowerbed[i+1]==0) {
					right=true;
				}
				if(left&&right) {
					flowerbed[i]=1;
					n--;
				}
				if(n<=0) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L605 x = new L605();
		L605.Solution o = x.new Solution();
		
		// 输入：flowerbed = [1,0,0,0,1], n = 1		输出：true
		assert(o.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
		// 输入：flowerbed = [1,0,0,0,1], n = 2		输出：false
		assert(!o.canPlaceFlowers(new int[] {1,0,0,0,1},2));
		// 122/124
		assert(!o.canPlaceFlowers(new int[] {1},0));
	}
}
