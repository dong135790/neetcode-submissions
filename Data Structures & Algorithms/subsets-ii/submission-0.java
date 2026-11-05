class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, output);

        return new ArrayList<>(output);
    }

    public void backtrack(int[] nums, int start, List<Integer> subset, Set<List<Integer>> output) {
        output.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, output);
            subset.remove(subset.size() - 1);
        }

    }
}
