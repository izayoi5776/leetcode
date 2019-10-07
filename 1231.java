//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {

    Solution obj = new Solution();
    //int out = obj.kthGrammar(2, 1);
    //System.out.print(out);
    String s = "0";
    for(int i=0;i<6;i++){
      s = obj.draw(s);
      System.out.println(s);
    }
  }
}

class Solution {
  public int kthGrammar(int N, int K) {
     return Integer.bitCount(K - 1 ) % 2; // K start at 1
  }
  // see results from this func, if u notice 2nd half is a bit reverse to 1st half, it's a good start.
  public String draw(String s){
    //System.out.println("s=" + s);
    if(s.equals("") ) { return "";}
    if(s.equals("1")) { return "10";}
    if(s.equals("0")) { return "01";}
    return draw(s.substring(0,1)) + draw(s.substring(1));
  }
}
