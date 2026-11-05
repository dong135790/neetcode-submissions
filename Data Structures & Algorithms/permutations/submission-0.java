class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, 0, unique, output, visited);
        return output;
    }

    public void backtrack(int[] nums, int start, List<Integer> unique, List<List<Integer>> output, boolean[] visited) {
        if (unique.size() == nums.length) {
            output.add(new ArrayList<>(unique));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            unique.add(nums[i]);
            backtrack(nums, 0, unique, output, visited);
            unique.remove(unique.size() - 1);
            visited[i] = false;
        }
    }
}
