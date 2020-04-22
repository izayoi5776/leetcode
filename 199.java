/******************************************************************************

199. 二叉树的右视图
https://leetcode-cn.com/problems/binary-tree-right-side-view/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;
import java.util.SortedMap;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        SortedMap<Integer, TreeNode> mp = new TreeMap<>();
        chk(root, 0, mp);
        
        List<Integer> ret = new ArrayList<>();
        for(TreeNode nd:mp.values()){
            ret.add(nd.val);
        }
        return ret;
    }
    // 分层从左到右填入Map，同层右侧后执行，所以留下
    void chk(TreeNode nd, int level, Map<Integer, TreeNode>mp){
        if(nd!=null){
            mp.put(level, nd);
            chk(nd.left, level+1, mp);
            chk(nd.right, level+1, mp);
        }
    }
}


class TreeNode {
    int val;
    boolean nullflg = false;
    TreeNode left;
    TreeNode right;
    TreeNode() { nullflg=true; }
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode lt, TreeNode rt) {
        val = x;
        left = lt;
        right = rt;
    }
	/**
	 * 通过输入的配列初始化一棵二叉树
	 * 例 tree = [7,4,3,null,null,6,19]
	 * 配列是对树的广度搜索，从上到下，从左到右，空分支用null
	 */
	TreeNode(Integer[] itree){
	    //System.out.println("buildTree() itree=" + Arrays.toString(itree));
	    if(itree.length>0){
    	    Queue<TreeNode> todo = new ArrayDeque<TreeNode>();
    	    val = itree[0];
    	    int pos = 1; // 指示在 itree 中的位置
    	    todo.add(this);
    	    while(todo.size()>0){
    	        TreeNode cnd = todo.remove(); // 现在处理中的 node
    	        Integer cval = 0;
    	        cval = getN(itree, pos);
    	        // left
    	        if(cval==null){
    	            // cnd.left = null;
    	        }else{
    	            TreeNode tmp = new TreeNode(cval);
    	            cnd.left = tmp;
                    todo.add(tmp);
    	        }
    	        pos++;
    	        cval = getN(itree, pos);

    	        // right
    	        if(cval==null){
    	            // cnd.right = null;
    	        }else{
    	            TreeNode tmp = new TreeNode(cval);
    	            cnd.right = tmp;
                    todo.add(tmp);
    	        }
    	        pos++;
    	        //System.out.println("tree=" + this);
    	    }
	    }
	}
	// get itree[pos], return null if invalid
	private static Integer getN(Integer[] itree, int pos){
	    Integer ret = null;
	    if(itree==null || pos < 0 || pos >= itree.length){
	        // ret = null;
	    }else{
	        ret = itree[pos];
	    }
	    return ret;
	}
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
    static void tbase(TreeNode root, List<Integer> expect){
	    Solution o = new Solution();
	    List<Integer> ret = o.rightSideView(root);
	    System.out.println("root=" + root + " ret=" + ret + " expect=" + expect + (chk(ret,expect)?" OK":" NG"));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static <T>boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static void t1(){
	    tbase(new TreeNode(new Integer[]{1,2,3,null,5,null,4}), new ArrayList<Integer>(){
	        {
	            add(1);
	            add(3);
	            add(4);
	        }
	    });
	}
}
