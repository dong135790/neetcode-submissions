class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[] max = new int[]{0};
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col, grid, max, new int[]{0});
                }
            }
        }
        return max[0];
    }

    public void dfs(int row, int col, int[][] grid, int[] max, int[] current) {
        if (row >= grid.length || row < 0 ||
            col >= grid[0].length || col < 0 ||
            grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;
        current[0]++;
        max[0] = Math.max(current[0], max[0]);

        dfs(row + 1, col, grid, max, current);
        dfs(row - 1, col, grid, max, current);
        dfs(row, col + 1, grid, max, current);
        dfs(row, col - 1, grid, max, current);
    }
}
