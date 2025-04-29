class User {
    int userId;
    Set<Integer> following=new HashSet<>();
    Queue<Tweet> q=new LinkedList<>();

    public User(int userId) {
        this.userId=userId;
    }
}

class Tweet {
    static int tweetCnt=0;
    int tweetId;
    int userId;
    int tweetNum;

    public Tweet(int tweetId,int userId) {
        tweetCnt++;
        this.tweetId=tweetId;
        this.userId=userId;
        tweetNum=tweetCnt;
    }
}

class Twitter {
    Map<Integer,User> users;

    public Twitter() {
        users=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet=new Tweet(tweetId,userId);
        if (!users.containsKey(userId))
            users.put(userId,new User(userId));

        User currUser=users.get(userId);
        currUser.q.add(newTweet);

        if (currUser.q.size()>10)
            currUser.q.poll();
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        if (!users.containsKey(userId))
            return res;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.tweetNum, y.tweetNum));
        User currUser=users.get(userId);

        pq.addAll(currUser.q);

        for (int uid: currUser.following) {
            if (!users.containsKey(uid))
                continue;

            pq.addAll(users.get(uid).q);

            while (pq.size()>10)
                pq.poll();
        }

        while (!pq.isEmpty())
            res.add(pq.poll().tweetId);

        Collections.reverse(res);
            
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId))
            users.put(followerId,new User(followerId));

        User follower=users.get(followerId);
        follower.following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower=users.get(followerId);
        follower.following.remove(followeeId);
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