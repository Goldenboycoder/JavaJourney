package Exercises.OOP2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;
import java.util.Set;
//import java.util.Stack;
import java.util.Iterator;

class TwitterUser{
    public int _userID;
    private Set<Integer> _followeesIds;
    private Set<Integer> _tweetsIds;

    public TwitterUser(int userID){
        this._userID = userID;
        _followeesIds = new HashSet<Integer>();
        _tweetsIds = new HashSet<Integer>();
    }

    public Set<Integer> getFolloweesIds(){
        return _followeesIds;
    }

    public Set<Integer> getTweetsIds(){
        return _tweetsIds;
    }

    // Followees manipulation
    public boolean addFollowee(int followeeId){
        return _followeesIds.add(followeeId);
    }
    public int removeFollowee(int followeeId){
        boolean isRemoved = _followeesIds.remove(followeeId);
        if(isRemoved){
            return followeeId;
        }
        return -1;
    }
    public boolean isFollowing(int followeeId){
        return _followeesIds.contains(followeeId);
    }

    // Tweets manipulation

    public boolean addTweet(int tweetId){
        return _tweetsIds.add(tweetId);
    }
    
    public boolean isTweetAuthor(int tweetId){
        return _tweetsIds.contains(tweetId);
    }

}


class Twitter {

    private HashMap<Integer, TwitterUser> _users;
    private static int _lastUserId;
    private static int _lastTweetId;
    private Deque<Tweet> _tweets ;

    private class Tweet{
        public int _tweetId;
        public int _authorId;

        public Tweet(int tweetId,int authorId){
            this._tweetId = tweetId;
            this._authorId = authorId;
        }
    }

    public Twitter() {
        _users = new HashMap<Integer, TwitterUser>();
        _tweets = new ArrayDeque<Tweet>();
    }
    
    private int getNewUserId(){
        _lastUserId += 1;
        return _lastUserId;
    }

    private int getNewTweetId(){
        _lastTweetId += 1;
        return _lastTweetId;
    }

    private TwitterUser checkUserExistanceOrCreate(int userId){
        if(!_users.containsKey(userId)){
            TwitterUser newUser = new TwitterUser(userId);
            _users.put(userId, newUser);
            return _users.get(userId);
        }
        else{
            return _users.get(userId);
        }
    }

    private void updateUser(TwitterUser user) {
        if(!_users.containsKey(user._userID)){
            //System.out.println(String.format("Twitter User: %d does not exist", user._userID));
            //throw new Exception(String.format("Twitter User: %d does not exist", user._userID));
        }
        else{
            _users.put(user._userID, user);
        }
    }

    public void postTweet(int userId, int tweetId){

        TwitterUser user = checkUserExistanceOrCreate(userId);
        if(user.addTweet(tweetId)){
            Tweet newTweet = new Tweet(tweetId,user._userID) ;
            _tweets.addFirst(newTweet); //.add(newTweet);
            updateUser(user);
        }
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        int maxSize = 10;

        List<Integer> latestUserTweets = new ArrayList<Integer>(maxSize);

        Iterator<Tweet> tweetIterator = _tweets .iterator();
        while(tweetIterator.hasNext()){
            Tweet nextTweet = tweetIterator.next();
            TwitterUser user = checkUserExistanceOrCreate(userId);
            if(user.isTweetAuthor(nextTweet._tweetId) || user.isFollowing(nextTweet._authorId)){
                latestUserTweets.add(nextTweet._tweetId);
            }

            if(latestUserTweets.size() == maxSize)
                break;
        }
        return latestUserTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        TwitterUser userFollower = checkUserExistanceOrCreate(followerId); //1
        TwitterUser userFollowee = checkUserExistanceOrCreate(followeeId);

        userFollower.addFollowee(userFollowee._userID);
        updateUser(userFollower);
    }
    
    public void unfollow(int followerId, int followeeId)  {
        TwitterUser userFollower = checkUserExistanceOrCreate(followerId); //1
        TwitterUser userFollowee = checkUserExistanceOrCreate(followeeId);

        userFollower.removeFollowee(followeeId);
        updateUser(userFollower);
    }
}

class Solution{

    public static void main(String args[]){
        try {
            Twitter twitter = new Twitter();
            twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
            
            System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
            
            twitter.follow(1, 2);    // User 1 follows user 2.
            twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
            
            System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
            
            twitter.unfollow(1, 2);  // User 1 unfollows user 2.
            twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        /*Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }*/
       
    }
}