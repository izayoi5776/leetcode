package leetcode;

// https://leetcode.cn/problems/merge-strings-alternately/
public class L1768 {
	class Solution {
		public String mergeAlternately(String word1, String word2) {
			int l1 = word1.length();
			int l2 = word2.length();
			StringBuilder sb = new StringBuilder(l1 + l2);
			for(int i=0, j=0; i<l1 || j<l2; i++, j++) {
				if(i<l1) {
					sb.append(word1.charAt(i));
				}
				if(j<l2) {
					sb.append(word2.charAt(j));
				}
			}
			return sb.toString();
	    }
	}
	
	public static void main(String[] args){
		L1768 x = new L1768();
		L1768.Solution o = x.new Solution();
		
		// 输入：word1 = "abc", word2 = "pqr"		输出："apbqcr"
		assert(o.mergeAlternately("abc", "pqr").equals("apbqcr"));
	
		// 输入：word1 = "ab", word2 = "pqrs"		输出："apbqrs"
		assert(o.mergeAlternately("ab", "pqrs").equals("apbqrs"));
		
		// 输入：word1 = "abcd", word2 = "pq"		输出："apbqcd"
		assert(o.mergeAlternately("abcd", "pq").equals("apbqcd"));
	}
}
