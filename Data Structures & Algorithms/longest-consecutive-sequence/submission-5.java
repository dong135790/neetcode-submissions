class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
        }
        int max = 1;
        int consecutive = 1;
        int last = minHeap.poll();
        while (!minHeap.isEmpty()) {
            if (minHeap.peek() == last + 1) {
                consecutive++;
                if (max < consecutive) max = consecutive;

            }
            if (minHeap.peek() > last + 1) {
                consecutive = 1;
            }
            last = minHeap.poll();
        }
        return max;
    }
}
// -4, -3, -2, -1, 1, 2, 3, 4, 6, 7, 8, 9