class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (set.size() >= k + 1) {
                set.remove(nums[left]);
                left++;
            }
            if (!set.add(nums[right])) {
                return true;
            }
            right++;
        }
        return false;
    }
}