/******************************************************************************

105. 从前序与中序遍历序列构造二叉树
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

*******************************************************************************/
//import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return chk(preorder, inorder);
    }
    TreeNode chk(int[] preorder, int[] inorder){
        TreeNode ret = null;
        if(preorder!=null && inorder!=null && preorder.length>0 && inorder.length>0){
            int c = preorder[0];
            int[][] subIn = sub(inorder, c);
            int[] leftIn = subIn[0];
						int[] rightIn= subIn[1];
            int[] leftPre = Arrays.copyOfRange(preorder, 1, 1+leftIn.length);
						int[] rightPre= Arrays.copyOfRange(preorder, preorder.length - rightIn.length, preorder.length);
						
            //System.out.printf("inorder=%s c=%d left=%s right=%s\n", Arrays.toString(inorder), c, Arrays.toString(leftIn), Arrays.toString(rightIn));
						ret = new TreeNode(c);
						ret.left = chk(leftPre, leftIn);
						ret.right= chk(rightPre, rightIn);
				}
				//System.out.printf("chk()=%s\n", ret);
        return ret;        
    }
    // 从中序之中分离出左右子串
    int[][] sub(int[] inorder, int c){
			int[][] ret = new int[2][0];
			//System.out.printf("sub(%s, %d)", Arrays.toString(inorder), c);
			int pos = 0;
			if(inorder!=null && inorder.length>0){
				while(pos<inorder.length && inorder[pos]!=c){
					pos++;
				}
				int[] left  = Arrays.copyOfRange(inorder, 0, pos);
				int[] right = Arrays.copyOfRange(inorder, Math.min(pos+1, inorder.length), inorder.length);
				ret = new int[][]{left, right};
			}
			//System.out.printf("=%s\n", Arrays.deepToString(ret));
			return ret;
    }
}
// -------------------------------------------------------
/**
 * Definition for a binary tree node.
 */
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
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object b){
        boolean ret = false;
        if(b!=null){
            TreeNode nd = (TreeNode)b;
            if(this.val!=nd.val){
                // ret=false;
            }else{
                boolean retl = left==null ? (nd.left ==null ? true : false) : this.left.equals(nd.left);
                boolean retr = right==null? (nd.right==null ? true : false) : this.right.equals(nd.right);
                if(retl && retr){
                    ret=true;
                }
            }
        }
        return ret;
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
		t2();
		t3();
		t4();
		t5();
	}
	static void t1(){
		tbase(new TreeNode(new Integer[]{3,9,20,null,null,15,7}), new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
	}
	static void t2(){
		// 10 of 203
		tbase(new TreeNode(new Integer[]{1,2,null,3}), new int[]{1,2,3}, new int[]{3,2,1});
	}
	static void t3(){
		// 24 of 203 ?
		tbase(new TreeNode(new Integer[]{1,2,null,3}), new int[]{7,-10,-4,3,-1,2,-8,11}, new int[]{-4,-10,3,-1,7,11,-8,2});
	}
	static void t4(){
		// 23 of 203
		tbase(new TreeNode(new Integer[]{3,9,20,null,null,15,7}), new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
	}
	static void t5(){
		// 167 of 203
		tbase(new TreeNode(new Integer[]{7,-10,2,-4,3,-8,null,null,null,null,-1,11}), new int[]{7,-10,-4,3,-1,2,-8,11}, new int[]{-4,-10,3,-1,7,11,-8,2});
	}
}
