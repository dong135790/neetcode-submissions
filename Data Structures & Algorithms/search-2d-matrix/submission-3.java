class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][col - 1]);
            if (matrix[i][col - 1] < target) {
                row++;
            }
        }
        if (row == matrix.length) return false;
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] > target) {
                // Go left
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                // Go right
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
/*
1  3  5  7
10 11 16 20
23 30 34 60


1 1

*/