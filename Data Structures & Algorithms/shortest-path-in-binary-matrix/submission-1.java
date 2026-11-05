class Solution {

    public int bfs(int[][] grid, int[][] visited, Deque<int[]> queue, int row, int col) {
        queue.add(new int[2]);   // This is {0,0} since we start there
        visited[0][0] = 1;       // Make visited @ index {0,0} = 1 so we dont revisit it.
        int length = 1;

        while(!queue.isEmpty()) {
            // Check the size of the queue (should be 1 since our grid[0][0] is 0)
            int qlength = queue.size();
            System.out.println(qlength);
            for (int i = 0; i < qlength; i++) {
                // Get the last element from queue
                int[] coord = queue.poll();
                row = coord[0];
                col = coord[1];
                // If that coord is at the bottom right, we are done
                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    return length;
                }

                // Now we have to go find our neighbors (should have 8)
                int[][] neighbors = {
                    {row, col + 1},
                    {row, col - 1},
                    {row + 1, col},
                    {row - 1, col},
                    {row - 1, col - 1},
                    {row - 1, col + 1},
                    {row + 1, col - 1},
                    {row + 1, col + 1}
                };
                // Look thru each neighbor and check to see if that place is valid/visited
                for (int j = 0; j < neighbors.length; j++) {
                    int newRow = neighbors[j][0];
                    int newCol = neighbors[j][1];
                    if (newRow < 0 ||
                    newCol < 0 ||
                    newRow >= grid.length ||
                    newCol >= grid[0].length ||
                    grid[newRow][newCol] == 1 ||
                    visited[newRow][newCol] == 1
                    ) {
                        continue;
                    }
                    queue.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = 1;
                }
            }
            length++;
        }
        if (row != grid.length -1 || col != grid[0].length - 1) return -1;
        return length;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[row][col];
        int distance = bfs(grid, visited, queue, 0, 0);
        return distance;
    }
}