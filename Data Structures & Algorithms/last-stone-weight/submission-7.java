class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            int broke = top - maxHeap.poll();
            maxHeap.add(broke);
        }
        return maxHeap.isEmpty() ? 0: maxHeap.peek();
    }
}
