class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            top -= maxHeap.poll();
            maxHeap.add(top);
        }
        return maxHeap.peek();
    }
}
