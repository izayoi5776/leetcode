package leetcode;

// 520. 检测大写字母
public class L520 {
	public class Solution {
		public boolean detectCapitalUse(String word) {
			Boolean fst = null;	// 第一个字母，null初始值，true是大写，false是小写
			Boolean snd = null;	// 第二个字母，null初始值，true是大写，false是小写
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				if(c>='A' && c<='Z') {
					if(fst==null) {
						// A
						fst=true;
					}else if(fst){
						if(snd==null) {
							// AA
							snd=true;
							continue;
						} else if(snd) {
							// AAA
							continue;
						} else {
							// AaA
							return false;
						}
					} else {
						// aA
						return false;
					}
				} else {
					// a
					if(fst==null) {
						// a
						fst=false;
						continue;
					} else if(fst) {
						// Aa
						if(snd==null) {
							snd = false;
							continue;
						} else if(snd) {
							// AAa
							return false;
						} else {
							// Aaa
							continue;
						}
					} else {
						// aa
						if(snd==null) {
							snd=false;
							continue;
						} else if(snd) {
							// aAa
							return false;
						} else {
							// aaa
							continue;
						}
					}
				}
				
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		L520 x = new L520();
		L520.Solution o = x.new Solution();
		
		// 输入：word = "USA"		输出：true
		assert(o.detectCapitalUse("USA"));
		// 输入：word = "FlaG"		输出：false
		assert(!o.detectCapitalUse("FlaG"));
		assert(o.detectCapitalUse("AAAAAAA"));
		assert(o.detectCapitalUse("aaaaaaa"));
		assert(!o.detectCapitalUse("aAAAAA"));
		assert(o.detectCapitalUse("Aaaaaaa"));
		assert(!o.detectCapitalUse("AAAAAa"));
		assert(o.detectCapitalUse("A"));
		assert(o.detectCapitalUse("a"));
		assert(o.detectCapitalUse("Aa"));
		assert(o.detectCapitalUse("aa"));
		assert(!o.detectCapitalUse("aA"));

	}
}
