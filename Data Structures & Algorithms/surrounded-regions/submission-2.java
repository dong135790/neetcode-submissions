class Solution {

    int[][] paths = {
        {0,-1}, {0,1}, {1,0}, {-1, 0}
    };

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] safe = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0, board, safe);
            }
            if (board[row][cols - 1] == 'O') {
                dfs(row, cols - 1, board, safe);
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(0, col, board, safe);
            }
            if (board[rows - 1][col] == 'O') {
                dfs(rows - 1, col, board, safe);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !safe[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board, boolean[][] safe) {
        safe[row][col] = true;
        for (int[] path: paths) {
            int newR = path[0] + row;
            int newC = path[1] + col;
            if (newR >= 0 && newR < board.length &&
                newC >= 0 && newC < board[0].length &&
                safe[newR][newC] == false &&
                board[newR][newC] == 'O'
            ) {
                dfs(newR, newC, board, safe);
            }
        }
    }
}
