/******************************************************************************

103. 二叉树的锯齿形层次遍历
https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> anext = null;
        Deque<TreeNode> q1 = new ArrayDeque<TreeNode>(); // 现在层
        Deque<TreeNode> qnext = null; // 下一层
        boolean l2r = true; // true = 从左到右
        if(root==null){
            // do nothing
        }else{
            q1.add(root);
            while(q1.size()>0){
                //System.out.println("start q1=" + q1 + " qnext=" + qnext + " l2r=" + l2r);
                TreeNode ctn = null;
                if(l2r){
                    ctn = q1.remove();
                }else{
                    ctn = q1.removeLast();
                }
                
                if(qnext==null){
                    qnext = new ArrayDeque<TreeNode>();
                    anext = new ArrayList<Integer>();
                }
                anext.add(ctn.val);
                if(l2r){
                    if(ctn.left  != null){qnext.add(ctn.left);}
                    if(ctn.right != null){qnext.add(ctn.right);}
                }else{
                    if(ctn.right != null){qnext.addFirst(ctn.right);}
                    if(ctn.left  != null){qnext.addFirst(ctn.left);}
                }

                // 本层处理完，切换下一层
                if(q1.size()<=0){
                    q1 = qnext;
                    qnext = null;
                    l2r = !l2r;
                    ret.add(anext);
                }
                //System.out.println("end   ctn=" + ctn + " q1=" + q1 + " qnext=" + qnext + " l2r=" + l2r);
            }
        }
        return ret;
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
            if(cnd.nullflg){
                ret += "null/";
            }else{
                ret += cnd.val + "/";
            }
            if(cnd.left==null && cnd.right==null){
                // do nothing
            }else{
                if(cnd.left==null){
                    todo.add(new TreeNode());
                }else{
                    todo.add(cnd.left);
                }
                if(cnd.right==null){
                    todo.add(new TreeNode());
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
		t2();
	}
    static void tbase(TreeNode root, int[][] expect){
	    Solution o = new Solution();
	    System.out.println("root=" + root + " ret=" + (o.zigzagLevelOrder(root))
	        + " expect=" + Arrays.deepToString(expect));
	}
	static void t1(){
	    tbase(new TreeNode(new Integer[]{3,9,20,null,null,15,7}), new int[][]{{3},{20,9},{15,7}});
	}
	static void t2(){
	    tbase(new TreeNode(new Integer[]{1,2,3,4,null,null,5}), new int[][]{{1},{3,2},{4,5}});
	}
}












