class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = 0;
        int max = matrix.length * matrix[0].length - 1;
        while (min <= max) {
            int mid = min + (max - min)/2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
