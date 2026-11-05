class Solution {

    int[][] paths = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0;  col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, row, col, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) return true;

        if (row >= board.length ||
            row < 0 ||
            col >= board[0].length ||
            col < 0 ||
            visited[row][col] ||
            word.charAt(index) != board[row][col]
        ) return false;
        

        visited[row][col] = true;

        for (int[] path: paths) {
            int newR = row + path[0];
            int newC = col + path[1];
            if (dfs(board, word, newR, newC, index+1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;

        return false;
    }
}
