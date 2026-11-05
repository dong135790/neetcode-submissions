class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid >= nums.length) {
                break;
            }
            if (target > nums[mid]) {
                // Go right
                left = mid + 1;
            } else if (target < nums[mid]) {
                // Go left
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
/* 
nums=[-1,0,3,5,9,12] length = 6 midIndex = 3 
target=9
    target > mid
1st 9 > 5 so we go right 
Consider Index 4, 5
*/

