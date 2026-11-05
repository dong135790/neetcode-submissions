class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), output);
        return output;
    }

    public void backtrack(int n, int k, int start, List<Integer> subset, List<List<Integer>> output) {
        if (subset.size() == k) {
            output.add(new ArrayList<>(subset));
            return;
        } 

        for (int i = start; i <= n; i++) {
            subset.add(i);
            backtrack(n, k, i + 1, subset, output);
            subset.remove(subset.size() - 1);
        }
    }
}