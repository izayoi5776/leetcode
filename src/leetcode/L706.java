package leetcode;

// 706. 设计哈希映射
public class L706 {
	class MyHashMap {
		int[] a;
	    public MyHashMap() {
	    	a = new int[1000001];
	    	for(int i=0; i<a.length; i++) {
	    		a[i] = -1;
	    	}
	    }
	    
	    public void put(int key, int value) {
	    	a[key] = value;
	    }
	    
	    public int get(int key) {
	    	return a[key];
	    }
	    
	    public void remove(int key) {
	    	a[key]=-1;
	    }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */


	public static void main(String[] args){
		L706 x = new L706();
		
		// 输入：		["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
		//		[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
		// 输出：	[null, null, null, 1, -1, null, 1, null, -1]
		L706.MyHashMap o = x.new MyHashMap();
		o.put(1, 1); // myHashMap 现在为 [[1,1]]
		o.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
		assert(o.get(1)==1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
		assert(o.get(3)==-1);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
		o.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
		assert(o.get(2)==1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
		o.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
		assert(o.get(2)==-1);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]

	}
}
