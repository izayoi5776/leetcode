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
      TreeNode root = new TreeNode(3);
      TreeNode t9 = new TreeNode(9);
      TreeNode t20 = new TreeNode(20);
      TreeNode t15 = new TreeNode(15);
      TreeNode t7 = new TreeNode(7);
      root.left = t9;
      root.right = t20;
      t20.left = t15;
      t20.right = t7;
      
    Solution obj = new Solution();
    int out = obj.maxDepth(root);
    System.out.println("ret=" + out);
  }
}

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  @Override
  public String toString(){
    String ret="self=" + val;
    if(left == null){ret += " left=NULL";}else{ ret += " left=" + left.val;}
    if(right == null){ret += " right=NULL";}else{ret += " right=" + right.val;}
    return ret;
  }
}

class Solution {
    public int maxDepth(TreeNode root) {
      //System.out.println(root);
      if(root == null){
        return 0;
      }else{
          int left = maxDepth(root.left);
          int right= maxDepth(root.right);
          //System.out.println("depth left=" + left + " right=" + right);
          return Math.max(left, right) + 1;
      }
    }
}

