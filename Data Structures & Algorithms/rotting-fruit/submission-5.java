class Solution {

    public int bfs(int[][] grid, Deque<int[]> queue, boolean[][] visited) {
        int minutes = -1;
        int[][] neighbors = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        while (!queue.isEmpty()) {
            int qlength = queue.size();
            for (int i = 0; i < qlength; i++) {
                int[] coord = queue.poll();
                int row = coord[0];
                int col = coord[1];
                for (int[] neighbor: neighbors) {
                    int newRow = row + neighbor[0];
                    int newCol = col + neighbor[1];
                    if (newRow >= 0 &&
                            newRow < grid.length &&
                            newCol >= 0 &&
                            newCol < grid[0].length &&
                            !visited[newRow][newCol] &&
                            grid[newRow][newCol] == 1
                            ) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            minutes++;
        }
        return minutes == -1 ? 0 : minutes;
    }

    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int fresh = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] {row, col});
                    visited[row][col] = true;
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int min = bfs(grid, queue, visited);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) return -1;
            }
        }
        return min;
    }
}
