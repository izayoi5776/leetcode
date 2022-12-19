package leetcode;

// 771. 宝石与石头
public class L771 {
	public class Solution {
		public int numJewelsInStones(String jewels, String stones) {
			//Set<Character> st = jewels.chars().mapToObj(i->(char)i).collect(Collectors.toSet());
			int cnt=0;
			for (int j = 0; j < jewels.length(); j++) {
				char c = jewels.charAt(j);
				for(int i=0; i<stones.length(); i++) {
					char s = stones.charAt(i);
					if(c==s) {
						cnt++;
					}
				}
			}
			return cnt;
		}
	}
	public static void main(String[] args){
		L771 x = new L771();
		L771.Solution o = x.new Solution();
		
		// 输入：jewels = "aA", stones = "aAAbbbb"		输出：3
		assert(o.numJewelsInStones("aA","aAAbbbb")==3);
		// 输入：jewels = "z", stones = "ZZ"		输出：0
		assert(o.numJewelsInStones("z","ZZ")==0);
	}
}
