class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] validRow = new HashSet[9];
        HashSet<Character>[] validCol = new HashSet[9];
        HashSet<Character>[] validGrid = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            validRow[i] = new HashSet<>();
            validCol[i] = new HashSet<>();
            validGrid[i] = new HashSet<>();
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    char number = board[row][col];
                    int grid = (row / 3) * 3 + (col / 3);

                    if (validRow[row].contains(number) ||
                        validCol[col].contains(number) ||
                        validGrid[grid].contains(number)
                    ) return false;

                    validRow[row].add(number);
                    validCol[col].add(number);
                    validGrid[grid].add(number);
                }
            }
        }
        return true;
    }
}
