class Solution {

    int[][] path = new int[][] {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, initialColor, color, sr, sc, visited);
        return image;
    }

    public void dfs(int[][] image, int initialColor, int color, int row, int col, boolean[][] visited) {
        // If we go out of bounds or if color is not the initial, return
        if (row >= image.length ||
            col >= image[0].length ||
            row < 0 ||
            col < 0 ||
            image[row][col] != initialColor ||
            visited[row][col] == true
            ) {
            return;
        }

        // If we are in bounds and color of a side is valid (same as initial) 
        // Recursive on all 4 adj sides
        image[row][col] = color;
        visited[row][col] = true;
        for (int i = 0; i < path.length; i++) {
            int nrow = row + path[i][0];
            int ncol = col + path[i][1];
            dfs(image, initialColor, color, nrow, ncol, visited);
        }
    }
}