package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L13 {
	class Solution {
		public int romanToInt(String s) {
			Map<String, Integer> m3 = new HashMap<>();
			m3.put("III", 3);
			Map<String, Integer> m2 = new HashMap<>();
			m2.put("II", 2);
			m2.put("IV", 4);
			m2.put("IX", 9);
			m2.put("XL", 40);
			m2.put("XC", 90);
			m2.put("CD", 400);
			m2.put("CM", 900);
			Map<String, Integer> m1 = new HashMap<>();
			m1.put("I", 1);
			m1.put("V", 5);
			m1.put("X", 10);
			m1.put("L", 50);
			m1.put("C", 100);
			m1.put("D", 500);
			m1.put("M", 1000);
	    	int ret = 0;
	    	
	    	while(s.length()>0) {
	    		int n = chkMap(m3, s);
	    		if(n!=0) {
	    			s = s.substring(3);
	    			ret += n;
	    			continue;
	    		}
	    		n = chkMap(m2, s);
	    		if(n!=0) {
	    			s = s.substring(2);
	    			ret += n;
	    			continue;
	    		}
	    		n = chkMap(m1, s);
	    		if(n!=0) {
	    			s = s.substring(1);
	    			ret += n;
	    			continue;
	    		}
	    	}
	    	return ret;
	    }
		/**
		 * 循环查看m 的 key 是否在 s 的先头，在就返回 value，否则返回 0 
		 * @param m 搜索MAP
		 * @param s 被搜索字符串
		 * @return 非0：找到的值， 0：没找到
		 */
		int chkMap(Map<String, Integer>m, String s){
			for(Map.Entry<String, Integer> entry : m.entrySet()) {
				if(s.startsWith(entry.getKey())) {
					return entry.getValue();
				}
			}
			return 0;
		}
	}
	public static void main(String[] args){
		L13 x = new L13();
		L13.Solution o = x.new Solution();
		assert(o.romanToInt("III")==3);
		assert(o.romanToInt("IV")==4);
		assert(o.romanToInt("IX")==9);
		assert(o.romanToInt("LVIII")==58);
		assert(o.romanToInt("MCMXCIV")==1994);
	}
}
