/******************************************************************************

二进制求和
https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/779/
https://leetcode-cn.com/problems/add-binary/submissions/

*******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String addBinary(String a, String b) {
        List<Integer> ls = new ArrayList<>();
        if(a==null){
            a = "";
        }
        if(b==null){
            b = "";
        }
        //return Integer.toBinaryString(Integer.valueOf(a, 2) + Integer.valueOf(b, 2));
        addBinary(a, b, 0, 0, ls);
        StringBuilder s = new StringBuilder(ls.size());
        for(int i=0; i<ls.size(); i++){
            s.append(String.format("%d", ls.get(i)));
        }
        return s.toString();
    }
    // a,b != null, rpos 是字符串从后面数的位置，acc 进位
    void addBinary(String a, String b, int rpos, int acc, List<Integer> ls){
        int posa = a.length() - 1 - rpos;
        int posb = b.length() - 1 - rpos;

        if(posa<0 && posb<0 && acc==0){
            
        }else{
            //System.out.printf("a=%s b=%s rpos=%d acc=%d posa=%d posb=%d ls=%s\n", a, b, rpos, acc, posa, posb, ls);
            int intA = posa>=0 ? Integer.valueOf(a.substring(posa, posa+1)) : 0;
            int intB = posb>=0 ? Integer.valueOf(b.substring(posb, posb+1)) : 0;
            
            int intCur = intA + intB + acc;
            int newAcc = 0;
            switch(intCur){
                case 0:
                    // 0, 0
                    break;
                case 1:
                    // 1, 0
                    break;
                case 2:
                    intCur = 0;
                    newAcc = 1;
                    break;
                case 3:
                    intCur = 1;
                    newAcc = 1;
                    break;
            }
            addBinary(a, b, rpos+1, newAcc, ls);
            ls.add(intCur);
        }
    }
    // 长度超过int表示能力的String处理不了
    public String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.valueOf(a, 2) + Integer.valueOf(b, 2));
    }
}

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(String a, String b, String expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    String ret = o.addBinary(a, b);
	    System.out.println("a=" + a  + " b=" + b + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static void t1(){
	    tbase("11", "1", "100");
	}
	static void t2(){
	    tbase(    "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
	        , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
	        , "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000");
	}
	

}

