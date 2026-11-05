class TimeMap {
    private Map<String, List<Pair>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> value = keyStore.getOrDefault(key, new ArrayList<>());
        String result = "";

        int left = 0;
        int right = value.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value.get(mid).getKey() <= timestamp) {
                result = value.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static class Pair {
        private final Integer key;
        private final String value;

        public Pair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
