class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        int right = 1;
        set.add(nums[0]);
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                return true;
            }
            if (set.size() < k) {
                set.add(nums[right]);
                right++;
            } else {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}