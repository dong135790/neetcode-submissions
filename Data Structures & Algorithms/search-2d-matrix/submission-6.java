class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;
        int colL = 0;
        int colR = matrix[0].length - 1;

        while (rowL <= rowR) {
            int rowMid = rowL + (rowR - rowL)/2;
            int first = matrix[rowMid][0];
            int last = matrix[rowMid][matrix[rowMid].length -1];
            if (target < first) {
                rowR = rowMid - 1;
            } else if (target > last) {
                rowL = rowMid + 1;
            } else {
                System.out.println("Found row: " + rowMid);
                while (colL <= colR) {
                    int colMid = colL + (colR - colL) / 2;
                    if (matrix[rowMid][colMid] == target) {
                        return true;
                    } else if (matrix[rowMid][colMid] < target) {
                        colL = colMid + 1;
                    } else {
                        colR = colMid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
