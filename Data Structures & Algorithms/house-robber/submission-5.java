class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] max = new int[nums.length + 1];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        int best = 0;
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
            best = Math.max(best, max[i]);
        }
        return best;
    }
}
