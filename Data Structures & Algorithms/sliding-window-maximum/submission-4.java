class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // MaxHeap based off of int value
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        // Result
        int[] output = new int[nums.length - k + 1];
        int index = 0;

        // Go until we reach the end
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{i, nums[i]});
            if (i - k + 1 >= 0) {
                int left = i - k + 1;
                while (!maxHeap.isEmpty() && maxHeap.peek()[0] < left) {
                    maxHeap.poll();
                }
                output[index++] = maxHeap.peek()[1]; 
            }
        }
        return output;
    }
}

// 0 - 3 + 1 = -2
// 1 - 3 + 1 = -1
// 2 - 3 + 1 = 0