class LRUCache {

    int capacity;
    HashMap<Integer, Integer> map;
    LinkedHashSet<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        } else if (map.size() == capacity) {
            int oldest = queue.iterator().next();
            queue.remove(oldest);
            map.remove(oldest);
        }
        map.put(key, value);
        queue.add(key);
    }
}