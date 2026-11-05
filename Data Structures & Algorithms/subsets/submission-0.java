class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, output);
        return output;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> output) {
        // add 
        output.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1 , subset, output);
            subset.remove(subset.size() - 1);
        }
    }
}

/*
Length 1
[] [1]

2
[2] [1, 2] 

*/