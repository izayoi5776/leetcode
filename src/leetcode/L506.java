package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

// 506. 相对名次
public class L506 {
	public class Solution {
		public String[] findRelativeRanks(int[] score) {
			// key=score[i], val=i
			SortedMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
			for(int i=0; i<score.length; i++) {
				m.put(score[i], i);
			}
			
			Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();
			int i=1;
			String[] ret = new String[score.length];
			while(it.hasNext()) {
				String txt = String.valueOf(i);
				if(i==1) {
					txt = "Gold Medal";
				} else if(i==2){
					txt = "Silver Medal";
				} else if(i==3) {
					txt = "Bronze Medal";
				}
				ret[it.next().getValue()]=txt;
				i++;
			}
			return ret;
		}
	}
	
	public static void main(String[] args){
		L506 x = new L506();
		L506.Solution o = x.new Solution();
		
		// 输入：score = [5,4,3,2,1]		输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
		assert(Arrays.equals(o.findRelativeRanks(new int[] {5,4,3,2,1}), new String[] {"Gold Medal","Silver Medal","Bronze Medal","4","5"}));
		// 输入：score = [10,3,8,9,4]		输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
		assert(Arrays.equals(o.findRelativeRanks(new int[] {10,3,8,9,4}), new String[] {"Gold Medal","5","Bronze Medal","Silver Medal","4"}));
	}
}
