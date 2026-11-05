class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target > 0) {
                    right--;
                } else if (target < 0) {
                    left++;
                } else {
                    List<Integer> found = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    set.add(found);
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
