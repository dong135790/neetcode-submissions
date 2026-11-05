class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[i] + nums[j] + nums[z] == 0) {
                        List<Integer> current = new ArrayList<>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[z]);
                        Collections.sort(current);
                        if (set.add(current)) {
                            res.add(current);

                        }
                    }
                }
            }
        }

        return res;
    }
}
