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
    double out = obj.myPow(2.00000, -2147483648);
    System.out.print(out);
  }
}

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            N = -N;  // you need long here when n=-2147483648, but Integer.MAX_VALUE=2147483647, -n is overflow!
            x = 1 / x;
        }
        double ans = 1;
        double grade = x;
        for(long i=N; i>0; i /= 2){
            if(i % 2 == 1){
                ans *= grade;
            }
            grade *= grade;
        }
      return ans;
    }
}
