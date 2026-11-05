class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> set = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];

                if (target > 0) {
                    right--;
                } else if (target < 0) {
                    left++;
                } else {
                    List<Integer> found = new ArrayList<>(Arrays.asList(
                        nums[i], 
                        nums[left], 
                        nums[right]
                    ));

                    set.add(found);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right +1]) right--;
                }
                
                
            }
        }
        return set;
    }
}
