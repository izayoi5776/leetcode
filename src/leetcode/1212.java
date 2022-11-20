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
    int out = obj.fib(30);
    System.out.print(Arrays.toString(obj.cache));
  }
}

class Solution {
    int cache[] = new int[99]; // we have hint 0 ≤ N ≤ 30
    public int fib(int N) {
      if(N==0){
        return 0;
      }else if(N==1){
        return 1;
      }else if(cache[N] != 0){
        return cache[N];
      }else{
        int ret = fib(N-1) + fib(N-2);
        cache[N] = ret;
        return ret;
      }
    }
}
