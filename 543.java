/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
// return code 
class Ret {
    int dm;         // 配下最大直径
    int dp;         // 深さ
    Ret(int dm, int dp){
        this.dm = dm;
        this.dp = dp;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return compute(root).dm;
    }
    private Ret compute(TreeNode root){
        if(root == null){
            return new Ret(0, 0); // nullの直径０、深さ０
        }else{
            Ret rl = compute(root.left);
            Ret rr = compute(root.right);
            int dp = Math.max(rl.dp, rr.dp) + 1; // 自分の深さは子供より１層深い
            int dm = Math.max(Math.max(rl.dm, rr.dm), rl.dp + rr.dp); // 自分の直径は配下の直径、子供の深さ和＋１の大きい方
            return new Ret(dm, dp);
        }
    }
}

public class Main{
	public static void main(String[] args) {
        Main o = new Main();
        o.test1();
	}
	// should be 3
	private void test1(){
		Solution o = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		System.out.println("dia=" + o.diameterOfBinaryTree(t1));	    
	}
	private void test2(){
		Solution o = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
    	t4.left = t6;
		t4.right = t7;
		t3.left = t8;
		t3.right = t9;
		t9.left = t10;
		t9.right = t11;

		System.out.println("dia=" + o.diameterOfBinaryTree(t1));
	}
	// should be 2
	private void test3(){
		Solution o = new Solution();
		TreeNode t4 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		t4.left = t2;
		t2.left = t1;
		t2.right = t3;
		System.out.println("dia=" + o.diameterOfBinaryTree(t4));
	}
}
