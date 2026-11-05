class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            int next = maxHeap.poll();
            int diff = Math.abs(top - next);
            if (diff != 0) {
                maxHeap.offer(diff);
            }
        }
        return maxHeap.isEmpty() ? 0: maxHeap.peek();
    }
}
