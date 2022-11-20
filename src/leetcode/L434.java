package leetcode;

// 434. 字符串中的单词数
public class L434 {
	
	public class Solution {
		public int countSegments(String s) {
			int ret=0;
			boolean word = false;
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c==' ') {
					if(word) {
						ret+=1;
						word=false;
					}
				}else {
					word=true;
				}
			}
			if(word) {
				ret+=1;
				word=false;
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L434 x = new L434();
		L434.Solution o = x.new Solution();
		
		// 输入: "Hello, my name is John"		输出: 5
		assert(o.countSegments("Hello, my name is John")==5);
		assert(o.countSegments(" a b c ")==3);
		assert(o.countSegments("  ")==0);
		assert(o.countSegments("  a   b   c   ")==3);

	}
}
