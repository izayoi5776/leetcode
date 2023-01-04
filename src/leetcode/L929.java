package leetcode;

import java.util.HashSet;
import java.util.Set;

// 929. 独特的电子邮件地址
public class L929 {
	public class Solution {
		public int numUniqueEmails(String[] emails) {
			Set<String> st = new HashSet<>();
			for (int i = 0; i < emails.length; i++) {
				st.add(chk(emails[i]));
			}
			return st.size();
		}
		String chk(String s){
			String[] mail = s.split("@");
			String local = mail[0].replaceAll("\\+.*$", "");
			local = local.replaceAll("\\.", "");
			return local + "@" + mail[1];
		}
	}
	public static void main(String[] args){
		L929 x = new L929();
		L929.Solution o = x.new Solution();
		
		// 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
		// "testemail+david@lee.tcode.com"]		输出：2
		assert(o.numUniqueEmails(new String[] {"test.email+alex@leetcode.com"
				,"test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"})==2);
		
		// 输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]		输出：3
		assert(o.numUniqueEmails(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"})==3);

	}
}
