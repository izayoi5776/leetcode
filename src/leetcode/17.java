/******************************************************************************

17. 电话号码的字母组合
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

*******************************************************************************/
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {
        return chk("", digits);
    }
    List<String> chk(String head, String digits){
        //System.out.println("chk() in head=" + head + " digits=" + digits);
        Map<Integer, String> mp = new HashMap<Integer, String>(){
            {
                put(2, "abc");
                put(3, "def");
                put(4, "ghi");
                put(5, "jkl");
                put(6, "mno");
                put(7, "pqrs");
                put(8, "tuv");
                put(9, "wxyz");
            }
        };
        //System.out.println("chk() mp=" + mp);
        List<String> ret = new ArrayList<String>();
        if(digits.length()<=0){
            // ret = null;
        }else{
            String s = mp.get(Integer.valueOf(digits.substring(0,1)));
            for(int i=0; i<s.length(); i++){
                if(digits.length()==1){
                    ret.add(head + s.substring(i,i+1));
                }else{
                    ret.addAll(chk(head + s.substring(i,i+1), digits.substring(1,digits.length())));    
                }
            }
        }
        return ret;
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		//t2();
		t3();
	}
    static void tbase(String digits){
	    Solution o = new Solution();
	    System.out.println("digits=" + digits + " ret=" + o.letterCombinations(digits));
	}
	static void t1(){
	    tbase("23");
	}
	static void t2(){
	    tbase("2394");
	}
	static void t3(){
	    tbase("");
	}
}
