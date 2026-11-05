class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Define your variables
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        // Loop thru each item in list and determine their frequency
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Loop thru each item in map and add it to heap. Since we defined our heap to sort based off of value of the key, this creates a MaxHeap based off of the value (frequency)
        for (int set: map.keySet()) {
            minHeap.offer(set);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // Remove top items in maxHeap k times and store it in result
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
