class Solution {

    public int bfs(int[][] grid, Deque<int[]> queue, boolean[][] visited, int fresh) {

        int minute = 0;
        int[][] neighbors = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        while(!queue.isEmpty()) {
            int qlength = queue.size();
            for (int i = 0; i < qlength; i++) {
                int[] coords = queue.poll();
                int row = coords[0];
                int col = coords[1];
                for (int[] neighbor: neighbors) {
                    int newRow = row + neighbor[0];
                    int newCol = col + neighbor[1];
                    if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        !visited[newRow][newCol] &&
                        grid[newRow][newCol] == 1
                    ) {
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        fresh--;
                    }
                }
            }
            minute++;
        }
        if (fresh == 0) {
            return minute - 1;
        } else {
            return -1;
        }
    }

    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
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
        if (fresh == 0) {
            return 0;
        }
        return bfs(grid, queue, visited, fresh);
    }
}
