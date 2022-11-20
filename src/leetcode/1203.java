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
    List<Integer> out = obj.getRow(33);
    System.out.print(out);
  }
}

class Solution {
  public List<Integer> getRow(int rowIndex) {
    return getRow(0, rowIndex, null);
  }
  // recursion helper
  private List<Integer> getRow(int curRow, int rowIndex, List<Integer> lastRow){
    if(curRow > rowIndex){
      return lastRow;
    }else{
      return getRow(curRow + 1, rowIndex, compRow(curRow, lastRow));
    }
  }
  // comp one Row
  private List<Integer> compRow(int curRow, List<Integer> lastRow){
    List<Integer> ret = new ArrayList<Integer>();
    if(curRow>0){
      ret.add(1);
      for(int col=2; col<=curRow; col++){
        ret.add(lastRow.get(col-2) + lastRow.get(col-1));
      }
    }
    ret.add(1);
    //System.out.println("compRow() curRow=" + curRow + " ret=" + ret);
    return ret;
  }
}

