public class Twitter {

    HashMap<Integer, List<Tweet>> post;
    HashMap<Integer, Set<Integer>> followMap;
    Integer time;
    
    class Tweet {
        int timeStamp;
        int tweetId;
        public Tweet() {};
        public Tweet(int time, int tweetId) {
            this.timeStamp = time;
            this.tweetId = tweetId;
        }
    }
    
    
    /** Initialize your data structure here. */
    public Twitter() {
        post = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(time++,tweetId);
        
        if(!post.containsKey(userId)) {
            List<Tweet> list = new ArrayList<>();
            post.put(userId, list);
        }
        
        post.get(userId).add(tweet);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = new HashSet<>();
        set.add(userId);
        if(followMap.containsKey(userId)) {
            set.addAll(followMap.get(userId));
        }
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> (b.timeStamp - a.timeStamp)); 
        for(Integer oneUser : set) {
            List<Tweet> list = post.get(oneUser);
            for(Tweet oneTweet : list) {
                pq.add(oneTweet);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            if(!pq.isEmpty()) {
                result.add(pq.poll().tweetId);
            } else {
                break;
            }
        }
        
        return result;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        if(!followMap.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
            followMap.put(followerId, set);
        }
        
        if(!followMap.get(followerId).contains(followeeId)) {
            followMap.get(followerId).add(followeeId);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        if (followMap.containsKey(followerId)) {
            Set<Integer> set = followMap.get(followerId);
            
            if (set.contains(followeeId)) {
                set.remove(followeeId);
                if(set.size() == 0) {
                    followMap.remove(followerId);
                }
            }
        }
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