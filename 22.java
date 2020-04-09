/******************************************************************************

22. 括号生成
https://leetcode-cn.com/problems/generate-parentheses/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Rec{
    String s="";   // 现在的括号文字列
    int n=0;      // 就是题设的n，括号对数
    int op=0;     // 开括号数
    int ed=0;     // 闭括号数
    Rec(String s, int n, int op, int ed){
        this.s = s;
        this.n = n;
        this.op = op;
        this.ed = ed;
    }
    // 从自身求下一步
    List<Rec> next(){
        List<Rec> ret = new ArrayList<Rec>();
        if(op<n){
            ret.add(new Rec(s + "(", n, op+1, ed));
        }
        if(ed<n && ed<op){
            ret.add(new Rec(s + ")", n, op, ed+1));
        }
        return ret;
    }
    boolean isDone(){
        boolean ret = false;
        if(op>=n && ed>=n){
            ret = true;
        }
        return ret;
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<Rec> todo = new Rec("", n, 0, 0).next();
        Map<String, Integer> mp = new HashMap<String, Integer>();
        while(todo.size()>0){
            Rec r = todo.remove(0);
            if(r.isDone()){
                mp.put(r.s, 0);
            }else{
                todo.addAll(r.next());
            }
        }
        return new ArrayList<>(mp.keySet());
    }
    
    // 错误，n=4时漏掉了 "(())(())" 作为教训留在这里
    public List<String> generateParenthesis1(int n) {
        Map<String, Integer> mp = new HashMap<String, Integer>(){
            {
                put("", 0);
            }
        };
        for(int i=0; i<n; i++){
            mp = chk1(mp);
        }
        return new ArrayList<>(mp.keySet());
    }
    Map<String, Integer> chk1(Map<String, Integer> mp){
        Map<String, Integer> ret = new HashMap<String, Integer>();
        for(String sub:mp.keySet()){
            ret.put("(" + sub + ")", 0);
            ret.put("()" + sub + "", 0);
            ret.put("" + sub + "()", 0);
        }
        return ret;
    }
    
}


public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(int n, Map<String, Integer> expect){
	    Solution o = new Solution();
	    List<String> ret = o.generateParenthesis(n);
	    System.out.println("n=" + n + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(List<String> chkret, Map<String,Integer> expect){
	    Map<String, Integer> r1 = new HashMap<String, Integer>();
	    for(String s:chkret){
	        r1.put(s, 0);
	    }
	    boolean ret = true;
	    if(r1.size() == expect.size()){
	        for(String s:r1.keySet()){
	            if(!expect.containsKey(s)){
	                ret = false;
	                break;
	            }
	        }
	    }
	    return ret;
	}
	static void t1(){
	    tbase(3, new HashMap<String,Integer>(){{
          put("((()))",0);
          put("(()())",0);
          put("(())()",0);
          put("()(())",0);
          put("()()()",0);
        }});
	}
	static void t2(){
	    tbase(4, new HashMap<String, Integer>(){{
            put("(((())))",0);
            put("((()()))",0);
            put("((())())",0);
            put("((()))()",0);
            put("(()(()))",0);
            put("(()()())",0);
            put("(()())()",0);
            put("(())(())",0);
            put("(())()()",0);
            put("()((()))",0);
            put("()(()())",0);
            put("()(())()",0);
            put("()()(())",0);
            put("()()()()",0);
        }});
	}
	
}

