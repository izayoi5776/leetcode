package leetcode;

// 925. 长按键入
public class L925 {
	public class Solution {
		public boolean isLongPressedName(String name, String typed) {
			int pos1=0;
			int pos2=0;
			while(pos1<=name.length() && pos2<typed.length()) {
				char c2 = typed.charAt(pos2);
				if(pos1<name.length()) {
					char c1 = name.charAt(pos1);
					if(c1==c2) {
						pos1++;
						pos2++;
						continue;
					}
				}
				if(pos1==0) {
					return false;
				}
				char cm1 = name.charAt(pos1-1);
				if(cm1==c2) {
					pos2++;
					continue;
				} else {
					return false;
				}
			}
			if(pos1==name.length() && pos2==typed.length()) {
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args){
		L925 x = new L925();
		L925.Solution o = x.new Solution();
		
		// 输入：name = "alex", typed = "aaleex"		输出：true
		assert(o.isLongPressedName("alex", "aaleex"));
		
		// 输入：name = "saeed", typed = "ssaaedd"		输出：false
		assert(!o.isLongPressedName("saeed", "ssaaedd"));

		// 69/94
		assert(o.isLongPressedName("vtkgn", "vttkgnn"));
	}
}
