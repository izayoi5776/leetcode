package leetcode;

// 551. 学生出勤记录 I
public class L551 {
	public class Solution {
		public boolean checkRecord(String s) {
			boolean a = false;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				switch(c) {
				case 'A':
					if(a) {
						return false;
					}else {
						a = true;
					}
					break;
				case 'L':
					if(i>0 && i<s.length()-1) {
						if(s.charAt(i-1)=='L' && s.charAt(i+1)=='L') {
							return false;
						}
					}
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		L551 x = new L551();
		L551.Solution o = x.new Solution();
		
		// 输入：s = "PPALLP"		输出：true
		assert(o.checkRecord("PPALLP"));
		// 输入：s = "PPALLL"		输出：false
		assert(!o.checkRecord("PPALLL"));
	}
}
