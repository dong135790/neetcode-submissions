class Solution {

    public int dfs(int[][] grid, boolean[][] visited,int row,int col) {
        int[][] neighbors = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };
        int count = 1;

        if (Math.min(row, col) < 0 || row == grid.length || col == grid[0].length || visited[row][col] == true || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;

        count += 
        dfs(grid, visited, row + 1, col) +
        dfs(grid, visited, row - 1, col) +
        dfs(grid, visited, row, col + 1) + 
        dfs(grid, visited, row, col - 1);

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int size = dfs(grid, visited, row, col);
                    System.out.println(size);
                    if (size > maxIslandSize) {
                        maxIslandSize = size;
                    }
                }
            }
        }
        return maxIslandSize;
    }
}
