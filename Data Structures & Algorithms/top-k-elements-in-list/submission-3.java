class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Define your variables
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        // Loop thru each item in list and determine their frequency
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Loop thru each item in map and add it to heap. Since we defined our heap to sort based off of value of the key, this creates a MaxHeap based off of the value (frequency)
        for (int set: map.keySet()) {
            maxHeap.offer(set);
        }
        // Remove top items in maxHeap k times and store it in result
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
