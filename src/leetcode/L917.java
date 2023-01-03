package leetcode;

// 917. 仅仅反转字母
public class L917 {
	public class Solution {
		public String reverseOnlyLetters(String s) {
			int start=0;
			int end=s.length()-1;
			char[] ret = new char[s.length()];
			while(start<=end) {
				char cs = s.charAt(start);
				if(!isAplpha(cs)) {
					ret[start]=cs;
					start++;
					continue;
				}
				char ce = s.charAt(end);
				if(!isAplpha(ce)) {
					ret[end]=ce;
					end--;
					continue;
				}
				// swap
				ret[start]=ce;
				ret[end]=cs;
				start++;
				end--;
			}
			return String.copyValueOf(ret);
		}
		boolean isAplpha(char c){
			return c>='a' && c<='z' || c>='A' && c<='Z';		
		}
	}
	public static void main(String[] args){
		L917 x = new L917();
		L917.Solution o = x.new Solution();
		
		// 输入：s = "ab-cd"		输出："dc-ba"
		assert(o.reverseOnlyLetters("ab-cd").equals("dc-ba"));
		
		// 输入：s = "a-bC-dEf-ghIj"		输出："j-Ih-gfE-dCba"
		assert(o.reverseOnlyLetters("a-bC-dEf-ghIj").equals("j-Ih-gfE-dCba"));

		// 输入：s = "Test1ng-Leet=code-Q!"		输出："Qedo1ct-eeLg=ntse-T!"
		assert(o.reverseOnlyLetters("Test1ng-Leet=code-Q!").equals("Qedo1ct-eeLg=ntse-T!"));
	}
}
