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

class Rec{
    List<Integer> ls = new ArrayList<>();
    List<Integer> rem  = new ArrayList<>();
    int nullcount = 0; // 最大n+1个null
    //boolean left = false; // true=LEFT
    Rec(int n, List<Integer> rem){
        ls.add(n);
        this.rem = rem;
        this.nullcount = rem.size();
    }
    Rec(int n){nullcount=n;}
    // 复制 ls 和 rem，并把 n 从 rem 中移到 ls 里面
    Rec next(Integer n){
        Rec ret = new Rec(nullcount);
        ret.ls = new ArrayList<>(ls);
        ret.ls.add(n);
        ret.rem = new ArrayList<>(rem);
        if(n==null){
            ret.nullcount--;
            if(nullcount<0){
                ret = null;
            }
        }else{
            ret.rem.remove(n);
        }
        //ret.left = !left;
        return ret;
    }
    public String toString(){
        return "" + ls + "_" + nullcount + "_" + rem;
    }
	/**
	 * 通过输入的配列初始化一棵二叉树
	 * 例 tree = [7,4,3,null,null,6,19]
	 * 配列是对树的广度搜索，从上到下，从左到右，空分支用null
	 */
	TreeNode getTree(){
	    Integer[] itree = ls.toArray(new Integer[ls.size()]);
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
    	        //System.out.println("tree=" + ret);
    	    }
	    }
	    //System.out.println("buildTree() END itree=" + Arrays.toString(itree) + " ret=" + ret);
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
}
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        Queue<Rec> todo = new ArrayDeque<>();
        List<Rec> done = new ArrayList<>();
        for(int i=1; i<=n; i++){
            int t = i;
            List<Integer> rem = new ArrayList<>();
            for(int j=1; j<=n; j++){
                if(j!=i){
                    rem.add(j);
                }
            }
            todo.add(new Rec(i, rem));
        }
        //System.out.println("todo=" + todo);
        while(todo.size()>0){
            Rec c = todo.remove();
            if(c.rem.size()<=0){
                done.add(c);
            }else{
                for(int i=-1; i<c.rem.size(); i++){
                    Rec next = null;
                    if(i<0){
                        next = c.next(null);
                        if(next!=null){
                            todo.add(next);
                        }
                    }else{
                        next = c.next(c.rem.get(i));
                        todo.add(next);
                    }
                }
            }
            //System.out.println("todo=" + todo);
            //System.out.println("done=" + done);
        }
        //System.out.println("done=" + done);
        // 变换成树
        for(Rec r:done){
            ret.add(r.getTree());
        }
        //System.out.println("ret=" + ret);
        // 搜索树：左侧小，右侧大，整个子树都需要满足
        List<TreeNode> ret2 = new ArrayList<>();
        for(int i=0; i<ret.size(); i++){
            TreeNode c = ret.get(i);
            if(chk(c, null, null)){
                ret2.add(c);
            }
        }
        //System.out.println("ret2=" + ret2);
        
        // 长度测试
        List<TreeNode> ret3 = new ArrayList<>();
        for(int i=0; i<ret2.size(); i++){
            TreeNode c = ret2.get(i);
            int cnt = countNotNull(c);
            if(cnt == n){
                ret3.add(c);
            }
        }
        //System.out.println("ret3=" + ret3);
        return ret3;
    }
    // 检查是否符合 搜索树。true表示符合。
    boolean chk(TreeNode nd, Integer uplimit, Integer downlimit){
        boolean ret = false;
        // 空可以
        if(nd == null){
            ret = true;
        }else{
            // 自己符合条件
            if(   (uplimit   == null || uplimit  !=null && nd.val < uplimit)
               && (downlimit == null || downlimit!=null && nd.val > downlimit)
            ){
                // 子树,上下限条件收紧
                if(   chk(nd.left , nd.val, downlimit)
                   && chk(nd.right, uplimit, nd.val)
                ){
                    ret = true;
                }
            }
        }
        //System.out.println("nd=" + nd + " up=" + uplimit + " dn=" + downlimit + " ret=" + ret);
        return ret;
    }
    int countNotNull(TreeNode nd){
	    int ret = 0;
	    if(nd!=null){
	        ret = 1;
	        ret += nd.left==null ? 0 : countNotNull(nd.left);
	        ret += nd.right==null ? 0 : countNotNull(nd.right);
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
		//debug();
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
	    //tbase(3);
	    tbase(4);
	}
	static void debug(){
	    Rec r = new Rec(4);
	    r.ls = Arrays.asList(new Integer[]{2, 1, 3, null, null, null, 4});
	    r.getTree();
	}
}
