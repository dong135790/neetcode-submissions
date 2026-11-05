class Solution {

    int[][] paths = {
        {0,1}, {0,-1}, {-1,0}, {1,0}
    };

    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[] {i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (fresh == 0) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                for (int[] path: paths) {
                    int newR = row + path[0];
                    int newC = col + path[1];
                    if (newR >= grid.length || newR < 0 ||
                        newC >= grid[0].length || newC < 0 ||
                        grid[newR][newC] != 1
                    ) continue;

                    grid[newR][newC] = 2;
                    queue.offer(new int[] {newR, newC});
                    fresh--;
                }
            }
            minutes++;
        }
        return fresh > 0 ? -1 : minutes;
    }
}
