package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 599. 两个列表的最小索引总和
public class L599 {
	public class Solution {
		public String[] findRestaurant(String[] list1, String[] list2) {
			// key=串， val=位置
			Map<String, Integer> m1 = IntStream.range(0, list1.length)
					.boxed().collect(Collectors.toMap(i->list1[i], i->i));
			// key=串， val=位置
			Map<String, Integer> m2 = IntStream.range(0, list2.length)
					.boxed().collect(Collectors.toMap(i->list2[i], i->i));
			// key=串， val=位置和
			Map<String, Integer> m3 = m1.entrySet().stream()
					.filter(e->m2.containsKey(e.getKey()))
					.collect(Collectors.toMap(e->e.getKey(), e->m2.get(e.getKey())+e.getValue()));
			// 最小索引和
			int min = m3.values().stream().min(Integer::compare).orElse(0);
			List<String> ret = m3.entrySet().stream()
					.filter(e->e.getValue()==min)
					.map(e->e.getKey())
					.collect(Collectors.toList());
			return ret.toArray(new String[0]);
		}
	}
	
	public static void main(String[] args){
		L599 x = new L599();
		L599.Solution o = x.new Solution();
		
		// 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]
		// ，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
		// 输出: ["Shogun"]
		assert(Arrays.equals(o.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
				new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}),
				new String[] {"Shogun"}));
		// 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
		// list2 = ["KFC", "Shogun", "Burger King"]
		// 输出: ["Shogun"]
		assert(Arrays.equals(o.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
				new String[] {"KFC", "Shogun", "Burger King"}),
				new String[] {"Shogun"}));
	}
}
