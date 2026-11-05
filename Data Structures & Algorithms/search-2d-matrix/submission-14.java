class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mrow = mid / col;
            int mcol = mid % col;
            if (matrix[mrow][mcol] == target) {
                return true;
            } else if (matrix[mrow][mcol] > target) {
                // Go left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
/*
l = 0
r = 4

mid = 2 ==> 4
mrow = 1;
mcol = 1;
*/ 