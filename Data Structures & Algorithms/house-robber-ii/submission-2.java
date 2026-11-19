class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] first = new int[nums.length - 1];
        int[] second = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            first[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            second[i - 1] = nums[i];
        }

        int[] memo1 = new int[first.length];
        memo1[0] = first[0];
        memo1[1] = Math.max(first[0], first[1]);
        int max1 = Math.max(first[0], first[1]);
        for (int i = 2; i < first.length; i++) {
            memo1[i] = Math.max(first[i] + memo1[i - 2], memo1[i - 1]);
            max1 = Math.max(memo1[i], max1);
        }
        int[] memo2 = new int[second.length];
        memo1[0] = second[0];
        memo1[1] = Math.max(second[0], second[1]);
        int max2 = Math.max(second[0], second[1]);
        for (int i = 2; i < second.length; i++) {
            memo1[i] = Math.max(second[i] + memo1[i - 2], memo1[i - 1]);
            max2 = Math.max(memo1[i], max2);
        }
        return Math.max(max1, max2);
    }
}
