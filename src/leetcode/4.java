/******************************************************************************

4. 寻找两个正序数组的中位数
https://leetcode-cn.com/problems/median-of-two-sorted-arrays/

*******************************************************************************/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

class RecDouble{
    Rec r1;
    Rec r2;
    int n;
    boolean even;
    int targetLo;
    int targetHi;

    RecDouble(Rec r1, Rec r2){
        this.r1 = r1;
        this.r2 = r2;
        this.n = r1.nums.length + r2.nums.length;
        this.even = n % 2 == 0;
        this.targetLo = (n - 1) / 2;
        this.targetHi = this.even ? targetLo + 1 : targetLo;

        r1.setTarget(targetLo, targetHi);
        r2.setTarget(targetLo, targetHi);
    }
    double chk(){
        int route = 0;
        double ret = 0.0;
        if(r1.isBlank() && r2.isBlank()){
            // 不可能
            route=7;
            System.out.printf("chk()=%f route=%d\n", ret, route);
        }else if(r1.isBlank()){
            ret = r2.getMid();
            route = 1;
            System.out.printf("chk()=%f route=%d\n", ret, route);
        }else if(r2.isBlank()){
            ret = r1.getMid();
            route = 2;
            System.out.printf("chk()=%f route=%d\n", ret, route);
        }else{
            double m1 = r1.getMid();
            double m2 = r2.getMid();
            if(m1==m2){
                ret = m1;
                route = 3;
                System.out.printf("chk()=%f route=%d\n", ret, route);
            }else if(r1.size()==1 && r2.size()==1){
                // 各剩 1 个
                if(n%2==0){
                    // 整体长度是偶数
                    ret = (0.0 + m1 + m2) / 2.0;
                    route = 4;
                    System.out.printf("chk()=%f route=%d\n", ret, route);
                }else{
                    // 整体长度是奇数
                    int small = r1.posMid + r2.posMid;
                    //int big   = r1.nums.length - r1.posMid -1 + r2.nums.length - r2.posMid - 1;
                    if(small==targetLo){
                        ret = m1<m2 ? m1 : m2;
                    }else{
                        ret = m1<m2 ? m2 : m1;
                    }
                    route = 5;
                    System.out.printf("chk()=%f route=%d\n", ret, route);
                }
            }else if(r1.atTarget || r2.atTarget){
                // 如果有一边达到目标长度
                if(even){
                    // 偶数需要2个值。a系列是到达target的, b系列是没有到达的
                    Rec ra, rb;
                    double ma, mb;
                    if(r1.atTarget){
                        ra = r1;
                        ma = m1;
                        rb = r2;
                        mb = m2;
                    }else{
                        ra = r2;
                        ma = m2;
                        rb = r1;
                        mb = m1;
                    }
                    mb = findMB(ra, ma, rb, mb);
                    ret = (0.0 + ma + mb) / 2.0;
                }else{
                    // 奇数只需要一个值
                    ret = r1.atTarget ? m1 : m2;
                }
            } else{
                r1.setLim(m2);
                r2.setLim(m1);
                ret = chk();
                route = 6;
                System.out.printf("chk()=%f route=%d\n", ret, route);
            }
        }
        //System.out.printf("chk()=%f route=%d\n", ret, route);
        return ret;
    }
    // 找出MB.
    // ra是到达target的Rec。
    double findMB(Rec ra, double ma, Rec rb, double mb){
        double ret = mb;
        if(ma<mb){
            // 向上找
            double ma1 = ra.posMid+1 < ra.nums.length ? ra.nums[ra.posMid+1] : Double.MAX_VALUE;
            ret = ma1;
            int pos = rb.posFrom;
            while(pos<=rb.posMid){
                double mb1 = rb.nums[pos];
                if(mb1>ma && mb1<ma1){
                    ret = mb1;
                    break;
                }
                pos++;
            }

        }else{
            // 向下找
            double ma1 = ra.posMid-1 >= 0 ? ra.nums[ra.posMid-1] : -1 * Double.MAX_VALUE;
            ret = ma1;
            int pos = rb.posTo-1;
            while(pos>=rb.posMid){
                double mb1 = rb.nums[pos];
                if(mb1<ma && mb1>ma1){
                    ret = mb1;
                    break;
                }
                pos--;
            }
        }
        return ret;
    }
}
class Rec{
    int[] nums;
    int posMid;
    double midVal;
    int targetLo;
    int targetHi;
    double upperLimit = Double.POSITIVE_INFINITY;
    double lowerLimit = Double.NEGATIVE_INFINITY;
    int cntFromLoEnd;
    int cntFromHiEnd;
    int posFrom;
    int posTo;
    boolean atTarget;
    boolean haveLimit;
    //boolean even;
    Rec(int[] nums){
        this.nums = nums;
        posFrom = 0;
        posTo = nums.length;
        //even = nums.length % 2 == 0 ? true : false;
        if(isValid()){
            _getMid();
        }
    }
    int size(){
        return posTo - posFrom;
    }
    void setTarget(int lo, int hi){
        this.targetLo = lo;
        this.targetHi = hi;
    }
    // 设置上下限, 移动from/to
    void setLim(double d){
        double m = midVal;
        if(m<d){
            // 如果自己的中位值小
            lowerLimit = m>lowerLimit ? m : lowerLimit;
            upperLimit = d<upperLimit ? d : upperLimit;

            if(size()>1){
                posFrom = posMid + 1;
            }
        }else{
            // 如果自己的中位值大
            lowerLimit = d>lowerLimit ? d : lowerLimit;
            upperLimit = m<upperLimit ? m : upperLimit;
            if(size()>1){
                posTo = posMid + (isEven() ? 1 : 0);
            }
        }
        haveLimit = true;
        //System.out.printf("%s setLim(%f) m=%f\n", this.toString(), d, m);
    }
    // 检查from/to关系，目标上下限
    boolean fix(){
        boolean ret = false;
        if(isValid() && !atTarget){
            while(posTo > posFrom){
                double m = _getMid();
                if(m>upperLimit){
                    if(posMid==posTo-1){
                        posTo--;
                    }else{
                        posTo = posMid+1;
                    }
                    ret = true;
                }else if(m<lowerLimit){
                    if(posMid==posFrom){
                        posFrom++;
                    }else{
                        posFrom = posMid;
                    }
                    ret = true;
                }else{
                    break;
                }
            }

            if(haveLimit && (posMid>=targetLo || posMid<= nums.length - targetHi)){
                posFrom = posMid;
                posTo = posMid + 1;
                ret = true;
                _getMid();
                atTarget = true;
            }
        }
        System.out.printf("%s fix()=%b\n", this.toString(), ret);
        return ret;
    }
    boolean isBlank(){
        boolean ret = true;
        fix();
        ret = posTo <= posFrom;
        return ret;
    }
    // 取现在范围的中位值
    double getMid(){
        double ret = midVal;
        System.out.printf("%s getMid()=%f\n", this.toString(), ret);
        return ret;
    }
    private double _getMid(){
        double ret = 0.0;
        if(posTo == posFrom+1){
            posMid = posFrom;
            ret = nums[posMid];
        }else{
            posMid = (posTo - posFrom - 1) / 2 + posFrom;
            cntFromLoEnd = posMid+1;
            cntFromHiEnd = nums.length - posMid;
            if(isEven() && posTo > posFrom+1){
                ret = (0.0 + nums[posMid] + nums[posMid+1]) / 2.0;
                cntFromLoEnd += 0.5;
                cntFromHiEnd -= 0.5;
            }else{
                ret = nums[posMid];
            }
        }
        midVal = ret;
        return ret;
    }
    boolean isEven(){
        return (posTo - posFrom) % 2 == 0;
    }
    boolean isValid(){
        boolean ret = false;
        if(nums!=null && nums.length>0 && posFrom>=0 && posTo<=nums.length && posFrom<=posTo){
            ret = true;
        }
        return ret;
    }
    public String toString(){
        return String.format("Rec{nums=%s pos(%d, %d, %d) lim=(%f, %f) target=(%d, %d) even=%b}", Arrays.toString(nums), posFrom, posMid, posTo, lowerLimit, upperLimit, targetLo, targetHi, isEven());
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ret = 0.0;
        RecDouble rd = new RecDouble(new Rec(nums1), new Rec(nums2));
        ret = rd.chk();
        return ret;
    }
}
// -------------------------------------------------------
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
        //t1();
        t2();
	}
	static void t1(){
		tbase(2.0, new int[]{1,3}, new int[]{2});
		tbase(2.0, new int[]{2}, new int[]{1,3});

        tbase(2.5, new int[]{1,2}, new int[]{3,4});
        tbase(2.5, new int[]{3,4}, new int[]{1,2});

        tbase(2.0, new int[]{1,2}, new int[]{3});
        tbase(2.0, new int[]{3}, new int[]{1,2});

        tbase(3.0, new int[]{1,4}, new int[]{3});
        tbase(3.0, new int[]{3}, new int[]{1,4});

        tbase(5.5, new int[]{1,3,5,7,11,13}, new int[]{2,4,6,8});
        tbase(5.5, new int[]{2,4,6,8}, new int[]{1,3,5,7,11,13});

        tbase(11.0, new int[]{11,13,15,17,19}, new int[]{2,4,6,8});
        tbase(11.0, new int[]{2,4,6,8}, new int[]{11,13,15,17,19});

        tbase(12.0, new int[]{11,13,15,17,19,21}, new int[]{2,4,6,8});
        tbase(12.0, new int[]{2,4,6,8}, new int[]{11,13,15,17,19,21});

        tbase(1.0, new int[]{}, new int[]{1});    // 3 of 2085
    }
    static void t2(){
        tbase(1.5, new int[]{1,2}, new int[]{-1,3});    // 693 of 2085
    }
}
