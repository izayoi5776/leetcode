package leetcode;

// 278. 第一个错误的版本
public class L278 {
	
	public class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	    	int lo=1, hi=n;
	    	while(hi>lo) {
		    	int m = (hi - lo)/2 + lo;
		    	if(isBadVersion(m)) {
		    		hi = m-1;
		    	}else {
		    		lo = m+1;
		    	}
	    	}
    		if(isBadVersion(lo)) {
    			return lo;
    		}else {
    			return lo+1;
    		}
	    }
	}
	
	public class VersionControl{
		int bad;
		public void setBad(int n) {bad=n;} 
		boolean isBadVersion(int version) {return version>=bad;}
		
	}
	public static void main(String[] args){
		L278 x = new L278();
		L278.Solution o = x.new Solution();
		
		// 输入：n = 5, bad = 4		输出：4
		o.setBad(4);
		assert(o.firstBadVersion(5)==4);
		
		// 输入：n = 1, bad = 1		输出：1
		o.setBad(1);
		assert(o.firstBadVersion(1)==1);

		o.setBad(1);
		assert(o.firstBadVersion(2)==1);
		o.setBad(2);
		assert(o.firstBadVersion(2)==2);
		o.setBad(256);
		assert(o.firstBadVersion(999)==256);
		o.setBad(1);
		assert(o.firstBadVersion(3)==1);
		o.setBad(2);
		assert(o.firstBadVersion(3)==2);
		o.setBad(3);
		assert(o.firstBadVersion(3)==3);
		o.setBad(1702766719);
		assert(o.firstBadVersion(2126753390)==1702766719);
	}
}
