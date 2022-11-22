package leetcode;

// 482. 密钥格式化
public class L482 {
	public class Solution {
		public String licenseKeyFormatting(String s, int k) {
			StringBuilder sb = new StringBuilder();
			int cnt = k;
			String ss = s.toUpperCase(); 
			for(int i=ss.length()-1; i>=0; i--) {
				char c = ss.charAt(i);
				if(c!='-') {
					if(cnt<=0) {
						cnt=k;
						sb.insert(0, '-');
					}
					sb.insert(0, c);
					cnt--;
				}
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args){
		L482 x = new L482();
		L482.Solution o = x.new Solution();
		
		// 输入：S = "5F3Z-2e-9-w", k = 4		输出："5F3Z-2E9W"
		assert(o.licenseKeyFormatting("5F3Z-2e-9-w", 4).equals("5F3Z-2E9W"));
		// 输入：S = "2-5g-3-J", k = 2		输出："2-5G-3J"
		assert(o.licenseKeyFormatting("2-5g-3-J", 2).equals("2-5G-3J"));
		// "--a-a-a-a--" "AA-AA"
		assert(o.licenseKeyFormatting("--a-a-a-a--", 2).equals("AA-AA"));
	}
}
