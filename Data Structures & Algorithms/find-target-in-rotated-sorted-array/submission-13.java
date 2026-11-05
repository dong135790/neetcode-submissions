class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int smallest = 1000;
        int index = 0;
        
        // Find smallest
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid - 1;
                if (nums[mid] < smallest) {
                    smallest = nums[mid];
                    index = mid;
                    // System.out.println("Smallest: " + index);
                }
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        if (nums[right] < target) {
            right = index - 1;
        } else {
            left = index;
        }
        // System.out.println("Left: " + left + " Right: " + right);
        // now everything is sorted
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
