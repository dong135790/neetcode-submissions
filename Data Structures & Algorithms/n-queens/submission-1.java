class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> output = new ArrayList<>();
        backtrack(n, 0, board, output);
        return output;
    }

    public void backtrack(int n, int row, char[][] board, List<List<String>> output) {
        if (row == n) {
            List<String> valid = new ArrayList<>();
            for (char[] current_row: board){
                valid.add(new String(current_row));
            }
            output.add(valid);
            return;
        }

        for (int col = 0; col < n; col++) {
            
            // Check all directions at row, col
            if (checkRow(row, col, board) && 
                checkCol(row, col, board) &&
                checkDiag(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(n, row + 1, board, output);
                board[row][col] = '.';
            }
        }
    }

    public boolean checkRow(int row, int col, char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            if (c == col) continue;
            if (board[row][c] == 'Q') return false;
        }
        return true;
    }
    public boolean checkCol(int row, int col, char[][] board) {
        for (int r = 0; r < board.length; r++) {
            if (r == row) continue;
            if (board[r][col] == 'Q') return false;
        }
        return true;
    }
    public boolean checkDiag(int row, int col, char[][] board) {
        int r = row - 1;
        int c = col - 1;
        // Checks NW
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == 'Q') return false;
        }
        // Checks NE
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r--][c++] == 'Q') return false;
        }

        // Checks SW
        r = row + 1;
        c = col - 1;
        while (r < board.length && c >= 0) {
            if (board[r++][c--] == 'Q') return false;
        }
        // Checks SE
        r = row + 1;
        c = col + 1;
        while (r < board.length && c < board.length) {
            if (board[r++][c++] == 'Q') return false; 
        }
        return true;
    }
}
