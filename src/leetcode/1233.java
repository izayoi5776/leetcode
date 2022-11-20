/******************************************************************************

不同的二叉搜索树 II
https://leetcode-cn.com/explore/featured/card/recursion-i/260/conclusion/1233/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Queue;
import java.util.ArrayDeque;


class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1; i<=n; i++){
            ls.add(i);
        }
        return chk(ls);
    }
    // ls 是升序的值序列
    List<TreeNode> chk(List<Integer> ls){
        //System.out.println("chk() START ls=" + ls);
        List<TreeNode> ret = new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            TreeNode root = new TreeNode(ls.get(i));
            List<Integer> left = ls.subList(0, i);
            List<Integer> right = ls.subList(i+1, ls.size());
            //System.out.println("chk() MID   ls=" + ls + " i=" + i + " root=" + root + " left=" + left + " right=" + right + " ret=" + ret);
            List<TreeNode> leftTree = chk(left);
            List<TreeNode> rightTree = chk(right);
            List<TreeNode> lm = merge(leftTree, root);
            ret.addAll(merge(lm, rightTree));
            //System.out.println("chk() END   ls=" + ls + " i=" + i + " root=" + root +  " left=" + left + " right=" + right + " ret=" + ret);
        }
        return ret;
    }
    // 合并左子树和根
    List<TreeNode> merge(List<TreeNode> leftTree, TreeNode root){
        List<TreeNode> ret = new ArrayList<>();
        if(leftTree.size()<=0){
            ret.add(root);
        }
        for(TreeNode left:leftTree){
            TreeNode leftcp = deepCopy(left);
            TreeNode rootcp = new TreeNode(root.val);
            rootcp.left = leftcp;
            ret.add(rootcp);
        }
        return ret;
    }
    // 合并右子树
    List<TreeNode> merge(List<TreeNode> leftTree, List<TreeNode> rightTree){
        List<TreeNode> ret = new ArrayList<>();
        if(rightTree.size()<=0){
            ret.addAll(leftTree);
        }
        for(TreeNode left:leftTree){
            for(TreeNode right:rightTree){
                TreeNode leftcp = deepCopy(left);
                TreeNode rightcp = deepCopy(right);
                leftcp.right = rightcp;
                ret.add(leftcp);
            }
        }
        //System.out.println("merge() left=" + leftTree + " right=" + rightTree + " ret=" + ret);
        return ret;
    }
    // deep copy
    TreeNode deepCopy(TreeNode nd){
        TreeNode ret = null;
        if(nd!=null){
            ret = new TreeNode(nd.val);
            if(nd.left!=null){
                ret.left = deepCopy(nd.left);
            }
            if(nd.right!=null){
                ret.right = deepCopy(nd.right);
            }
        }
        return ret;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    // 广度优先打印
    public String toString(){
        Queue<TreeNode> todo = new ArrayDeque<TreeNode>();
        String ret = "";
        todo.add(this);

        while(todo.size()>0){
            TreeNode cnd = todo.remove(); // current node
            if(cnd.val==-1){
                ret += "_/";
            }else{
                ret += cnd.val + "/";
            }
            //if(cnd.left==null && cnd.right==null){
                // do nothing
            //}else{
            if(cnd.val!=-1){
                if(cnd.left==null){
                    todo.add(new TreeNode(-1));
                }else{
                    todo.add(cnd.left);
                }
                if(cnd.right==null){
                    todo.add(new TreeNode(-1));
                }else{
                    todo.add(cnd.right);
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
	}
    static void tbase(int n){
	    Solution o = new Solution();
	    List<TreeNode> ret = o.generateTrees(n);
	    System.out.println("n=" + n + " ret=" + ret);
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static void t1(){
	    tbase(3);
	    tbase(4);
	    tbase(7);
	}
}
