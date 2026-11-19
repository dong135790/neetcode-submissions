class Solution {

    private int[] memo1;
    private int[] memo2;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] first = new int[nums.length - 1];
        int[] second = new int[nums.length - 1];
        memo1 = new int[nums.length - 1];
        memo2 = new int[nums.length - 1];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        for (int i = 0; i < nums.length - 1; i++) {
            first[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            second[i - 1] = nums[i];
        }
        return Math.max(dfs(first, memo1, 0), dfs(second, memo2, 0));
    }

    public int dfs(int[] nums, int[] memo, int i) {
        if (i >= nums.length) return 0;

        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(nums[i] + dfs(nums, memo, i + 2), dfs(nums, memo, i + 1));
        return memo[i];
    }
}
