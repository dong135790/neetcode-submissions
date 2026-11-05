class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = 0;
        int max = matrix.length * matrix[0].length - 1;
        int colL = matrix[0].length;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int row = mid / colL;
            int col = mid % colL;
            System.out.println(row);
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
// 11 /3 = 3 ||| 11 % 3 = 2