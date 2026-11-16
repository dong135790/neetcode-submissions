class NumMatrix {
    
    public int[][] diagram;

    public NumMatrix(int[][] matrix) {
        diagram = new int[matrix.length][matrix[0].length];
        diagram[0][0] = matrix[0][0];
        for (int row = 1; row < matrix.length; row++) {
            diagram[row][0] = diagram[row - 1][0] + matrix[row][0];
        }

        for (int col = 1; col < matrix[0].length; col++) {
            diagram[0][col] = diagram[0][col - 1] + matrix[0][col];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                diagram[i][j] = matrix[i][j] +
                                diagram[i][j - 1] +
                                diagram[i - 1][j] -
                                diagram[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int bottomRight = diagram[row2][col2];
        // upper left of matrix
        if (row1 == 0 && col1 == 0) {
            return bottomRight;
        } 
        if (row1 == 0) {
            return bottomRight - diagram[row2][col1-1];
        }

        if (col1 == 0) {
            return bottomRight - diagram[row1 - 1][col2];
        }
        return bottomRight - diagram[row1 - 1][col2] - diagram[row2][col1 -1 ] + diagram[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */