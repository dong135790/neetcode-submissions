class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.forEach( (key, value) -> {
            maxHeap.offer(key);
        });
        int i = 0;
        while (i < k) {
            result[i] = maxHeap.poll();
            i++;
        }
        return result;
    }
}
