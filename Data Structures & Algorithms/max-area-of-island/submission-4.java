class Solution {

    public int dfs(int[][] grid, boolean[][] visited,int row,int col) {
        int[][] neighbors = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };

        if (Math.min(row, col) < 0 || row == grid.length || col == grid[0].length || visited[row][col] == true || grid[row][col] == 0) {
            return 0;
        }
        int count = 1;
        visited[row][col] = true;
        for (int[] neighbor: neighbors) {
            int newR = row + neighbor[0];
            int newC = col + neighbor[1];
            count += dfs(grid, visited, newR, newC);
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxIslandSize = Math.max(maxIslandSize, dfs(grid,visited, row, col));
                }
            }
        }
        return maxIslandSize;
    }
}
