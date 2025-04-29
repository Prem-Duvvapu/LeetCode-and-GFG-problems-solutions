class User {
    int userId;
    Set<Integer> followers=new HashSet<>();
    Set<Integer> following=new HashSet<>();
    Deque<Tweet> q=new ArrayDeque<>();

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
        // for (Tweet t: pq)
        //     System.out.print(t.tweetId+" ");
        for (int uid: currUser.following) {
            while (pq.size()>10)
                pq.poll();
            pq.addAll(users.get(uid).q);
        }

        while (pq.size()>10)
            pq.poll();

        int cnt=0;

        while (!pq.isEmpty() && cnt<10) {
            res.add(pq.poll().tweetId);
            cnt++;
        }
        Collections.reverse(res);
            
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId))
            users.put(followerId,new User(followerId));

        if (!users.containsKey(followeeId))
            users.put(followeeId,new User(followeeId));

        User follower=users.get(followerId);
        User followee=users.get(followeeId);

        follower.following.add(followeeId);
        followee.followers.add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower=users.get(followerId);
        User followee=users.get(followeeId);

        follower.following.remove(followeeId);
        followee.followers.remove(followerId);
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