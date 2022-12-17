package leetcode;

// 744. 寻找比目标字母大的最小字母
public class L744 {
	public class Solution {
		public char nextGreatestLetter(char[] letters, char target) {
			if(target=='z') {
				return letters[0];
			}
			char ret = chk(letters, (char)(target+1), 0, letters.length-1);
			return ret;
		}
		char chk(char[] letters, char target, int from, int to){
			if(from>to) {
				if(from>=letters.length || to<0) {
					return letters[0];
				}
				return letters[from];
			}
			int pos = from + (to - from)/2;
			char c = letters[pos];
			if(c==target) {
				return c;
			}
			if(c<target) {
				return chk(letters, target, pos+1, to);
			} else {
				return chk(letters, target, from, to-1);
			}
		}
	}
	public static void main(String[] args){
		L744 x = new L744();
		L744.Solution o = x.new Solution();
		
		// 输入: letters = ["c", "f", "j"]，target = "a"		输出: "c"
		assert(o.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a')=='c');
		// 输入: letters = ["c","f","j"], target = "c"		输出: "f"
		assert(o.nextGreatestLetter(new char[] {'c', 'f', 'j'},'c')=='f');
		// 输入: letters = ["x","x","y","y"], target = "z"		输出: "x"
		assert(o.nextGreatestLetter(new char[] {'x', 'x', 'y','y'},'z')=='x');

		assert(o.nextGreatestLetter(new char[] {'c', 'f', 'j'},'j')=='c');
	}
}
