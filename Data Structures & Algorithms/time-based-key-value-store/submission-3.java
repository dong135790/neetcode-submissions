class TimeMap {
    private Map<String, Map<Integer, String>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new HashMap<>());
        }

        keyStore.get(key).put(timestamp ,value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) return "";

        int largest = -1;
        for (int time: keyStore.get(key).keySet()) {
            if (time <= timestamp) {
                largest = Math.max(time, largest);
            }
        }
        if (largest == -1) return "";
        return keyStore.get(key).get(largest);
    }
}
