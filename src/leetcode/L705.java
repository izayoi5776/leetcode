package leetcode;

// 705. 设计哈希集合
public class L705 {
	class MyHashSet {
		boolean[] a;
		boolean zero;
	    public MyHashSet() {
	    	 a = new boolean[1000001];
	    }
	    
	    public void add(int key) {
	    	a[key] = true;
	    }
	    
	    public void remove(int key) {
	    	a[key] = false;
	    }
	    
	    public boolean contains(int key) {
	    	return a[key];
	    }
	}

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */


	public static void main(String[] args){
		L705 x = new L705();
		
		// 输入：	["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
		//	    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
		// 输出：	[null, null, null, true, false, null, true, null, false]
		L705.MyHashSet o = x.new MyHashSet();
		o.add(1);      // set = [1]
		o.add(2);      // set = [1, 2]
		assert(o.contains(1)); // 返回 True
		assert(!o.contains(3)); // 返回 False ，（未找到）
		o.add(2);      // set = [1, 2]
		assert(o.contains(2)); // 返回 True
		o.remove(2);   // set = [1]
		assert(!o.contains(2)); // 返回 False ，（已移除）

	}
}
