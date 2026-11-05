class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (true) {
            fast = nums[fast];
            slow = nums[slow];
            if (fast == slow) {
                return fast;
            }
        }
    }
}
// slow and fast pointer <--- 