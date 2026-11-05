class Solution {
    // Atlantic is row + 1 and col + 1
    // Pacific is 0 - 1 (row + col)

    int[][] paths = {
        {0,-1}, {0,1}, {1,0}, {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Detect pacific
        // Detect atlantic
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> output = new ArrayList<>();
        for (int row = 0; row < heights.length; row++) {
            dfs(row, 0, heights, pacific);
            dfs(row, heights[0].length - 1, heights, atlantic);
        }

        for (int col = 0; col < heights[0].length; col++) {
            dfs(0, col, heights, pacific);
            dfs(heights.length - 1, col, heights, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> current = new ArrayList<>();
                    output.add(Arrays.asList(i, j));
                }
            }
        }
        return output;
    }

    public void dfs(int row, int col, int[][] heights, boolean[][] visited) {
        visited[row][col] = true;

        for (int[] path: paths) {
            int newR = path[0] + row;
            int newC = path[1] + col;
            if (newR >= 0 && newR < heights.length &&
                newC >= 0 && newC < heights[0].length &&
                !visited[newR][newC] &&
                heights[newR][newC] >= heights[row][col]
            ) {
                dfs(newR, newC, heights, visited);
            }
        }
    }
}
