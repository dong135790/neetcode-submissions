class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, output, 0, target);
        return output;
    }

    public void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> output, int current, int target) {
        if (current == target) {
            output.add(new ArrayList<>(subset));
            return;
        } else if (current > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            current += nums[i];
            backtrack(nums, i, subset, output, current, target);
            subset.remove(subset.size() - 1);
            current -= nums[i];
        }
    }
}

/*
R1 => i = 0 [2,2,2,2,2] -> Current = 10 -> backtrack(1)
R2 => [2,2,2,2] return
R1 => remove 2 [2,2,2] -> Current = 6 => i = 1 => [2,2,2,5] => 
R2 => return
Say we get to the end


*/