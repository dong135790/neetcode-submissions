class Solution {
    public int shortestPath(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        int distance = 0;
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        int[][] neighbors = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        while (!queue.isEmpty()) {
            int qlength = queue.size();
            for (int i = 0; i < qlength; i++) {
                int[] coords = queue.poll();
                int row = coords[0];
                int col = coords[1];
                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    return distance;
                }
                for (int[] neighbor: neighbors) {
                    int newRow = row + neighbor[0];
                    int newCol = col + neighbor[1];
                    if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    !visited[newRow][newCol] &&
                    grid[newRow][newCol] == 0) {
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}
