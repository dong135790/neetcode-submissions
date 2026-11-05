class Solution {
    public int findMin(int[] nums) {
        int smallest = 1000;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println(mid);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                smallest = Math.min(smallest, nums[mid]);
            }
        }
        return smallest;
    }
}
