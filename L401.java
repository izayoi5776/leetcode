package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 401. 二进制手表
public class L401 {
	
	public class Solution {
		public List<String> readBinaryWatch(int turnedOn) {
			List<String> ret = new ArrayList<>();
			for(int i=0; i<Math.pow(2, 10); i++) {
				if(Integer.bitCount(i)!=turnedOn) {
					continue;
				}
				int hour = (i & 0b1111000000) >>>6;
				if(hour>11 || hour <0) {
					continue;
				}
				int min = i & 0b111111;
				if(min>59 || min <0) {
					continue;
				}
				//System.out.println(String.format("hour=0x%h min=0x%h", hour, min));
				String s = String.format("%d:%02d", hour, min);
				ret.add(s);
				
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L401 x = new L401();
		L401.Solution o = x.new Solution();
		
		// 输入：turnedOn = 1
		// 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
		System.out.println(o.readBinaryWatch(1));
		// 输入：turnedOn = 9		输出：[]
		System.out.println(o.readBinaryWatch(9));
		
		// ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24",
		//  "0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16",
		//  "1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02",
		//  "4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08",
		//  "8:16","8:32","9:00","10:00"]
		System.out.println(o.readBinaryWatch(2));

	}
}
