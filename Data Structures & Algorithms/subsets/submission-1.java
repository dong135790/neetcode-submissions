class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num: nums) {
            int size = output.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(output.get(i));
                subset.add(num);
                output.add(subset);
            }
        }
        return output;
    }

}
