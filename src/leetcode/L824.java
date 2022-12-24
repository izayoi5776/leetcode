package leetcode;

// 824. 山羊拉丁文
public class L824 {
	public class Solution {
		public String toGoatLatin(String sentence) {
			String[] words = sentence.split(" ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < words.length; i++) {
				String w = words[i];
				char c = w.charAt(0);
				if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
					|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
					sb.append(w);
				} else {
					sb.append(w.substring(1));
					sb.append(String.valueOf(c));
				}
				sb.append("ma");
				for (int j = 0; j <= i; j++) {
					sb.append("a");
				}
				if(i<words.length-1) {
					sb.append(" ");
				}
			}
			return sb.toString();
		}
	}
	public static void main(String[] args){
		L824 x = new L824();
		L824.Solution o = x.new Solution();
		
		// 输入：sentence = "I speak Goat Latin"		输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
		assert(o.toGoatLatin("I speak Goat Latin")
				.equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
		
		// 输入：sentence = "The quick brown fox jumped over the lazy dog"
		// 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
		assert(o.toGoatLatin("The quick brown fox jumped over the lazy dog")
				.equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));

		assert(o.toGoatLatin("a").equals("amaa"));
		assert(o.toGoatLatin("e ya").equals("emaa aymaaa"));

		// 69/99
		assert(o.toGoatLatin("Each word consists of lowercase and uppercase letters only")
				.equals("Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa"));
	}
}
