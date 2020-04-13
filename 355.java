/******************************************************************************

355. 设计推特
https://leetcode-cn.com/problems/design-twitter/

*******************************************************************************/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Twitter {
    int time = 0;
    Map<Integer, TreeMap<Integer, Integer>> mp = new HashMap<>();  // userid, time, postid
    Map<Integer, Set<Integer>> mp2 = new HashMap<>();   // userid, followees

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        TreeMap<Integer, Integer> mpt = null; // map for twitter <time, postid>
        if(mp.containsKey(userId)){
            mpt = mp.get(userId);
        }else{
            mpt = new TreeMap<Integer, Integer>();
        }
        mpt.put(time++, tweetId);
        mp.put(userId, mpt);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> se = new HashSet<>();
        if(mp2.containsKey(userId)){
            se = mp2.get(userId);
        }
        se.add(userId);
        TreeMap<Integer, Integer> mpt = new TreeMap<>(); // time, postid
        for(Iterator i=se.iterator(); i.hasNext();){
            Integer u = (Integer)i.next();
            if(mp.containsKey(u)){
                int cnt = 0;
                for(Map.Entry<Integer, Integer> e : mp.get(u).descendingMap().entrySet()){
                    mpt.put(e.getKey(), e.getValue());
                    if(cnt++>=10){
                        break;
                    }
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        for(Integer pid : mpt.descendingMap().values()){
            ret.add(pid);
            if(cnt++>=9){
                break;
            }
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> se = null;
        if(mp2.containsKey(followerId)){
            se = mp2.get(followerId);
        }else{
            se = new HashSet<>();
        }
        if(se.contains(followeeId)){
            // do no-op
        }else{
            se.add(followeeId);
            mp2.put(followerId, se);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        //System.out.println("in  unfollow(" + followerId + "," + followeeId + ") mp2=" + mp2);
        Set<Integer> se = null;
        if(mp2.containsKey(followerId)){
            se = mp2.get(followerId);
        }
        
        if(se!= null && se.contains(followeeId)){
            se.remove(followeeId);
            if(se.size()>0){
                mp2.put(followerId, se);
            }else{
                mp2.remove(followerId);
            }
        }
        //System.out.println("out unfollow(" + followerId + "," + followeeId + ") mp2=" + mp2);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class Main
{
	public static void main(String[] args) {
		t1();
		t2();
	}
    static void tbase(String[] act, Integer[][] parm, Integer[][] expect){
	    Twitter twitter = null;
	    List<List<Integer>> ret = new ArrayList<>();
	    for(int i=0; i<act.length; i++){
	        switch(act[i]){
	           case "Twitter":
	               twitter = new Twitter();
	               ret.add(null);
	               break;
	           case "postTweet":
	               twitter.postTweet(parm[i][0], parm[i][1]);
	               ret.add(null);
	               break;
	           case "getNewsFeed":
	               ret.add(twitter.getNewsFeed(parm[i][0]));
	               break;
	           case "follow":
	               twitter.follow(parm[i][0], parm[i][1]);
	               ret.add(null);
	               break;
	           case "unfollow":
	               twitter.unfollow(parm[i][0], parm[i][1]);
	               ret.add(null);
	               break;
	        }
	    }
	    System.out.println("ret=" + ret);
	    System.out.println("exp=" + Arrays.deepToString(expect));
	}
	static boolean chk(String youret, String expect){
	    return youret.equals(expect);
	}
	static void t1(){
	    Twitter twitter = new Twitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));
        // 用户1关注了用户2.
        twitter.follow(1, 2);
        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);
        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));
        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);
        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
        
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 99);
        twitter.postTweet(1, 98);
        twitter.postTweet(1, 97);
        twitter.postTweet(1, 96);
        twitter.postTweet(1, 95);
        twitter.postTweet(1, 90);
        twitter.postTweet(1, 91);
        twitter.postTweet(1, 92);
        twitter.postTweet(1, 93);
        System.out.println(twitter.getNewsFeed(1));
	}
	static void t2(){
	    tbase(
	        new String[]{"Twitter","postTweet","follow","follow","getNewsFeed","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"},
	        new Integer[][]{{},{1,5},{1,2},{2,1},{2},{2,6},{1},{2},{2,1},{1},{2},{1,2},{1},{2}},
	        new Integer[][]{null,null,null,null,{5},null,{6,5},{6,5},null,{6,5},{6},null,{5},{6}}
	        );
	}
}
