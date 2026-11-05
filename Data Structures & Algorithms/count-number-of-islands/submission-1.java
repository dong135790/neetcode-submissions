class Solution {


    public void bfs(char[][] grid, boolean[][] visited, int row, int col) {

        int[][] neighbors = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int qlength = queue.size();
            for (int i = 0; i < qlength; i++) {
                int[] coord = queue.poll();
                int r = coord[0];
                int c = coord[1];
                for (int[] neighbor: neighbors) {
                    int newRow = r + neighbor[0];
                    int newCol = c + neighbor[1];
                    if (Math.min(newRow, newCol) < 0 || newRow >= grid.length || newCol >= grid[0].length || visited[newRow][newCol] == true || grid[newRow][newCol] == '0') {
                        continue;
                    } else {
                        queue.add(new int[] {newRow, newCol});
                        grid[newRow][newCol] = '0';
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int island = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    bfs(grid, visited, row, col);
                    island++;
                }
            }
        }
        return island;
    }
}
