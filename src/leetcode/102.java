/******************************************************************************

102. 二叉树的层序遍历
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
参考
103. 二叉树的锯齿形层次遍历
https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                    //l2r = !l2r;
                    ret.add(anext);
                }
                //System.out.println("end   ctn=" + ctn + " q1=" + q1 + " qnext=" + qnext + " l2r=" + l2r);
            }
        }
        return ret;
    }
}
// -------------------------------------------------------
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    // -------------
    TreeNode(Integer[] nds){
        TreeNode nd = TreeNodeHelper.buildTree(nds);
        this.val = nd.val;
        this.left = nd.left;
        this.right = nd.right;
    }
    public String toString(){
        return TreeNodeHelper.toString(this);
    }
}
 
class TreeNodeHelper {
	/**
	 * 通过输入的配列初始化一棵二叉树
	 * 例 tree = [7,4,3,null,null,6,19]
	 * 配列是对树的广度搜索，从上到下，从左到右，空分支用null
	 */
	static TreeNode buildTree(Integer[] itree){
	    TreeNode ret = null;
	    //System.out.println("buildTree() itree=" + Arrays.toString(itree));
	    if(itree.length>0){
    	    Queue<TreeNode> todo = new ArrayDeque<TreeNode>();
    	    ret = new TreeNode(itree[0]);
    	    int pos = 1; // 指示在 itree 中的位置
    	    todo.add(ret);
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
	    return ret;
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
    public static String toString(TreeNode nd){
        Queue<TreeNode> todo = new ArrayDeque<TreeNode>();
        String ret = "";
        todo.add(nd);

        while(todo.size()>0){
            TreeNode cnd = todo.remove(); // current node
            if(cnd.val==-1){
                ret += "_/";
            }else{
                ret += cnd.val + "/";
            }
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

// call sample
// TreeNode nd = TreeNodeHelper.buildTree(new Integer[]{2, 1, 3});
// System.out.println(TreeNodeHelper.toString(nd));


public class Main
{
	// 用反射调用就不需要每次改代码了
	static void tbase(Object expect, Object ... args){
		System.out.println("--------------------");
		Solution o = new Solution();
		Class cls = Solution.class;
		Object ret = null;
		for(Method me : cls.getMethods()){
			// 只要Solution中的方法，应该只有一个
			if(me.getDeclaringClass()==cls){
				try{
					long tm1 = System.nanoTime();
					ret = me.invoke(o, args);
					long tm2 = System.nanoTime();
					System.out.printf("tbase(%s", s(expect));
					for(Object ag : args){
						System.out.printf(", %s", s(ag));
					}
					System.out.printf(")=%s time:%,d ns %s\n", s(ret), tm2-tm1, chk(ret, expect)?"OK":"NG");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	static	 boolean chk(String youret, String expect){		return youret.equals(expect);	}
	static	 boolean chk(int	youret, int	expect){		return youret==expect;	}
	static <T> boolean chk(T	  youret, T	  expect){
		boolean ret = false;
		if(youret!=null){
			if(youret instanceof int[]){
				ret = Arrays.equals((int[])youret, (int[])expect);
			}else{
				ret = youret.equals(expect);	
			}
		}else if(youret==expect){
			ret = true;
		}
		return ret;
	}
	static <T> String  s(T n)	{
		if(n instanceof int[]){
			return Arrays.toString((int[])n);
		}else if(n instanceof int[][]){
			return Arrays.deepToString((int[][])n);
		}else{
			return "" + n;	
		}
	}

// -----------------------------------------------------------

	public static void main(String[] args) {
		t1();
	}
	static void t1(){
		tbase((Object)Arrays.asList(
                Arrays.asList(new int[]{3}),
                Arrays.asList(new int[]{9,20}),
                Arrays.asList(new int[]{15,7})
		    )
		, new TreeNode(new Integer[]{3,9,20,null,null,15,7,}));

	}
}
