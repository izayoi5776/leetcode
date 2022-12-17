package leetcode;

// 717. 1 比特与 2 比特字符
public class L717 {
	public class Solution {
		public boolean isOneBitCharacter(int[] bits) {
			if(bits==null || bits.length<0) {
				return false;
			}
			// 只有一位必定是 true
			if(bits.length==1) {
				return true;
			}
			// 最后两位是 00 必定是 true 
			if(bits[bits.length-2]==0) {
				return true;
			}

			boolean chk0 = chk(bits, bits.length-2);
			//boolean chk10 = chk(bits, bits.length-3);
			
			// 不存在两种都走通的路
			//return chk0 && !chk10;
			return chk0;
		}
		/**
		 * 检查是否有一条路能走通
		 */
		boolean chk(int[] bits, int pos){
			if(pos<0) {
				return false;
			}
			if(pos==0 && bits[0]==0) {
				return true;
			}
			if(pos==1 && bits[0]==1) {
				return true;
			}
			boolean chk0 = false;
			if(bits[pos]==0) {
				chk0 = chk(bits, pos-1);
			}
			boolean chk10 = false;
			if(pos>0 && bits[pos-1]==1 && bits[pos]==0) {
				chk10 = chk(bits, pos-2);
			}
			boolean chk11 = false;
			if(pos>0 && bits[pos-1]==1 && bits[pos]==1) {
				chk11 = chk(bits, pos-2);
			}
			return chk0 || chk10 || chk11;
		}
	}



	public static void main(String[] args){
		L717 x = new L717();
		L717.Solution o = x.new Solution();
		
		// 输入: bits = [1, 0, 0]		输出: true
		assert(o.isOneBitCharacter(new int[] {1, 0, 0}));
		// 输入：bits = [1,1,1,0]		输出：false
		assert(!o.isOneBitCharacter(new int[] {1,1,1,0}));
	
	}
}
