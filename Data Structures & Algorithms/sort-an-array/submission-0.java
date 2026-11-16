class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
        }
        int[] output = new int[nums.length];
        int i = 0;
        while (!minHeap.isEmpty()) {
            output[i++] = minHeap.poll();
        }
        return output;
    }
}