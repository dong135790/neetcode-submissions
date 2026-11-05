class Twitter {
    HashMap<Integer, PriorityQueue<int[]>> map;
    HashMap<Integer, HashSet<Integer>> following;
    int time;
    public Twitter() {
        this.map = new HashMap<>();
        this.following = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new PriorityQueue<>((a,b) -> Integer.compare(b[2], a[2])));
        }
        map.get(userId).offer(new int[] {userId, tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> combined = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        if (map.containsKey(userId)) {
            combined.addAll(map.get(userId));
        }

        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                combined.addAll(map.get(followeeId));
            }
        }

        while (!combined.isEmpty() && feed.size() < 10) {
            feed.add(combined.poll()[1]);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!this.following.containsKey(followerId)) {
            this.following.put(followerId, new HashSet<>());
        }
        this.following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (this.following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
