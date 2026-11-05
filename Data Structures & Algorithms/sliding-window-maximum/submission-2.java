class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int right = 0; right < nums.length; right++) {
            int left = right - k + 1;
            maxHeap.offer(new int[]{right, nums[right]});

            if (left >= 0) {
                // Remove expired elements
                while (!maxHeap.isEmpty() && maxHeap.peek()[0] < left) {
                    maxHeap.poll();
                }
                // Now heap contains window elements so peek and add
                int[] top = maxHeap.peek();
                result[index++] = top[1];
            }

        }
        return result;
    }
}

//  Length 7. k = 3
// 