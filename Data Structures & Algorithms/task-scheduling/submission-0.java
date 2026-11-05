class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey() - 'A', entry.getValue()});
        }
        int cycles = 0;
        Queue<int[]> cooldown = new LinkedList<>();
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            cycles++;
            if (!cooldown.isEmpty() && cooldown.peek()[2] <= cycles) {
                int[] ready = cooldown.poll();

                maxHeap.offer(new int[]{
                    ready[0],
                    ready[1]
                });
            }

            // Run a task if one is available
            if (!maxHeap.isEmpty()) {
                int[] max = maxHeap.poll();

                // We just used one copy
                max[1]--;

                // If more copies remain, put it on cooldown
                if (max[1] > 0) {
                    cooldown.offer(new int[]{
                        max[0],
                        max[1],
                        cycles + n + 1
                    });
                }
            }
        }
        return cycles;
    }
}
