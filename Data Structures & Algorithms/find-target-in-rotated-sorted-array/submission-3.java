class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int left = nums[min];
            int right = nums[max];
            int center = nums[mid];
            if (left == target) return min;
            if (right == target) return max;
            if (center == target) return mid;

            // Right side is sorted
            if (center < right) {
                if (target > center && target < right) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            // Left side is sorted
            } else {
                if (target < center && target > left) {
                    max = mid - 1;
                }  else {
                    min = mid + 1;
                }
            }

        }
        return -1;
    }
}
