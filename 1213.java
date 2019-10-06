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
    int out = obj.climbStairs(30);
    System.out.print(Arrays.toString(obj.cache));
  }
}

class Solution {
    int cache[] = new int[99]; // we guess 1 ≤ n ≤ 30
    public int climbStairs(int n) {
      if(n==1){
        return 1;
      }else if(n==2){
        return 2;
      }else if(cache[n] != 0){
        return cache[n];
      }else{
        int ret = climbStairs(n-1) + climbStairs(n-2);
        cache[n] = ret;
        return ret;
      }
    }
}
