/******************************************************************************

1379. 找出克隆二叉树中的相同节点
https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

*******************************************************************************/

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return chk(cloned, target.val);
    }
    TreeNode chk(TreeNode tree, int val){
        TreeNode ret = tree;
        if(tree==null){
            // ret = null;
        }else if(tree.val==val){
            // ret = tree;
        }else{
            ret = chk(tree.left, val);
            if(ret==null){
                ret = chk(tree.right, val);
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
	    System.out.println("buildTree() itree=" + Arrays.toString(itree));
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
    	        System.out.println("tree=" + this);
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
                ret += "null,";
            }else{
                ret += cnd.val + ",";
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
		//t1();
		t2();
	}

	static void tbase(final TreeNode original, final TreeNode cloned, final TreeNode target){
	    Solution o = new Solution();
	    System.out.println("tree=" + original + " ret=" + o.getTargetCopy(original, cloned, target));
	}
	static void t1(){
	    //  tree = [7,4,3,null,null,6,19], target = 3
	    TreeNode t1 = new TreeNode(7, 
	        new TreeNode(4),
	        new TreeNode(3,
	            new TreeNode(6),
	            new TreeNode(19)
	        )
	    );
	    tbase(t1, t1, new TreeNode(3));
	}
	static void t2(){
	    Integer[] itree = {7,4,3,null,null,6,19};
	    tbase(new TreeNode(itree), new TreeNode(itree), new TreeNode(3));
	}

}
