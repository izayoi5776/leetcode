package leetcode;

// 374. 猜数字大小
public class L374 {
	
	/** 
	 * Forward declaration of guess API.
	 * @param  num   your guess
	 * @return 	     -1 if num is higher than the picked number
	 *			      1 if num is lower than the picked number
	 *               otherwise return 0
	 * int guess(int num);
	 */

	public class Solution extends GuessGame {
	    public int guessNumber(int n) {
	    	int l = 1;	// 下界
	    	int r = n;	// 上界
	    	int k = (r - l)/2 + l;
	        while(l<=r) {
	        	int sgn = guess(k);
	        	if(sgn==0) {
	        		break;
	        	}
	        	if(sgn<0) {
	        		r = k-1;
	        		k = (r - l)/2 + l;
	        	}else {
	        		l = k+1;
	        		k = (r - l)/2 + l;
	        	}
	        }
	        return k;
	    }
	}
	public class GuessGame{
		int pick = 0;
		void setPick(int pick){
			this.pick = pick;
		}
		int guess(int num) {return (int) Math.signum(pick-num);}
	}
	
	public static void main(String[] args){
		L374 x = new L374();
		L374.Solution o = x.new Solution();
		
		// 输入：n = 10, pick = 6		输出：6
		o.setPick(6);
		assert(o.guessNumber(10)==6);
		// 输入：n = 1, pick = 1		输出：1
		o.setPick(1);
		assert(o.guessNumber(1)==1);
		// 输入：n = 2, pick = 1		输出：1
		o.setPick(1);
		assert(o.guessNumber(2)==1);
		// 输入：n = 2, pick = 2		输出：2
		o.setPick(2);
		assert(o.guessNumber(2)==2);

	}
}
