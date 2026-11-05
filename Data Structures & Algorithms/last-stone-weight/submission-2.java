class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> b - a );
        for (int stone: stones) {
            pq.add(stone);
        }
        while (pq.size() != 1) {
            int stoneOne = pq.poll();
            stoneOne -= pq.poll();
            pq.add(stoneOne);
        }
        return pq.poll();
    }
}
