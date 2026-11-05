class Solution {

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        List<List<String>> output = new ArrayList<>();
        backtrack(n, 0, board, output);
        return output;
    }

    public void backtrack(int n, int row, String[][] board, List<List<String>> output) {
        if (row == n) {
            List<String> valid = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                String current = "";
                for (int c = 0; c < n; c++) {
                    if (board[r][c] == null) {
                        current += ".";
                    } else {
                        current += board[r][c];
                    }
                }
                valid.add(current);
            }
            output.add(valid);
            return;
        }

        for (int col = 0; col < n; col++) {
            
            // Check all directions at row, col
            if (checkRow(row, col, board) && 
                checkCol(row, col, board) &&
                checkDiag(row, col, board)) {
                board[row][col] = "Q";
                backtrack(n, row + 1, board, output);
                board[row][col] = null;
            }
        }
    }

    public boolean checkRow(int row, int col, String[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            if (c == col) continue;
            if (board[row][c] == "Q") return false;
        }
        return true;
    }
    public boolean checkCol(int row, int col, String[][] board) {
        for (int r = 0; r < board.length; r++) {
            if (r == row) continue;
            if (board[r][col] == "Q") return false;
        }
        return true;
    }
    public boolean checkDiag(int row, int col, String[][] board) {
        int r = row - 1;
        int c = col - 1;
        // Checks NW
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == "Q") return false;
        }
        // Checks NE
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r--][c++] == "Q") return false;
        }

        // Checks SW
        r = row + 1;
        c = col - 1;
        while (r < board.length && c >= 0) {
            if (board[r++][c--] == "Q") return false;
        }
        // Checks SE
        r = row + 1;
        c = col + 1;
        while (r < board.length && c < board.length) {
            if (board[r++][c++] == "Q") return false; 
        }
        return true;
    }
}
