class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int rowEnd = matrix.length - 1;
        while (row <= rowEnd) {
            int rowMid = row + (rowEnd - row) / 2;
            int start = matrix[rowMid][0];
            int end = matrix[rowMid][matrix[0].length - 1];
            if (target < start) {
                rowEnd = rowMid - 1;
            } else if (target > end) {
                row = rowMid + 1;
            } else {
                System.out.println(rowMid);
                int left = 0;
                int right = matrix[rowMid].length;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[rowMid][mid] == target) {
                        return true;
                    } else if (target < matrix[rowMid][mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
