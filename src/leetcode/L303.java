package leetcode;

// 303. 区域和检索 - 数组不可变
public class L303 {
	
	class NumArray {
		int[] nums;
	    public NumArray(int[] nums) {
	    	this.nums = nums;
	    }

	    public int sumRange(int left, int right) {
	    	int ret = 0;
	    	for(int i=left; i<=right; i++) {
	    		ret += nums[i];
	    	}
	    	return ret;
	    }
	}
	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(left,right);
	 */
	
	public static void main(String[] args){
		L303 x = new L303();
		//L303.Solution o = x.new Solution();
		
		// 输入：	["NumArray", "sumRange", "sumRange", "sumRange"]
		//		[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
		// 输出： [null, 1, -1, -3] 
		NumArray o = x.new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		assert(o.sumRange(0, 2)==1);
		assert(o.sumRange(2, 5)==-1);
		assert(o.sumRange(0, 5)==-3);
		
	}
}
