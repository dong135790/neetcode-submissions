class Solution {

    public int bfs(int[][] grid, ArrayDeque<int[]> queue, boolean[][] visited, int fresh) {
        int[][] neighbors = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        int minutes = 0;
        while (!queue.isEmpty()) {
            int qlength = queue.size();
            for (int i = 0; i < qlength; i++) {
                int[] coords = queue.poll();
                int row = coords[0];
                int col = coords[1];
                for (int[] neighbor: neighbors) {
                    int newR = row + neighbor[0];
                    int newC = col + neighbor[1];
                    if (
                        newR >= 0 && newR < grid.length &&
                        newC >= 0 && newC < grid[0].length &&
                        visited[newR][newC] == false &&
                        grid[newR][newC] == 1
                    ) {
                        grid[newR][newC] = 2;
                        queue.add(new int[] {newR, newC});
                        visited[newR][newC] = true;
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        if (fresh > 0) {
            return -1;
        } else {
            return minutes -1;
        }
    }


    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int fresh = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[] {row, col});
                    visited[row][col] = true;
                }
                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        return bfs(grid, queue, visited, fresh);
    }
}
