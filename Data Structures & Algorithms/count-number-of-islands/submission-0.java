class Solution {


    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (Math.min(row, col) < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == true || grid[row][col] == '0') return;
        visited[row][col] = true;
        grid[row][col] = '0';

        int[][] neighbors = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        for (int[] neighbor: neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];
            dfs(grid, visited, newRow, newCol);
        }
    }

    public int numIslands(char[][] grid) {
        int island = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, visited, row, col);
                    island++;
                }
            }
        }
        return island;
    }
}
