class MyHashMap {
    public int[] map;
    public boolean[] contains;
    public MyHashMap() {
        map = new int[1000001];
        contains = new boolean[1000001];
    }
    
    public void put(int key, int value) {
        map[key] = value;
        contains[key] = true;
    }
    
    public int get(int key) {
        if (contains[key]) {
            return map[key];
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        map[key] = 0;
        contains[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */