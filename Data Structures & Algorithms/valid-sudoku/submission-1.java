class Solution {

    public boolean checkRow(char[][] board, int row) {
        char[] currentRow = board[row];
        HashSet<Character> set = new HashSet<>();
        for (char letter : currentRow) {
            if (letter != '.') {
                if (set.contains(letter)) {
                    return false;
                }
                set.add(letter);
            }
        }
        return true;
    }

    public boolean checkCol(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.') {
                if (!set.add(board[i][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkGrid(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                char val = board[r][c];
                if (val != '.') {
                    if (set.contains(val)) {
                        return false;
                    }
                    set.add(val);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (!(checkRow(board, row) && checkCol(board, col) && checkGrid(board, row, col))) {
                    return false;
                }
            }
        }
        return true;
    }
}
