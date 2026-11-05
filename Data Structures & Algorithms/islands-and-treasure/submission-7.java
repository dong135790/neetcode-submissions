class Solution {
    int INF = Integer.MAX_VALUE;

    int[][] paths = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col, 0});
                }
            }
        }
        bfs(grid, queue);
    }

    public void bfs(int[][] grid, Deque<int[]> queue) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!queue.isEmpty()) {
            int[] coord = queue.poll();
            int row = coord[0];
            int col = coord[1];
            int distance = coord[2];
            visited[row][col] = true;
            
            if (grid[row][col] != Integer.MAX_VALUE) {
                grid[row][col] = Math.min(distance, grid[row][col]);
            }

            for (int[] path: paths) {
                int newR = row + path[0];
                int newC = col + path[1];
                if (newR < 0 || newR >= grid.length ||
                    newC < 0 || newC >= grid[0].length ||
                    visited[newR][newC] == true ||
                    grid[newR][newC] == -1
                ) continue;
                grid[newR][newC] = distance + 1;
                visited[newR][newC] = true;
                queue.offer(new int[] {newR, newC, distance + 1});
            }
        }
    }
}