//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.ArrayList;

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    Solution obj = new Solution();
    List<List<Integer>> out = obj.generate(0);
    System.out.print(out);
  }
}

class Solution {
  public List<List<Integer>> generate(int numRows) {
    if(numRows<=0){
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      return ret;
    }else{
      List<List<Integer>> ret = generate(numRows - 1);
      List<Integer> curRow = new ArrayList<Integer>();
      for(int col=1; col<=numRows; col++){
        if(numRows==1){
          curRow.add(comp(numRows, col, null));
        }else{
          curRow.add(comp(numRows, col, ret.get(ret.size() - 1)));
        }
      }
      ret.add(curRow);
      return ret;
    }
  }
  // comp one value
  private int comp(int row, int col, List<Integer> lastRow){
    if(row<=1 || col<=1 || col>=row){
      return 1;
    }else{
      return lastRow.get(col-2) + lastRow.get(col-1);
    }
  }
}

