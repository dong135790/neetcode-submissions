class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(candidates, 0, target, subset, output);
        return new ArrayList<>(output);
    }

    public void backtrack(int[] candidates, int start, int target, List<Integer> subset, List<List<Integer>> output) {
        if (0 == target) {
            output.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            subset.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], subset, output);
            subset.remove(subset.size() - 1);
        }
    }
}
/*
1 2 2 4 5 6 9



*/