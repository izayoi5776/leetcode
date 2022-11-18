package leetcode;

// 345. 反转字符串中的元音字母
public class L345 {
	
	class Solution {
		public String reverseVowels(String s) {
			char[] ca = new char[s.length()];
			int l=0;
			int r=s.length()-1;
			while(l<=r) {
				char cl = s.charAt(l);
				if(!isVowel(cl)){
					ca[l] = cl;
					l++;
					continue;
				}
				char cr = s.charAt(r);
				if(!isVowel(cr)) {
					ca[r] = cr;
					r--;
					continue;
				}
				// 交换元音
				ca[l] = cr;
				ca[r] = cl;
				l++;
				r--;
			}
			
			return String.valueOf(ca);
		}
		boolean isVowel(char c) {
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
			  || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'	) {
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		L345 x = new L345();
		L345.Solution o = x.new Solution();
		
		// 输入：s = "hello"		输出："holle" 
		assert(o.reverseVowels("hello").equals("holle"));
		// 输入：s = "leetcode"		输出："leotcede"
		assert(o.reverseVowels("leetcode").equals("leotcede"));
		
		assert(o.reverseVowels("a").equals("a"));
		assert(o.reverseVowels("ab").equals("ab"));
		assert(o.reverseVowels("abc").equals("abc"));
		assert(o.reverseVowels("abo").equals("oba"));
		assert(o.reverseVowels("ao").equals("oa"));
	}
}
