package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 703. 数据流中的第 K 大元素
public class L703 {
	class KthLargest {
    	List<Integer> ls;
    	int k;
	    public KthLargest(int k, int[] nums) {
	    	this.k = k;
	    	ls = new ArrayList<>();
	    	ls.addAll(Arrays.stream(nums).boxed().sorted().toList());
	    }
	    
	    public int add(int val) {
	    	ls.add(val);
	    	Collections.sort(ls);
	    	int ret = ls.get(ls.size() - k);
	    	return ret;
	    }
	}

	/**
	 * Your KthLargest object will be instantiated and called as such:
	 * KthLargest obj = new KthLargest(k, nums);
	 * int param_1 = obj.add(val);
	 */

	public static void main(String[] args){
		L703 x = new L703();
		
		// 输入：	["KthLargest", "add", "add", "add", "add", "add"]
		//		[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
		// 输出：	[null, 4, 5, 5, 8, 8]
		L703.KthLargest o = x.new KthLargest(3, new int[] {4, 5, 8, 2});
		assert(o.add(3)==4);
		assert(o.add(5)==5);
		assert(o.add(10)==5);
		assert(o.add(9)==8);
		assert(o.add(4)==8);
	}
}
