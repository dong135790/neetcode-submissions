class Solution {

    int[][] paths = new int[][] {
        {0, -1},
        {0, 1},
        {1, 0},
        {-1, 0},
    };
// R: 0 C: 2
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, visited, word, 0, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }

        if (row >= board.length ||
            row < 0 ||
            col >= board[0].length ||
            col < 0 ||
            board[row][col] != word.charAt(index) ||
            visited[row][col]
        ) {
            return false;
        }

        visited[row][col] = true;

        for (int[] path: paths) {
            int newr = row + path[0];
            int newc = col + path[1];
            if (dfs(board, visited, word, index + 1, newr, newc)) {
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }
}
