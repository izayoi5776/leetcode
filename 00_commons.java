/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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



/******************************************************************************

53. 最大子序和
https://leetcode-cn.com/problems/maximum-subarray/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;
import java.lang.reflect.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int ret = Integer.MIN_VALUE;    // 空数组的情况题目没有定义
        
        if(nums!=null && nums.length>0){
            for(int i=0; i<nums.length; i++){
                long sum = 0L;
                for(int j=i; j<nums.length; j++){
                    sum += nums[j];
                    if(sum>ret){
                        ret = (int)sum;
                    }
                }
            }
        }
        //System.out.printf("maxSubArray(%s)=%d\n", Arrays.toString(nums), ret);
        return ret;
    }
}

// -------------------------------------------------------
public class Main
{
	public static void main(String[] args) {
		t1();
	}
	/*static void tbase1(int[] p1, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    int ret = o.maxSubArray(p1);
	    System.out.printf("tbase(%s, %s)=%s %s\n", s(p1), s(expect), s(ret), (chk(ret,expect)?" OK":" NG"));
	}*/
	// 用反射调用就不需要每次改代码了
	static void tbase(int[] p1, int expect){
		System.out.println("--------------------");
	    Solution o = new Solution();
	    Class cls = Solution.class;
	    Object ret = null;
        for(Method me : cls.getMethods()){
            // 只要Solution中的方法，应该只有一个
            if(me.getDeclaringClass()==cls){
                //System.out.println("call " + me + " getGenericReturnType()=" + me.getGenericReturnType());
                try{
                    ret = me.invoke(o, p1);
                    System.out.printf("tbase(%s, %s)=%s %s\n", s(p1), s(expect), s(ret), (chk(ret,expect)?" OK":" NG"));
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }

	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static boolean chk(int youret, int expect){
	    return youret==expect;
	}
	static <T> boolean chk(T youret, T expect){
	    return youret.equals(expect);
	}
	static boolean chk(int[] youret, int[] expect){
	    return Arrays.equals(youret, expect);
	}
	static String s(int n){	    return "" + n;	}
	static <T> T s(T n){	    return n;	}
	static String s(int[] n){	    return "" + Arrays.toString(n);	}
	
	static void t1(){
	    tbase(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);
	    tbase(new int[]{}, 0);
	    tbase(new int[]{0,0,0,0}, 0);
	    tbase(new int[]{-1,-2,-3}, -1);
	}
	
}
