class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> current = new ArrayList<>();
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    Collections.sort(current);
                    if (set.add(current)) {
                        res.add(current);
                    }
                    left++;
                }
            }
        }
        return res;
    }
}


// -4, -1, -1, 0, 1, 2 
