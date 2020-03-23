/******************************************************************************

945. 使数组唯一的最小增量
https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/

*******************************************************************************/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Todo{
    int value;  // 要处理的数字
    int num;    // 重复的回数, 不包括最初的一个。
    public Todo(int v){
        value = v;
        num = 1;
    }
    public String toString(){
        return "(" + value + "," + num + ")";
    }
}
class Block{
    int from;   // 开始数字
    int to;     // 结束数字
    public Block(int f, int t){
        from = f;
        to = t;
    }
    public String toString(){
        return "(" + from + "," + to + ")";
    }
}

class Solution {
    public int minIncrementForUnique(int[] A) {
        List<Todo> todolst = new ArrayList<Todo>();
        Queue<Block> blocklst = new ArrayDeque<Block>();
        
        Arrays.sort(A);
        int ret = 0;
        if(A.length < 1){
            //ret = 0;
        }else{
            int st = A[0]; // 开始数字，最小
            Todo td = null;
            //Block bk = null;
            for(int i=1; i<A.length; i++){
                int nx = A[i];
                if(nx == st + 1){
                    // 自然顺序，不需要管
                    st = nx;
                    if(td!=null){
                        todolst.add(td);
                        td = null;
                    }
                }else if(nx == st){
                    // 重复数字，记录到TODO中
                    if(td==null){
                        td = new Todo(st);      // lazy init
                    }else if(td.value!=st){
                        todolst.add(td);
                        td = new Todo(st);      // new todo
                    }else{
                        // td.value == st;
                        td.num++;
                    }
                }else{
                    // nx > st + 1 时把空的部分保存到blocklst里面
                    blocklst.offer(new Block(st+1, nx-1));
                    st = nx;
                }
            }
            if(td != null){
                todolst.add(td);
                td = null;
            }
            blocklst.offer(new Block(A[A.length-1]+1, Integer.MAX_VALUE));
        }
        // 到这里把 todolst和blocklst准备好了
        System.out.println("A=" + Arrays.toString(A) + " todolst=" + todolst + " blocklst=" + blocklst);

        // 计算差距
        Todo td2 = null;
        Block bk2 = null;
        for(int i=0; i<todolst.size(); i++){
            td2 = todolst.get(i);
            for(int j=0; j<td2.num; j++){
                // 找到空位
                while(true){
                    if(bk2!=null){
                        if(bk2.to < td2.value){
                            bk2 = null;
                            continue;
                        }
                    }else{
                        if(blocklst.size()==0){
                            break;
                        }else{
                            bk2 = blocklst.poll();
                            if(bk2.to < td2.value){
                                bk2 = null;
                                continue;
                            }
                        }
                    }
                    break;
                }
                // 到这里，bk2中有空位，bk2.to > bk2.from > td2.value
                ret += (bk2.from - td2.value);
                if(bk2.to > bk2.from){
                    bk2.from++;
                }else{
                    bk2=null;
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
	private static void tbase(int[] A, int real){
	    Solution o = new Solution();
	    System.out.println(" A=" + Arrays.toString(A) + " ret=" + o.minIncrementForUnique(A) + " respect=" + real);
	}
	private static void t1(){
	    int[] A = {1,2,2};
	    tbase(A, 1);
	}
	private static void t2(){
	    int[] A = {3,2,1,2,1,7};
	    tbase(A, 6);
	}

}



