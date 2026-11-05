class Solution {

    int[][] paths = {
        {0, -1}, {0, 1}, {1, 0}, {-1, 0}
    };
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row >= grid.length || row < 0 ||
            col >= grid[0].length || col < 0 ||
            grid[row][col] == '0') {
                return;
        }

        grid[row][col] = '0';

        for (int[] path : paths) {
            int newR = row + path[0];
            int newC = col + path[1];
            dfs(newR, newC, grid);
        }

    }
}
